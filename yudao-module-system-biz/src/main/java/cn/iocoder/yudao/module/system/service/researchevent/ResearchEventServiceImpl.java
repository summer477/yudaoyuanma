package cn.iocoder.yudao.module.system.service.researchevent;

import cn.iocoder.yudao.module.system.dal.dataobject.group.GroupDO;
import cn.iocoder.yudao.module.system.dal.dataobject.researchevent.ResearchEventMeetingDO;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import cn.iocoder.yudao.module.system.controller.admin.researchevent.vo.*;
import cn.iocoder.yudao.module.system.dal.dataobject.researchevent.ResearchEventDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.util.object.BeanUtils;

import cn.iocoder.yudao.module.system.dal.mysql.researchevent.ResearchEventMapper;

import javax.annotation.Resource;

import java.time.format.DateTimeFormatter;

import static cn.iocoder.yudao.framework.common.exception.util.ServiceExceptionUtil.exception;
import static cn.iocoder.yudao.module.system.enums.ErrorCodeConstants.*;

/**
 * 投研活动与会议 Service 实现类
 *
 * @author 芋道源码
 */
@Service
@Validated
public class ResearchEventServiceImpl implements ResearchEventService {

    @Resource
    private ResearchEventMapper researchEventMapper;

    @Override
    public Long createResearchEvent(ResearchEventSaveReqVO createReqVO) {
        //校验名称是否重复
        validEventNameDuplicate(createReqVO.getActivityName(), null);
        // 插入
        ResearchEventDO researchEvent = BeanUtils.toBean(createReqVO, ResearchEventDO.class);
        researchEventMapper.insert(researchEvent);
        // 返回
        return researchEvent.getId();
    }

    @Override
    public void updateResearchEvent(ResearchEventSaveReqVO updateReqVO) {
        // 校验存在
        validateResearchEventExists(updateReqVO.getId());
        // 更新
        ResearchEventDO updateObj = BeanUtils.toBean(updateReqVO, ResearchEventDO.class);
        researchEventMapper.updateById(updateObj);
    }

    @Override
    public void deleteResearchEvent(ResearchEventRespVO respVO) {
        // 删除
        researchEventMapper.deleteById(respVO.getId());
    }

    private void validateResearchEventExists(Long id) {
        if (researchEventMapper.selectById(id) == null) {
            throw exception(RESEARCH_EVENT_NOT_EXISTS);
        }
    }

    @Override
    public PageResult<ResearchEventDO> getResearchEventPage(ResearchEventPageReqVO pageReqVO) {
        // 获取分页查询的结果
        PageResult<ResearchEventDO> pageResult = researchEventMapper.selectPage(pageReqVO);

        // 定义日期格式化模板
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy.MM.dd");

        // 对查询结果进行后处理，计算并设置 activity_time
        for (ResearchEventDO activity : pageResult.getList()) {
            if (activity.getCreateTime() != null && activity.getEndTime() != null) {
                String startDate = activity.getStartTime().format(String.valueOf(formatter));
                String endDate = activity.getEndTime().format(String.valueOf(formatter));

                // 拼接成 "yyyy.MM.dd-yyyy.MM.dd" 格式
                String activityTime = startDate + "-" + endDate;
                activity.setActivityTime(activityTime); // 设置计算出的 activity_time
            }
        }

        // 返回分页结果
        return pageResult;
    }
    private void validEventNameDuplicate(String activityName, Long id) {
        ResearchEventDO researchEventDO=researchEventMapper.selectByName(activityName);
        if (researchEventDO==null){
            return;
        }
        if (id == null){
            throw exception(Event_NAME_DUPLICATE,activityName);
        }
        if (!researchEventDO.getId().equals(id)){
            throw exception(Event_NAME_DUPLICATE,activityName);
        }
    }
}