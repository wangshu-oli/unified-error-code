package oliver.unifiederrorcode.utils;

import oliver.unifiederrorcode.errorcode.BizErrorCode;
import oliver.unifiederrorcode.exception.BizException;

/**
 * @author zhangxiaojian
 * @date 2022年06月14日 15:12
 */
public class ExceptionUtil {

    private ExceptionUtil() {
    }

    public static BizException getException(BizErrorCode bizErrorCode) {
        return new BizException(bizErrorCode);
    }

    public static BizException getException(BizErrorCode bizErrorCode, String errorMessage) {
        return new BizException(bizErrorCode, errorMessage);
    }

    public static BizException getException(BizErrorCode bizErrorCode, Throwable cause) {
        return new BizException(bizErrorCode, cause);
    }

    public static BizException getException(BizErrorCode bizErrorCode, String errorMessage, Throwable cause) {
        return new BizException(bizErrorCode, errorMessage, cause);
    }
}
