package cn.iocoder.yudao.module.system.dal.mysql.researchevent;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.mybatis.core.query.LambdaQueryWrapperX;
import cn.iocoder.yudao.framework.mybatis.core.mapper.BaseMapperX;
import cn.iocoder.yudao.module.system.dal.dataobject.group.GroupDO;
import cn.iocoder.yudao.module.system.dal.dataobject.researchevent.ResearchEventMeetingDO;
import cn.iocoder.yudao.module.system.dal.dataobject.researchevent.ResearchEventDO;
import org.apache.ibatis.annotations.Mapper;
import cn.iocoder.yudao.module.system.controller.admin.researchevent.vo.*;
import org.apache.ibatis.annotations.Update;

/**
 * 投研活动与会议 Mapper
 *
 * @author 芋道源码
 */
@Mapper
public interface ResearchEventMapper extends BaseMapperX<ResearchEventDO> {

    default PageResult<ResearchEventDO> selectPage(ResearchEventPageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<ResearchEventDO>()
                .likeIfPresent(ResearchEventDO::getOrganizer, reqVO.getOrganizer())
                .likeIfPresent(ResearchEventDO::getActivityName, reqVO.getActivityName())
                .eqIfPresent(ResearchEventDO::getIndustry, reqVO.getIndustry())
                .eqIfPresent(ResearchEventDO::getActivityTime, reqVO.getActivityTime())
                .eqIfPresent(ResearchEventDO::getDeleted,0)
                .orderByDesc(ResearchEventDO::getStartTime));
    }



    default ResearchEventDO selectByName(String name){
        return selectOne(ResearchEventDO::getActivityName,name);
    }
}