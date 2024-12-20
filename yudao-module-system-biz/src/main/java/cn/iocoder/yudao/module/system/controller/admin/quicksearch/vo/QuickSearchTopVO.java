package cn.iocoder.yudao.module.system.controller.admin.quicksearch.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class QuickSearchTopVO {
    @NotNull(message = "id不能为空")
    @Schema(description = "主键id")
    private Long id;

    @NotNull(message = "置顶id不能为空")
    @Schema(description = "是否置顶")
    private Integer isTop;

}
