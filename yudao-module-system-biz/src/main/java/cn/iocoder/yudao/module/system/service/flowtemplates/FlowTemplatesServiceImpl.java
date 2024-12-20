package cn.iocoder.yudao.module.system.service.flowtemplates;

import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import cn.iocoder.yudao.module.system.controller.admin.flowtemplates.vo.*;
import cn.iocoder.yudao.module.system.dal.dataobject.flowtemplates.FlowTemplatesDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.pojo.PageParam;
import cn.iocoder.yudao.framework.common.util.object.BeanUtils;

import cn.iocoder.yudao.module.system.dal.mysql.flowtemplates.FlowTemplatesMapper;

import javax.annotation.Resource;

import static cn.iocoder.yudao.framework.common.exception.util.ServiceExceptionUtil.exception;
import static cn.iocoder.yudao.module.system.enums.ErrorCodeConstants.*;

/**
 * 流程模板 Service 实现类
 *
 * @author 芋道源码
 */
@Service
@Validated
public class FlowTemplatesServiceImpl implements FlowTemplatesService {

    @Resource
    private FlowTemplatesMapper flowTemplatesMapper;




    private void validateFlowTemplatesExists(Integer id) {
        if (flowTemplatesMapper.selectById(id) == null) {
            throw exception(FLOW_TEMPLATES_NOT_EXISTS);
        }
    }


    @Override
    public PageResult<FlowTemplatesDO> getFlowTemplatesPage(FlowTemplatesPageReqVO pageReqVO) {
        return flowTemplatesMapper.selectPage(pageReqVO);
    }

    @Override
    public void approvalFlowTemplates(FlowTemplatesPageReqVO approvalReqVO) {
        // 检查请求数据是否合法
        if (approvalReqVO.getId() == null || approvalReqVO.getStatus() == null) {
            throw new IllegalArgumentException("审批ID和状态不能为空！");
        }

        // 更新数据库中的记录
        int rowsAffected = flowTemplatesMapper.approvalById(approvalReqVO);
        if (rowsAffected == 0) {
            throw new IllegalStateException("审批失败，记录可能不存在！");
        }

    }

    @Override
    public void repealFlowTemplates(FlowTemplatesPageReqVO repealReqVO) {
        int rowsAffected = flowTemplatesMapper.repealById(repealReqVO);
        if (rowsAffected == 0) {
            throw new IllegalStateException("撤回失败，记录可能不存在！");
        }
    }


}