package cn.iocoder.yudao.module.system.controller.admin.flowtemplates.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.*;


@Schema(description = "审批请求 VO")
@Data
public class FlowTemplatesSaveReqVO {
    @Schema(description = "ID")
    private Integer id;

    @Schema(description = "审批状态", example = "已通过/已驳回")
    private String status;

    @Schema(description = "审批描述")
    private String description;


}


