package cn.ght.demo.mapper;

import cn.ght.demo.entity.Role;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * @Author: ght
 * @Date: 2020/11/24
 */
public interface RoleMapper extends BaseMapper<Role> {
    List<Role> getRolesByUserId(Long userId);
}
