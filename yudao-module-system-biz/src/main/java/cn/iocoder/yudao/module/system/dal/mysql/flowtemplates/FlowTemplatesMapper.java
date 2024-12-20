package cn.iocoder.yudao.module.system.dal.mysql.flowtemplates;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.mybatis.core.query.LambdaQueryWrapperX;
import cn.iocoder.yudao.framework.mybatis.core.mapper.BaseMapperX;
import cn.iocoder.yudao.module.system.dal.dataobject.flowtemplates.FlowTemplatesDO;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import org.apache.ibatis.annotations.Mapper;
import cn.iocoder.yudao.module.system.controller.admin.flowtemplates.vo.*;
import org.apache.ibatis.annotations.Update;

import java.time.LocalDateTime;

/**
 * 流程模板 Mapper
 *
 * @author 芋道源码
 */
@Mapper
public interface FlowTemplatesMapper extends BaseMapperX<FlowTemplatesDO> {

    default PageResult<FlowTemplatesDO> selectPage(FlowTemplatesPageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<FlowTemplatesDO>()
                .likeIfPresent(FlowTemplatesDO::getTitle, reqVO.getTitle())
                .eqIfPresent(FlowTemplatesDO::getBusinessCategory, reqVO.getBusinessCategory())
                .eqIfPresent(FlowTemplatesDO::getCount, reqVO.getCount())
                .eqIfPresent(FlowTemplatesDO::getApplicableSection, reqVO.getApplicableSection())
                .betweenIfPresent(FlowTemplatesDO::getStartTime, reqVO.getStartTime(),reqVO.getEndTime())
                .eqIfPresent(FlowTemplatesDO::getCreator,reqVO.getCreator())
                .eqIfPresent(FlowTemplatesDO::getDescription,reqVO.getDescription())
                .and(wrapper -> {
                    if ("已处理".equals(reqVO.getStatus())) {
                        wrapper.in(FlowTemplatesDO::getStatus, "已通过", "已驳回");
                    } else if ("待处理".equals(reqVO.getStatus())) {
                        wrapper.eq(FlowTemplatesDO::getStatus, "待处理");
                    }
                })
                .orderByDesc(FlowTemplatesDO::getId));
    }


    default int approvalById(FlowTemplatesPageReqVO reqVO) {
        return this.update(new LambdaUpdateWrapper<FlowTemplatesDO>()
                .set(FlowTemplatesDO::getStatus, reqVO.getStatus())
                .set(FlowTemplatesDO::getDescription, reqVO.getDescription())
                .set(FlowTemplatesDO::getEndTime, LocalDateTime.now())
                .eq(FlowTemplatesDO::getId, reqVO.getId())
                .eq(FlowTemplatesDO::getDeleted, 0));
    }


//    @Update("UPDATE system_flow_templates SET status = '待处理', description = NULL WHERE status IN ('已通过', '已驳回') AND id = #{id} ")
//    int repealById(FlowTemplatesDO updateObj);

    default int repealById(FlowTemplatesPageReqVO reqVO) {
        return this.update(new LambdaUpdateWrapper<FlowTemplatesDO>()
                .set(FlowTemplatesDO::getStatus, "待处理")     // 更新 status 字段为 '待处理'
                .set(FlowTemplatesDO::getDescription, null)   // 将 description 置为 NULL
                .eq(FlowTemplatesDO::getId, reqVO.getId())    // 筛选指定的 ID
                .in(FlowTemplatesDO::getStatus, "已通过", "已驳回") // 筛选 status 为 '已通过' 或 '已驳回'
                .eq(FlowTemplatesDO::getDeleted, 0));         // 确保未被逻辑删除
    }


}