package oliver.unifiederrorcode.enums;

import oliver.unifiederrorcode.errorcode.BizErrorCode;

/**
 * @author zhangxiaojian
 * @date 2022年06月14日 15:50
 */
public enum BaseErrorCode implements BizErrorCode {

    SUCCESS("000", "成功"),
    INTERNAL_SERVER_ERROR("001", "服务内部错误"),
    BAD_REQUEST("002", "请求不合法"),
    UNKNOWN_ERROR("003", "未知错误");

    private final String code;
    private final String errorMsg;

    @Override
    public String getCode() {
        return this.code;
    }

    @Override
    public String getErrorMsg() {
        return this.errorMsg;
    }

    @Override
    public BusinessLineCommonCode getBusinessLineCommonCode() {
        return BusinessLineCommonCode.COMMON;
    }

    private BaseErrorCode(final String code, final String errorMsg) {
        this.code = code;
        this.errorMsg = errorMsg;
    }
}
