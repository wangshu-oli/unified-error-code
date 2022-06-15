package oliver.unifiederrorcode.result;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import java.io.Serializable;
import java.util.UUID;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 响应体分装类
 * @author zhangxiaojian
 * @date 2022/6/13 16:42
 */
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@NoArgsConstructor
public class Result<T> implements Serializable {

    public static final String SUCCEED = "SUCCEED";
    public static final String FAILED = "FAILED";

    /**
     * 返回状态:SUCCEED和FAILED
     */
    private String returnStatus;

    /**
     * 时间戳
     */
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Long serverTime;

    /**
     * 请求ID
     */
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String requestId;

    /**
     * 错误码
     */
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String errorCode;

    /**
     * 错误信息
     */
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String errorMessage;

    /**
     * 错误扩展信息
     */
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Object extMessage;

    /**
     * 封装数据
     */
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private T data;


    public static <T> Result<T> fail(String errCode, String errMsg) {
        Result<T> result = buildBasic(FAILED);
        result.setErrorCode(errCode);
        result.setErrorMessage(errMsg);
        return result;
    }


    public static <T> Result<T> success(T data) {
        Result<T> result = success();
        result.setData(data);
        return result;
    }

    public static <T> Result<T> success() {
        return buildBasic(SUCCEED);
    }

    private static <T> Result<T> buildBasic(String status) {
        Result<T> result = new Result<>();
        result.setReturnStatus(status);
        result.setServerTime(System.currentTimeMillis());
        result.setRequestId(createRequestId());
        return result;
    }

    protected static String createRequestId() {
        return UUID.randomUUID().toString().replaceAll("-", "");
    }

}
