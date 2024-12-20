package cn.iocoder.yudao.module.system.controller.admin.flowtemplates;

import org.springframework.web.bind.annotation.*;
import org.springframework.validation.annotation.Validated;
import org.springframework.security.access.prepost.PreAuthorize;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.Operation;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.pojo.CommonResult;
import cn.iocoder.yudao.framework.common.util.object.BeanUtils;
import static cn.iocoder.yudao.framework.common.pojo.CommonResult.success;
import cn.iocoder.yudao.module.system.controller.admin.flowtemplates.vo.*;
import cn.iocoder.yudao.module.system.dal.dataobject.flowtemplates.FlowTemplatesDO;
import cn.iocoder.yudao.module.system.service.flowtemplates.FlowTemplatesService;
import javax.annotation.Resource;
import javax.validation.Valid;

@Tag(name = "管理后台 - 流程模板")
@RestController
@RequestMapping("/system/flow-templates")
@Validated
public class FlowTemplatesController {

    @Resource
    private FlowTemplatesService flowTemplatesService;


    @PostMapping("/approval")
    @Operation(summary = "审批流程模板")
    @PreAuthorize("@ss.hasPermission('system:flow-templates:update')")
    public CommonResult<Boolean> approvalFlowTemplates(@Valid @RequestBody FlowTemplatesPageReqVO approvalReqVO) {
        flowTemplatesService.approvalFlowTemplates(approvalReqVO);
        return success(true);
    }

    @PostMapping("/page")
    @Operation(summary = "获得流程模板分页")
    @PreAuthorize("@ss.hasPermission('system:flow-templates:query')")
    public CommonResult<PageResult<FlowTemplatesRespVO>> getFlowTemplatesPage(@Valid @RequestBody FlowTemplatesPageReqVO pageReqVO) {
        PageResult<FlowTemplatesDO> pageResult = flowTemplatesService.getFlowTemplatesPage(pageReqVO);
        return success(BeanUtils.toBean(pageResult, FlowTemplatesRespVO.class));
    }
    @PostMapping("/repeal")
    @Operation(summary = "撤回审批")
    @PreAuthorize("@ss.hasPermission('system:flow-templates:update')")
    public CommonResult<Boolean> repealFlowTemplates(@Valid @RequestBody FlowTemplatesPageReqVO repealReqVO) {
        flowTemplatesService.repealFlowTemplates(repealReqVO);
        return success(true);
    }


}