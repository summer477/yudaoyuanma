package cn.iocoder.yudao.module.system.convert.social;

import cn.iocoder.yudao.module.system.api.social.dto.SocialUserBindReqDTO;
import cn.iocoder.yudao.module.system.controller.admin.socail.vo.user.SocialUserBindReqVO;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-12-13T17:26:36+0800",
    comments = "version: 1.6.2, compiler: javac, environment: Java 20.0.1 (Oracle Corporation)"
)
public class SocialUserConvertImpl implements SocialUserConvert {

    @Override
    public SocialUserBindReqDTO convert(Long userId, Integer userType, SocialUserBindReqVO reqVO) {
        if ( userId == null && userType == null && reqVO == null ) {
            return null;
        }

        SocialUserBindReqDTO socialUserBindReqDTO = new SocialUserBindReqDTO();

        if ( reqVO != null ) {
            socialUserBindReqDTO.setSocialType( reqVO.getType() );
            socialUserBindReqDTO.setCode( reqVO.getCode() );
            socialUserBindReqDTO.setState( reqVO.getState() );
        }
        socialUserBindReqDTO.setUserId( userId );
        socialUserBindReqDTO.setUserType( userType );

        return socialUserBindReqDTO;
    }
}
