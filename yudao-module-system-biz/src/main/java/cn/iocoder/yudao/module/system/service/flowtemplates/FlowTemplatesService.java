package cn.iocoder.yudao.module.system.service.flowtemplates;

import java.util.*;

import cn.iocoder.yudao.module.system.controller.admin.flowtemplates.vo.*;
import cn.iocoder.yudao.module.system.dal.dataobject.flowtemplates.FlowTemplatesDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.pojo.PageParam;

import javax.validation.Valid;

/**
 * 流程模板 Service 接口
 *
 * @author 芋道源码
 */
public interface FlowTemplatesService {



    /**
     * 获得流程模板分页
     *
     * @param pageReqVO 分页查询
     * @return 流程模板分页
     */
    PageResult<FlowTemplatesDO> getFlowTemplatesPage(FlowTemplatesPageReqVO pageReqVO);

    /**
     * 审批业务流程模板
     * @param approvalReqVO
     */
    void approvalFlowTemplates(FlowTemplatesPageReqVO approvalReqVO);

    void repealFlowTemplates(FlowTemplatesPageReqVO repealReqVO);
}