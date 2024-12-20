package cn.iocoder.yudao.module.system.controller.admin.researchevent;

import cn.iocoder.yudao.module.system.dal.dataobject.researchevent.ResearchEventMeetingDO;
import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import org.springframework.validation.annotation.Validated;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.Operation;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.pojo.CommonResult;
import cn.iocoder.yudao.framework.common.util.object.BeanUtils;
import static cn.iocoder.yudao.framework.common.pojo.CommonResult.success;
import cn.iocoder.yudao.module.system.controller.admin.researchevent.vo.*;
import cn.iocoder.yudao.module.system.dal.dataobject.researchevent.ResearchEventDO;
import cn.iocoder.yudao.module.system.service.researchevent.ResearchEventService;
import javax.annotation.Resource;
import javax.validation.Valid;

@Tag(name = "管理后台 - 投研活动与会议")
@RestController
@RequestMapping("/system/research-event")
@Validated
@Slf4j
public class ResearchEventController {

    @Resource
    private ResearchEventService researchEventService;

    @PostMapping("/create")
    @Operation(summary = "创建投研活动")
    public CommonResult<Long> createResearchEvent(@RequestBody @Valid ResearchEventSaveReqVO createReqVO) {
        log.info("create 請求參數: {}", JSON.toJSONString(createReqVO));
        return success(researchEventService.createResearchEvent(createReqVO));
    }


    @PostMapping("/update")
    @Operation(summary = "更新投研活动与会议")
    public CommonResult<Boolean> updateResearchEvent(@RequestBody @Valid ResearchEventSaveReqVO updateReqVO) {
        log.info("update 請求參數: {}", JSON.toJSONString(updateReqVO));
        researchEventService.updateResearchEvent(updateReqVO);
        return success(true);
    }

    @PostMapping("/delete")
    @Operation(summary = "删除投研活动与会议")
    public CommonResult<Boolean> deleteResearchEvent(@RequestBody @Valid ResearchEventRespVO deletedReqVO) {
        log.info("delete 請求參數: {}", JSON.toJSONString(deletedReqVO));
        researchEventService.deleteResearchEvent(deletedReqVO);
        return success(true);
    }


    @PostMapping("/page")
    @Operation(summary = "获得投研活动与会议分页")
    public CommonResult<PageResult<ResearchEventRespVO>> getResearchEventPage(@RequestBody @Valid ResearchEventPageReqVO pageReqVO) {
        log.info("page 請求參數: {}", JSON.toJSONString(pageReqVO));
        PageResult<ResearchEventDO> pageResult = researchEventService.getResearchEventPage(pageReqVO);
        return success(BeanUtils.toBean(pageResult, ResearchEventRespVO.class));
    }



}