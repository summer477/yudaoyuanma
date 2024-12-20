package cn.iocoder.yudao.module.system.dal.mysql.researchevent;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.mybatis.core.mapper.BaseMapperX;
import cn.iocoder.yudao.framework.mybatis.core.query.LambdaQueryWrapperX;
import cn.iocoder.yudao.module.system.controller.admin.researchevent.vo.ResearchEventMeetingPageVO;
import cn.iocoder.yudao.module.system.controller.admin.researchevent.vo.ResearchEventMeetingVO;
import cn.iocoder.yudao.module.system.dal.dataobject.researchevent.ResearchEventMeetingDO;
import cn.iocoder.yudao.module.system.dal.dataobject.researchevent.ResearchEventDO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

/**
 * 投研活动会议mapper
 */
@Mapper
public interface ResearchEventMeetingMapper extends BaseMapperX<ResearchEventMeetingDO> {

    default PageResult<ResearchEventMeetingDO> selectPage(ResearchEventMeetingPageVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<ResearchEventMeetingDO>()
                .eq(ResearchEventMeetingDO::getActivityId,reqVO.getActivityId())
                .likeIfPresent(ResearchEventMeetingDO::getMeetingName,reqVO.getMeetingName())
                .eqIfPresent(ResearchEventMeetingDO::getMeetingAddress,reqVO.getMeetingAddress())
                .eqIfPresent(ResearchEventMeetingDO::getMeetingTime,reqVO.getMeetingTime())
                .eqIfPresent(ResearchEventMeetingDO::getDeleted,0)
                .orderByDesc(ResearchEventMeetingDO::getId));
    }

    default ResearchEventMeetingDO selectByName(String name){
        return selectOne(ResearchEventMeetingDO::getMeetingName,name);
    }




}
