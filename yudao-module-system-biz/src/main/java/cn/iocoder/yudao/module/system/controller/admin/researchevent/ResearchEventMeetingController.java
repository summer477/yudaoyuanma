package cn.iocoder.yudao.module.system.controller.admin.researchevent;

import cn.iocoder.yudao.framework.common.pojo.CommonResult;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.util.object.BeanUtils;
import cn.iocoder.yudao.module.system.controller.admin.researchevent.vo.ResearchEventMeetingPageVO;
import cn.iocoder.yudao.module.system.controller.admin.researchevent.vo.ResearchEventMeetingSaveVO;
import cn.iocoder.yudao.module.system.controller.admin.researchevent.vo.ResearchEventMeetingVO;
import cn.iocoder.yudao.module.system.dal.dataobject.researchevent.ResearchEventMeetingDO;
import cn.iocoder.yudao.module.system.service.researchevent.ResearchEventMeetingService;
import com.alibaba.fastjson.JSON;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.validation.Valid;

import static cn.iocoder.yudao.framework.common.pojo.CommonResult.success;

@Tag(name = "管理后台 - 投研活动与会议")
@RestController
@RequestMapping("/system/research-event-meeting")
@Validated
@Slf4j
public class ResearchEventMeetingController {

    @Resource
    private ResearchEventMeetingService researchEventMeetingService;

    @PostMapping("/create")
    @Operation(summary = "创建会议")
    public CommonResult<Long> createResearchEventMeeting(@RequestBody @Valid ResearchEventMeetingSaveVO createReqVO) {
        log.info("create 請求參數: {}", JSON.toJSONString(createReqVO));
        return success(researchEventMeetingService.createResearchEvent(createReqVO));
    }


    @PostMapping("/update")
    @Operation(summary = "更新会议")
    public CommonResult<Boolean> updateResearchEventMeeting(@RequestBody @Valid ResearchEventMeetingSaveVO updateReqVO) {
        log.info("update 請求參數: {}", JSON.toJSONString(updateReqVO));
        researchEventMeetingService.updateResearchEvent(updateReqVO);
        return success(true);
    }

    @PostMapping("/delete")
    @Operation(summary = "删除会议")
    public CommonResult<Boolean> deleteResearchEventMeeting(@RequestBody @Valid ResearchEventMeetingVO deletedReqVO) {
        log.info("delete 請求參數: {}", JSON.toJSONString(deletedReqVO));
        researchEventMeetingService.deleteResearchEvent(deletedReqVO);
        return success(true);
    }


    @PostMapping("/list")
    @Operation(summary = "获得会议分页")
    public CommonResult<PageResult<ResearchEventMeetingVO>> getResearchEventMeetingPage(@RequestBody @Valid ResearchEventMeetingPageVO pageReqVO) {
        log.info("list 請求參數: {}", JSON.toJSONString(pageReqVO));
        PageResult<ResearchEventMeetingDO> pageResult = researchEventMeetingService.getResearchEventPage(pageReqVO);
        return success(BeanUtils.toBean(pageResult, ResearchEventMeetingVO.class));
    }
}
