package cn.iocoder.yudao.module.system.dal.dataobject.flowtemplates;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import java.util.*;
import java.time.LocalDateTime;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.*;
import cn.iocoder.yudao.framework.mybatis.core.dataobject.BaseDO;

/**
 * 流程模板 DO
 *
 * @author 芋道源码
 */
@TableName("system_flow_templates")
@Data
@ToString(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FlowTemplatesDO  {

    /**
     * ID
     */
    @TableId
    private Integer id;
    /**
     * 标题
     */
    private String title;
    /**
     * 业务分类
     */
    private String businessCategory;
    /**
     * 节点个数
     */
    private Integer count;
    /**
     * 适用板块
     */
    private String applicableSection;
    /**
     * 审核状态
     */
    private String status;
    /**
     * 发起时间
     */
    private String startTime;
    /**
     * 结束时间
     */
    private String endTime;
    /**
     * 创建人
     */
    private String creator;
    /**
     * 审批描述
     */
    private String description;
    /**
     * 是否删除
     */
    private Integer deleted;

}