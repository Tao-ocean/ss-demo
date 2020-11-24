package cn.ght.demo.mapper;

import cn.ght.demo.entity.SysUser;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * @Author: ght
 * @Date: 2020/11/24
 */
public interface UserMapper extends BaseMapper<SysUser> {
    List<SysUser> findAll();
}
