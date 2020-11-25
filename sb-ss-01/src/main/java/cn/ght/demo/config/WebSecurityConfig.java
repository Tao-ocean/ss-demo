package cn.ght.demo.config;

import cn.ght.demo.service.CustomerDetailsService;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.annotation.Resource;

/**
 * @Author: ght
 * @Date: 2020/11/24
 */
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Resource
    private CustomerDetailsService customerDetailsService;

    /**
     * 认证管理器配置方法，用来配置AuthenticationManager
     * UserDetails相关配置，包括PasswordEncoder
     */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

        auth.userDetailsService(customerDetailsService).passwordEncoder(new PasswordEncoder() {
            @Override
            public String encode(CharSequence rawPassword) {
                return rawPassword.toString();
            }

            @Override
            public boolean matches(CharSequence rawPassword, String encodedPassword) {
                return encodedPassword.equals(rawPassword.toString());
            }
        });
    }

    /**
     * 安全过滤器链配置方法
     * 用来配置HttpSecurity，HttPSecurity用于构建一个安全过滤器链SecurityFilterChain
     * SecurityFilterChain最终会被注入核心过滤器
     *
     * HttpSecurity 需要很多配置，通过它来进行自定义安全访问策略
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .anyRequest().authenticated()
                .and()
                .formLogin().loginPage("/login")
                .defaultSuccessUrl("/").permitAll();
        http.csrf().disable();
    }

    /**
     * 核心过滤器配置方法，用来配置WebSecurity
     *
     * 而WebSecurity是基于Servlet Filter用来配置springSecurityFilterChain
     *
     * springSecurityFilterChain又被委托给了Spring Security核心过滤器Bean DelegatingFilterProxy
     * 一般不自定义WebSecurity，使用较多的是ignoring()方法来忽略Spring Security对静态资源的控制
     */
    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/css/**","/js/**");
    }
}
