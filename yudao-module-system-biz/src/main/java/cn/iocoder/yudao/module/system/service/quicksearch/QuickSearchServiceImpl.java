package cn.iocoder.yudao.module.system.service.quicksearch;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.mybatis.core.query.LambdaQueryWrapperX;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import java.util.*;
import java.util.stream.Collectors;
import cn.iocoder.yudao.module.system.controller.admin.quicksearch.vo.*;
import cn.iocoder.yudao.module.system.dal.dataobject.quicksearch.QuickSearchDO;
import cn.iocoder.yudao.framework.common.util.object.BeanUtils;
import cn.iocoder.yudao.module.system.dal.mysql.quicksearch.QuickSearchMapper;
import javax.annotation.Resource;


/**
 * 快搜热词 Service 实现类
 *
 * @author 芋道源码
 */
@Service
@Validated
public class QuickSearchServiceImpl implements QuickSearchService {

    @Resource
    private QuickSearchMapper quickSearchMapper;

    @Override
    public PageResult<QuickSearchDO> getQuickSearchPage(QuickSearchPageReqVO pageReqVO) {
        // 确定时间范围
        Date endTime = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(endTime);
        calendar.add(Calendar.DAY_OF_YEAR, -pageReqVO.getStatisticPeriod());
        Date startTime = calendar.getTime();

        // 设置时间范围到查询请求对象
        pageReqVO.setStartTime(startTime);
        pageReqVO.setEndTime(endTime);

        // 调用 Mapper 分页查询
        PageResult<QuickSearchDO> pageResult = quickSearchMapper.selectPage(pageReqVO);

        // 如果需要返回 DO 列表，不需要做 VO 转换
        return pageResult;
    }

    @Override
    public void deleteQuickSearchById(QuickSearchPageReqVO quickSearchTableVO) {
        quickSearchMapper.deleteQuickSearchById(quickSearchTableVO);
    }


    @Override
    public void updateQuickSearchWord(QuickSearchConfigVO quickSearchConfigVO) {
        QuickSearchDO configDO = new QuickSearchDO();
        BeanUtils.copyProperties(quickSearchConfigVO, configDO);
        quickSearchMapper.updateQuickSearchWord(configDO);
    }


    @Override
    public void setTopStatus(QuickSearchTopVO quickSearchTopVO) {
        quickSearchMapper.updateTopStatus(quickSearchTopVO);
    }

}