package cn.iocoder.yudao.module.system.controller.admin.quicksearch.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import javax.validation.constraints.NotEmpty;

@Schema(description = "管理后台 - 快搜热词新增/修改 Request VO")
@Data
@ToString(callSuper = true)
public class QuickSearchSubmitConfigVO {


    @Schema(description = "排序依据", requiredMode = Schema.RequiredMode.REQUIRED, example = "点击量")
    @NotEmpty(message = "排序依据不能为空")
    private String orderBasis;

    @Schema(description = "更新频率", requiredMode = Schema.RequiredMode.REQUIRED, example = "每24小时")
    @NotEmpty(message = "更新频率不能为空")
    private int updateFrequency;

    @Schema(description = "统计范围", requiredMode = Schema.RequiredMode.REQUIRED, example = "最近7天")
    @NotEmpty(message = "统计范围不能为空")
    private int statisticRange;
    @Schema(description = "是否置顶", requiredMode = Schema.RequiredMode.REQUIRED)
    private int is_top;
}