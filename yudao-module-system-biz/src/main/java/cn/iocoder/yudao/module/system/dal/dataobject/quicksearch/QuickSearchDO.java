package cn.iocoder.yudao.module.system.dal.dataobject.quicksearch;

import lombok.*;
import java.util.*;
import java.time.LocalDateTime;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.*;
import cn.iocoder.yudao.framework.mybatis.core.dataobject.BaseDO;

/**
 * 快搜热词 DO
 *
 * @author 芋道源码
 */
@TableName("system_quick_search")
@KeySequence("system_quick_search_seq") // 用于 Oracle、PostgreSQL、Kingbase、DB2、H2 数据库的主键自增。如果是 MySQL 等数据库，可不写。
@Data
@ToString(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class QuickSearchDO {

    /**
     * 编号
     */
    @TableId
    private Long id;
    /**
     * 快搜热词
     */
    private String keyword;
    /**
     * 词ID
     */
    private Integer wordId;
    /**
     * 排序ID
     */
    private Integer rankId;
    /**
     * 点击量
     */
    private Integer clicks;
    /**
     * 是否置顶
     */
    private Integer isTop;

    /**
     * 发起时间
     */
    private String createTime;
    /**
     * 结束时间
     */
    private String updateTime;

    private Integer deleted;

    private String updater;
    private String creator;

}