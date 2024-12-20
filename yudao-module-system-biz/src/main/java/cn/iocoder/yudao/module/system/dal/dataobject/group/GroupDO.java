package cn.iocoder.yudao.module.system.dal.dataobject.group;

import lombok.*;
import java.util.*;
import java.time.LocalDateTime;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.*;
import cn.iocoder.yudao.framework.mybatis.core.dataobject.BaseDO;

/**
 * 用户组 DO
 *
 * @author 芋道源码
 */
@TableName("system_group")//表示与system_group进行交互
@Data//自动生成get set tostring equals() 和 hashCode() 方法
//@KeySequence("system_group_seq") // 用于 Oracle、PostgreSQL、Kingbase、DB2、H2 数据库的主键自增。如果是 MySQL 等数据库，可不写。
//@EqualsAndHashCode(callSuper = true)//自动生成 equals() 和 hashCode() 方法
//@ToString(callSuper = true)//自动生成类的 toString() 方法
@Builder//使用构建者模式（Builder Pattern）创建对象
@NoArgsConstructor//生成无参构造方法
@AllArgsConstructor//生成包含所有属性的构造方法
public class GroupDO extends BaseDO {

    /**
     * 编号
     */
    @TableId
    private Long id;
    /**
     * 名字
     */
    private String name;
    /**
     * 描述
     */
    private String description;
    /**
     * 状态
     */
    private Integer status;

}