package cn.iocoder.yudao.module.system.controller.admin.quicksearch;

import cn.iocoder.yudao.framework.common.pojo.CommonResult;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.util.object.BeanUtils;
import cn.iocoder.yudao.module.system.controller.admin.quicksearch.vo.*;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import cn.iocoder.yudao.module.system.dal.dataobject.quicksearch.QuickSearchDO;
import cn.iocoder.yudao.module.system.service.quicksearch.QuickSearchService;

import javax.annotation.Resource;
import javax.validation.Valid;

import static cn.iocoder.yudao.framework.common.pojo.CommonResult.success;

@RestController
@RequestMapping("/system/quick-search")
public class QuickSearchController {

    @Resource
    private QuickSearchService quickSearchService;


    @PostMapping("/page")
    @Operation(summary = "获取热搜快词分页")
    public CommonResult<PageResult<QuickSearchTableVO>> getQuickSearchPage(@Valid @RequestBody QuickSearchPageReqVO pageReqVO) {
        PageResult<QuickSearchDO> pageResult = quickSearchService.getQuickSearchPage(pageReqVO);
        return success(BeanUtils.toBean(pageResult,QuickSearchTableVO.class));
    }

    /**
     * 更新快搜热词
     *
     * @param quickSearchConfigVO 热词信息
     */
    @Operation(summary = "更新快搜热词配置")
    @PostMapping("/update")
    public ResponseEntity<Void> updateQuickSearchWord(@RequestBody QuickSearchConfigVO quickSearchConfigVO) {
        quickSearchService.updateQuickSearchWord(quickSearchConfigVO);
        return ResponseEntity.ok().build();
    }


    /**
     * 逻辑删除快搜热词
     *
     * @param  quickSearchTableVO ID
     */
    @PostMapping("/delete")
    @Operation(summary = "删除热搜快词")
    public CommonResult<Boolean> deleteQuickSearch(@RequestBody QuickSearchPageReqVO quickSearchTableVO) {
        quickSearchService.deleteQuickSearchById(quickSearchTableVO);
        return success(true);
    }

    /**
     * 是否置顶
     * @param quickSearchTopVO
     * @return
     */
    @PostMapping("/top")
    public ResponseEntity<Void> setTopStatus(@Valid @RequestBody QuickSearchTopVO quickSearchTopVO) {
        quickSearchService.setTopStatus(quickSearchTopVO);
        return ResponseEntity.ok().build();
    }


}






















