package cn.iocoder.yudao.module.system.controller.admin.researchevent.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Schema(description = "管理后台 - 投研活动与会议新增/修改 Request VO")
@Data
public class ResearchEventSaveReqVO {

    @Schema(description = "id", requiredMode = Schema.RequiredMode.REQUIRED, example = "9939")
    private Long id;

    @NotEmpty(message = "机构不能为空")
    @Schema(description = "发起投研活动的组织机构", requiredMode = Schema.RequiredMode.REQUIRED)
    private String organizer;

    @NotEmpty(message = "活动名称不能为空")
    @Schema(description = "投研活动名称", requiredMode = Schema.RequiredMode.REQUIRED, example = "芋艿")
    private String activityName;

    @NotEmpty(message = "调研行业不能为空")
    @Schema(description = "调研行业", requiredMode = Schema.RequiredMode.REQUIRED)
    private String industry;

    @NotEmpty(message = "活动开始时间不能为空")
    @Schema(description = "投研活动开始时间", requiredMode = Schema.RequiredMode.REQUIRED)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private String startTime;

    @NotEmpty(message = "活动结束时间不能为空")
    @Schema(description = "投研活动结束时间", requiredMode = Schema.RequiredMode.REQUIRED)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private String endTime;

}