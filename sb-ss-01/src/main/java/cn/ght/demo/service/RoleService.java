package cn.ght.demo.service;

import cn.ght.demo.entity.Role;
import cn.ght.demo.mapper.RoleMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * @Author: ght
 * @Date: 2020/11/24
 */
@Service("roleService")
public class RoleService extends ServiceImpl<RoleMapper, Role> {
}
