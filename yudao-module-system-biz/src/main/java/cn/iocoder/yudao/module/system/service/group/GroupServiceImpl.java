package cn.iocoder.yudao.module.system.service.group;

import cn.hutool.core.thread.ThreadException;
import org.springframework.stereotype.Service;

import org.springframework.validation.annotation.Validated;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import cn.iocoder.yudao.module.system.controller.admin.group.vo.*;
import cn.iocoder.yudao.module.system.dal.dataobject.group.GroupDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.pojo.PageParam;
import cn.iocoder.yudao.framework.common.util.object.BeanUtils;

import cn.iocoder.yudao.module.system.dal.mysql.group.GroupMapper;

import javax.annotation.Resource;

import static cn.iocoder.yudao.framework.common.exception.util.ServiceExceptionUtil.exception;
import static cn.iocoder.yudao.module.system.enums.ErrorCodeConstants.*;

/**
 * 用户组 Service 实现类
 *
 * @author 芋道源码
 */
@Service
@Validated
public class GroupServiceImpl implements GroupService {

    @Resource
    private GroupMapper groupMapper;

    @Override
    public Long createGroup(GroupSaveReqVO createReqVO) {
        //校验
        validGroupNameDuplicate(createReqVO.getName(), null);
        // 插入
        GroupDO group = BeanUtils.toBean(createReqVO, GroupDO.class);
        groupMapper.insert(group);
        // 返回
        return group.getId();
    }

    private void validGroupNameDuplicate(String name, Long id) {
        GroupDO group=groupMapper.selectByName(name);
        if (group==null){
            return;
        }
        if (id == null){
            throw exception(GROUP_NAME_DUPLICATE,name);
        }
        if (!group.getId().equals(id)){
            throw exception(GROUP_NAME_DUPLICATE,name);
        }
    }

    @Override
    public void updateGroup(GroupSaveReqVO updateReqVO) {
        // 校验存在
        validateGroupExists(updateReqVO.getId());
        //校验用户名称是否重复
        validGroupNameDuplicate(updateReqVO.getName(), updateReqVO.getId());
        // 更新
        GroupDO updateObj = BeanUtils.toBean(updateReqVO, GroupDO.class);
        groupMapper.updateById(updateObj);
    }

    @Override
    public void deleteGroup(Long id) {
        // 校验存在
        validateGroupExists(id);
        // 删除
        groupMapper.deleteById(id);
    }

    private void validateGroupExists(Long id) {
        if (groupMapper.selectById(id) == null) {
            throw exception(GROUP_NOT_EXISTS);
        }
    }

    @Override
    public GroupDO getGroup(Long id) {
        return groupMapper.selectById(id);
    }

    @Override
    public PageResult<GroupDO> getGroupPage(GroupPageReqVO pageReqVO) {
        return groupMapper.selectPage(pageReqVO);
    }

}