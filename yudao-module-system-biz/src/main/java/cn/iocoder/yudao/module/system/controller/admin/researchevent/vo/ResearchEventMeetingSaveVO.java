package cn.iocoder.yudao.module.system.controller.admin.researchevent.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
@Schema(description = "投研活动会议新增VO")
public class ResearchEventMeetingSaveVO {
    @Schema(description = "会议id")
    private Long id;

    @Schema(description = "关联活动id")
    private Integer activityId;

    @NotEmpty(message ="会议名称不能为空")
    @Schema(description = "会议名称", example = "赵六")
    private String meetingName;

    @NotEmpty(message = "调研公司不能为空")
    @Schema(description = "调研公司")
    private String researchCompany;

    @NotEmpty(message = "会议时间不能为空")
    @Schema(description = "会议时间")
    private String meetingTime;

    @NotEmpty(message = "会议地址不能为空")
    @Schema(description = "会议地址")
    private String meetingAddress;

    @NotEmpty(message = "研究员不能为空")
    @Schema(description = "研究员")
    private String researcher;

    @NotEmpty(message = "研究对象不能为空")
    @Schema(description = "调研对象")
    private String researchTarget;

}
