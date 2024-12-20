package cn.iocoder.yudao.module.system.controller.admin.quicksearch.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.ToString;

@Schema(description = "管理后台 - 快搜热词分页 Request VO")
@Data
@ToString(callSuper = true)
public class QuickSearchConfigVO {

    @Schema(description = "排序依据", requiredMode = Schema.RequiredMode.REQUIRED, example = "点击量")
    private String orderBy;

    @Schema(description = "更新频率", requiredMode = Schema.RequiredMode.REQUIRED, example = "每24小时")
    private String updateFrequency;

    @Schema(description = "统计范围", requiredMode = Schema.RequiredMode.REQUIRED, example = "最近7天")
    private String statisticPeriod;
    @Schema(description = "是否置顶", requiredMode = Schema.RequiredMode.REQUIRED)
    private int is_top;
}
