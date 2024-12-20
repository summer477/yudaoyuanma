package cn.iocoder.yudao.module.system.service.researchevent;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.module.system.controller.admin.researchevent.vo.ResearchEventMeetingPageVO;
import cn.iocoder.yudao.module.system.controller.admin.researchevent.vo.ResearchEventMeetingSaveVO;
import cn.iocoder.yudao.module.system.controller.admin.researchevent.vo.ResearchEventMeetingVO;
import cn.iocoder.yudao.module.system.dal.dataobject.researchevent.ResearchEventMeetingDO;

public interface ResearchEventMeetingService {
    Long createResearchEvent(ResearchEventMeetingSaveVO createReqVO);

    void updateResearchEvent(ResearchEventMeetingSaveVO updateReqVO);

    void deleteResearchEvent(ResearchEventMeetingVO deletedReqVO);

    PageResult<ResearchEventMeetingDO> getResearchEventPage(ResearchEventMeetingPageVO pageReqVO);
}
