package cn.ght.demo.service;

import cn.ght.demo.entity.Role;
import cn.ght.demo.entity.SysUser;
import cn.ght.demo.mapper.RoleMapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author: ght
 * @Date: 2020/11/24
 */
@Service("customerDetailsService")
public class CustomerDetailsService implements UserDetailsService{
    @Resource
    private UserService userService;

    @Resource
    private RoleMapper roleMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        List<GrantedAuthority> authorities = new ArrayList<>();

        SysUser sysUser = this.userService.getOne(new QueryWrapper<SysUser>().eq("username", username));
        if (null == sysUser) {
            throw new UsernameNotFoundException("用户名不存在");
        }
        // 添加权限
        List<Role> roles = this.roleMapper.getRolesByUserId(sysUser.getUserId());
        for (Role role : roles) {
            authorities.add(new SimpleGrantedAuthority(role.getRoleName()));
        }
        return new User(sysUser.getUsername(),sysUser.getPassword(),authorities);
    }
}
