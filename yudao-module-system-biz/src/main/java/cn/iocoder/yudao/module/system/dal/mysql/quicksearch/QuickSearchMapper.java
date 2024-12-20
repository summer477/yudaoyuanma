package cn.iocoder.yudao.module.system.dal.mysql.quicksearch;

import java.util.*;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.mybatis.core.query.LambdaQueryWrapperX;
import cn.iocoder.yudao.framework.mybatis.core.mapper.BaseMapperX;
import cn.iocoder.yudao.module.system.controller.admin.dept.vo.dept.DeptListReqVO;
import cn.iocoder.yudao.module.system.dal.dataobject.dept.DeptDO;
import cn.iocoder.yudao.module.system.dal.dataobject.quicksearch.QuickSearchDO;
import org.apache.ibatis.annotations.Mapper;
import cn.iocoder.yudao.module.system.controller.admin.quicksearch.vo.*;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

/**
 * 快搜热词 Mapper
 *
 * @author 芋道源码
 */
@Mapper
public interface QuickSearchMapper extends BaseMapperX<QuickSearchDO> {

        default PageResult<QuickSearchDO> selectPage(QuickSearchPageReqVO reqVO) {
            // 构建查询条件
            return selectPage(reqVO, new LambdaQueryWrapperX<QuickSearchDO>()
                    // 筛选创建时间范围
                    .betweenIfPresent(QuickSearchDO::getCreateTime, reqVO.getStartTime(), reqVO.getEndTime())
                    // 按 isTop 排序
                    .orderByAsc(QuickSearchDO::getIsTop)
                    .eq(QuickSearchDO::getDeleted,0)
                    // 动态排序：按点击量升序或降序
                    .orderByAsc("asc".equalsIgnoreCase(reqVO.getSortOrder()), QuickSearchDO::getClicks)
                    .orderByDesc("desc".equalsIgnoreCase(reqVO.getSortOrder()), QuickSearchDO::getClicks));
        }


    void updateTopStatus(QuickSearchTopVO quickSearchTopVO);

    void updateQuickSearchWord(QuickSearchDO quickSearchDO);

    @Update("UPDATE system_quick_search SET deleted = 1 WHERE id = #{id} AND deleted = 0")
    void deleteQuickSearchById(QuickSearchPageReqVO quickSearchTableVO);
}