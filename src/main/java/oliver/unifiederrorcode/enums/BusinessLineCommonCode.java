package oliver.unifiederrorcode.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 这里记录所有子域的业务公共错误码部分（前三位），制定后统一管理，不允许自定义
 * @author zhangxiaojian
 */
@AllArgsConstructor
@Getter
public enum BusinessLineCommonCode {
    /**
     * 公共错误码 000
     */
    COMMON("000","公共错误码"),

    /**
     * 测试子域1
     */
    PAAS_ISG("001","测试子域1的错误信息"),

    /**
     * 测试子域2
     */
    AI_SCENE("020","测试子域2的错误信息"),

    /*
     * 语音子域
     */
    /*……*/
    ;
    private String code;

    private String des;
}
