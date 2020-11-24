package cn.ght.demo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @Author: ght
 * @Date: 2020/11/24
 */
@Data
@TableName("tb_role")
public class Role {
    @TableId(type = IdType.AUTO)
    private Long roleId;
    private String roleName;
}
