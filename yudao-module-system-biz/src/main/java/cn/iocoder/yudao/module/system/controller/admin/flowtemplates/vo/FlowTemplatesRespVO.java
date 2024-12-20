package cn.iocoder.yudao.module.system.controller.admin.flowtemplates.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import java.util.*;
import org.springframework.format.annotation.DateTimeFormat;
import java.time.LocalDateTime;
import com.alibaba.excel.annotation.*;

@Schema(description = "管理后台 - 流程模板 Response VO")
@Data
@ExcelIgnoreUnannotated
public class FlowTemplatesRespVO {

    @Schema(description = "ID", requiredMode = Schema.RequiredMode.REQUIRED, example = "31784")
    @ExcelProperty("ID")
    private Integer id;

    @Schema(description = "标题", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("标题")
    private String title;

    @Schema(description = "业务分类", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("业务分类")
    private String businessCategory;

    @Schema(description = "节点个数", requiredMode = Schema.RequiredMode.REQUIRED, example = "15879")
    @ExcelProperty("节点个数")
    private Integer count;

    @Schema(description = "适用板块", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("适用板块")
    private String applicableSection;

    @Schema(description = "审核状态", requiredMode = Schema.RequiredMode.REQUIRED, example = "2")
    @ExcelProperty("审核状态")
    private String status;

    @Schema(description = "发起时间", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("发起时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private String startTime;

    @Schema(description = "发起时间", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("发起时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private String endTime;

    @Schema(description = "创建人",requiredMode = Schema.RequiredMode.REQUIRED)
    private String creator;

    @Schema(description = "审批描述")
    private String description;
}