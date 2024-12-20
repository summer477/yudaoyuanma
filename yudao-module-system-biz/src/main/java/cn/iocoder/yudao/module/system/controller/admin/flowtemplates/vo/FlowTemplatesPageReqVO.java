package cn.iocoder.yudao.module.system.controller.admin.flowtemplates.vo;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.*;
import java.util.*;
import io.swagger.v3.oas.annotations.media.Schema;
import cn.iocoder.yudao.framework.common.pojo.PageParam;
import org.springframework.format.annotation.DateTimeFormat;
import java.time.LocalDateTime;

import static cn.iocoder.yudao.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;

@Schema(description = "管理后台 - 流程模板分页 Request VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class FlowTemplatesPageReqVO extends PageParam {

    @Schema(description = "ID")
    private Integer id;

    @Schema(description = "标题")
    private String title;

    @Schema(description = "业务分类")
    private String businessCategory;

    @Schema(description = "节点个数", example = "15879")
    private Integer count;

    @Schema(description = "适用板块")
    private String applicableSection;

    @Schema(description = "审核状态", example = "2")
    private String status;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private String startTime; // 开始时间

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private String endTime; // 结束时间

    @Schema(description = "创建人")
    private String creator;

    @Schema(description = "审批描述")
    private String description;


}