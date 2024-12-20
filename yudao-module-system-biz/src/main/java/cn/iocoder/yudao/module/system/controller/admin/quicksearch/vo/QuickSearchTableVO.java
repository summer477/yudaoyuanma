package cn.iocoder.yudao.module.system.controller.admin.quicksearch.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import java.time.LocalDateTime;
import com.alibaba.excel.annotation.*;

@Schema(description = "管理后台 - 快搜热词 Response VO")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ExcelIgnoreUnannotated
@ToString(callSuper = true)
public class QuickSearchTableVO {

    @Schema(description = "序号", requiredMode = Schema.RequiredMode.REQUIRED, example = "690")
    @ExcelProperty("序号")
    private Long id;

    @Schema(description = "快搜热词", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("快搜热词")
    private String keyword;

    @Schema(description = "点击量", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("点击量")
    private Integer clicks;

    @Schema(description = "创建人")
    @ExcelProperty("创建人")
    private String creator;

    @Schema(description = "创建时间", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("创建时间")
    private String createTime;

    @Schema(description = "是否置顶",requiredMode = Schema.RequiredMode.REQUIRED)
    private Integer isTop;
}