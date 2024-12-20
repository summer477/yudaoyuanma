package cn.iocoder.yudao.module.system.controller.admin.quicksearch.vo;

import cn.iocoder.yudao.framework.common.pojo.PageParam;
import com.alibaba.excel.annotation.ExcelIgnoreUnannotated;
import com.alibaba.excel.annotation.ExcelProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ExcelIgnoreUnannotated
@ToString(callSuper = true)
public class QuickSearchPageReqVO extends PageParam {

    @Schema(description = "序号", requiredMode = Schema.RequiredMode.REQUIRED, example = "690")
    @ExcelProperty("序号")
    private Long id;

    @Schema(description = "快搜热词", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("快搜热词")
    private String keyword;

    @Schema(description = "词ID", requiredMode = Schema.RequiredMode.REQUIRED, example = "25157")
    @ExcelProperty("词ID")
    private Integer wordId;

    @Schema(description = "排序ID", requiredMode = Schema.RequiredMode.REQUIRED, example = "19213")
    @ExcelProperty("排序ID")
    private Integer rankId;

    @Schema(description = "点击量", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("点击量")
    private Integer clicks;

    @Schema(description = "创建人")
    @ExcelProperty("创建人")
    private String creator;

    @Schema(description = "创建时间", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("创建时间")
    private String createTime;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date startTime; // 开始时间

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date endTime; // 结束时间

    @Schema(description = "是否置顶")
    private int isTop;


    @Schema(description = "排序顺序：asc/desc")
    private String sortOrder;  // 排序顺序字段

    @Schema(description = "更新频率")
    private Integer updateFrequency;

    @Schema(description = "统计范围")
    private Integer statisticPeriod;

    @Schema(description = "是否删除")
    private Integer deleted;
}
