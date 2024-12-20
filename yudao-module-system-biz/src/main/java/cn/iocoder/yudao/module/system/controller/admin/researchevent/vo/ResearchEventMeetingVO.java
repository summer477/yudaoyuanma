package cn.iocoder.yudao.module.system.controller.admin.researchevent.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(description = "投研活动会议VO")
public class ResearchEventMeetingVO {
    @Schema(description = "会议id")
    private Long id;

    @Schema(description = "关联活动id")
    private Integer activityId;

    @Schema(description = "会议名称", example = "赵六")
    private String meetingName;

    @Schema(description = "调研公司")
    private String researchCompany;

    @Schema(description = "会议时间")
    private String meetingTime;

    @Schema(description = "会议地址")
    private String meetingAddress;

    @Schema(description = "研究员")
    private String researcher;

    @Schema(description = "调研对象")
    private String researchTarget;


}
