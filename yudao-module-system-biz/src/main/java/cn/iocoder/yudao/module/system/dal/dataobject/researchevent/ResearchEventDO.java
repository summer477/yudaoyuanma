package cn.iocoder.yudao.module.system.dal.dataobject.researchevent;

import lombok.*;
import java.util.*;
import java.time.LocalDateTime;
import java.time.LocalDateTime;
import java.time.LocalDateTime;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.*;
import cn.iocoder.yudao.framework.mybatis.core.dataobject.BaseDO;

/**
 * 投研活动与会议 DO
 *
 * @author 芋道源码
 */
@TableName("system_research_event")
@Data
@ToString(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ResearchEventDO extends BaseDO{

    /**
     * id
     */
    @TableId
    private Long id;
    /**
     * 发起投研活动的组织机构
     */
    private String organizer;
    /**
     * 投研活动名称
     */
    private String activityName;
    /**
     * 调研行业
     */
    private String industry;
    /**
     * 投研活动时间
     */
    private String activityTime;

    /**
     * 开始时间
     */
    private String startTime;
    /**
     * 结束时间
     */
    private String endTime;
}