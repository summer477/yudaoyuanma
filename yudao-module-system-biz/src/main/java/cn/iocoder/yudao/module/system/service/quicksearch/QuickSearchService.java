package cn.iocoder.yudao.module.system.service.quicksearch;

import java.util.*;

import cn.iocoder.yudao.module.system.controller.admin.quicksearch.vo.*;
import cn.iocoder.yudao.module.system.dal.dataobject.quicksearch.QuickSearchDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.pojo.PageParam;

import javax.validation.Valid;

/**
 * 快搜热词 Service 接口
 *
 * @author 芋道源码
 */
public interface QuickSearchService {
    void updateQuickSearchWord(QuickSearchConfigVO quickSearchConfigVO);

    void setTopStatus(QuickSearchTopVO quickSearchTopVO);


    PageResult<QuickSearchDO> getQuickSearchPage(QuickSearchPageReqVO pageReqVO);


    void deleteQuickSearchById(QuickSearchPageReqVO quickSearchPageReqVO);
}