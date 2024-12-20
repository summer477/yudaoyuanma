package cn.iocoder.yudao.module.system.service.researchevent;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.util.object.BeanUtils;
import cn.iocoder.yudao.module.system.controller.admin.researchevent.vo.ResearchEventMeetingPageVO;
import cn.iocoder.yudao.module.system.controller.admin.researchevent.vo.ResearchEventMeetingSaveVO;
import cn.iocoder.yudao.module.system.controller.admin.researchevent.vo.ResearchEventMeetingVO;
import cn.iocoder.yudao.module.system.dal.dataobject.researchevent.ResearchEventMeetingDO;
import cn.iocoder.yudao.module.system.dal.mysql.researchevent.ResearchEventMeetingMapper;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import javax.annotation.Resource;
import static cn.iocoder.yudao.framework.common.exception.util.ServiceExceptionUtil.exception;
import static cn.iocoder.yudao.module.system.enums.ErrorCodeConstants.*;


@Service
@Validated
public class ResearchEventMeetingServiceImpl implements ResearchEventMeetingService{

    @Resource
    private ResearchEventMeetingMapper researchEventMeetingMapper;

    @Override
    public Long createResearchEvent(ResearchEventMeetingSaveVO createReqVO) {
        //校验是否重复
        validMeetingNameDuplicate(createReqVO.getMeetingName(), null);
        //新增
        ResearchEventMeetingDO researchEvent = BeanUtils.toBean(createReqVO, ResearchEventMeetingDO.class);
        researchEventMeetingMapper.insert(researchEvent);
        // 返回
        return researchEvent.getId();
    }

    @Override
    public void updateResearchEvent(ResearchEventMeetingSaveVO updateReqVO) {
        // 校验存在
        validateResearchEventExists(updateReqVO.getId());
        // 更新
        ResearchEventMeetingDO updateObj = BeanUtils.toBean(updateReqVO, ResearchEventMeetingDO.class);
        researchEventMeetingMapper.updateById(updateObj);
    }

    @Override
    public void deleteResearchEvent(ResearchEventMeetingVO deletedReqVO) {
        // 删除
        researchEventMeetingMapper.deleteById(deletedReqVO.getId());
    }

    @Override
    public PageResult<ResearchEventMeetingDO> getResearchEventPage(ResearchEventMeetingPageVO pageReqVO) {
        return researchEventMeetingMapper.selectPage(pageReqVO);
    }

    private void validateResearchEventExists(Long id) {
        if (researchEventMeetingMapper.selectById(id) == null) {
            throw exception(RESEARCH_EVENT_NOT_EXISTS);
        }
    }

    private void validMeetingNameDuplicate(String meetingName, Long id) {
        ResearchEventMeetingDO researchEventMeetingDO=researchEventMeetingMapper.selectByName(meetingName);
        if (researchEventMeetingDO==null){
            return;
        }
        if (id == null){
            throw exception(Meeting_NAME_DUPLICATE,meetingName);
        }
        if (!researchEventMeetingDO.getId().equals(id)){
            throw exception(Meeting_NAME_DUPLICATE,meetingName);
        }
    }
}
