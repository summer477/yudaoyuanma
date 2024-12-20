package cn.iocoder.yudao.module.system.dal.dataobject.researchevent;


import cn.iocoder.yudao.framework.mybatis.core.dataobject.BaseDO;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;

import java.time.LocalDateTime;

@TableName("system_research_event_meeting")
@Data
@ToString(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ResearchEventMeetingDO extends BaseDO {
    /**
     * 会议id
     */
    @TableId
    private Long id;
    /**
     * 关联活动id
     */
    private Integer activityId;
    /**
     * 会议名称
     */
    private String meetingName;
    /**
     * 调研公司
     */
    private String researchCompany;
    /**
     * 会议时间
     */
    private String meetingTime;
    /**
     * 会议地址
     */
    private String meetingAddress;
    /**
     * 研究员
     */
    private String researcher;
    /**
     * 调研对象
     */
    private String researchTarget;


}
