package oliver.unifiederrorcode.errorcode;

import oliver.unifiederrorcode.enums.BusinessLineCommonCode;

/**
 * @author Oliver
 * @date 2022年06月13日 16:27
 */
public interface BizErrorCode {

    /**
     * 返回业务域内的三位功能错误码
     */
    String getCode();

    /**
     * 返回业务域内的三位功能错误码对应的描述信息
     */
    String getErrorMsg();

    /**
     * 业务线错误码业务域错误码公共字段
     */
    BusinessLineCommonCode getBusinessLineCommonCode();

    /**
     * 将业务域代码和功能代码组装成6位完整错误码
     */
    default String get6Code() {
        return String.format("%s%s", getBusinessLineCommonCode().getCode(), getCode());
    }

}
