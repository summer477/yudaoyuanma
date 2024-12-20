package cn.iocoder.yudao.module.system.controller.admin.researchevent.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import com.alibaba.excel.annotation.*;
import org.springframework.format.annotation.DateTimeFormat;

@Schema(description = "管理后台 - 投研活动与会议 Response VO")
@Data
@ExcelIgnoreUnannotated
public class ResearchEventRespVO {

    @Schema(description = "id", requiredMode = Schema.RequiredMode.REQUIRED, example = "9939")
    private Long id;

    @Schema(description = "发起投研活动的组织机构", requiredMode = Schema.RequiredMode.REQUIRED)
    private String organizer;

    @Schema(description = "投研活动名称", requiredMode = Schema.RequiredMode.REQUIRED, example = "芋艿")
    private String activityName;

    @Schema(description = "调研行业", requiredMode = Schema.RequiredMode.REQUIRED)
    private String industry;

    @Schema(description = "投研活动时间", requiredMode = Schema.RequiredMode.REQUIRED)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private String activityTime;
}