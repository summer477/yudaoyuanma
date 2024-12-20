package cn.iocoder.yudao.module.system.controller.admin.researchevent.vo;

import lombok.*;
import io.swagger.v3.oas.annotations.media.Schema;
import cn.iocoder.yudao.framework.common.pojo.PageParam;
import org.springframework.format.annotation.DateTimeFormat;
import java.time.LocalDateTime;

import static cn.iocoder.yudao.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;

@Schema(description = "管理后台 - 投研活动与会议分页 Request VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class ResearchEventPageReqVO extends PageParam {
    @Schema(description = "投研活动id")
    private Integer id;

    @Schema(description = "发起投研活动的组织机构")
    private String organizer;

    @Schema(description = "投研活动名称", example = "芋艿")
    private String activityName;

    @Schema(description = "调研行业")
    private String industry;

    @Schema(description = "投研活动时间")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private String activityTime;
}