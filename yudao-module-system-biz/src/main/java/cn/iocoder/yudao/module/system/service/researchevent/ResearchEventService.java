package cn.iocoder.yudao.module.system.service.researchevent;


import cn.iocoder.yudao.module.system.controller.admin.researchevent.vo.*;
import cn.iocoder.yudao.module.system.dal.dataobject.researchevent.ResearchEventMeetingDO;
import cn.iocoder.yudao.module.system.dal.dataobject.researchevent.ResearchEventDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;

import javax.validation.Valid;


/**
 * 投研活动与会议 Service 接口
 *
 * @author 芋道源码
 */
public interface ResearchEventService {

    /**
     * 创建投研活动与会议
     *
     * @param createReqVO 创建信息
     * @return 编号
     */
    Long createResearchEvent(@Valid ResearchEventSaveReqVO createReqVO);

    /**
     * 更新投研活动与会议
     *
     * @param updateReqVO 更新信息
     */
    void updateResearchEvent(@Valid ResearchEventSaveReqVO updateReqVO);

    /**
     * 删除投研活动与会议
     *
     * @param  respVO
     */
    void deleteResearchEvent(ResearchEventRespVO respVO);


    /**
     * 获得投研活动与会议分页
     *
     * @param pageReqVO 分页查询
     * @return 投研活动与会议分页
     */
    PageResult<ResearchEventDO> getResearchEventPage(ResearchEventPageReqVO pageReqVO);

}