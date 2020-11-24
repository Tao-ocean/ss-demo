package cn.ght.demo.service;

import cn.ght.demo.entity.SysUser;
import cn.ght.demo.mapper.UserMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: ght
 * @Date: 2020/11/24
 */
@Service("userService")
public class UserService extends ServiceImpl<UserMapper, SysUser> {
}
