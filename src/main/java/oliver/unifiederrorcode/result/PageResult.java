package oliver.unifiederrorcode.result;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * 响应体分装类 - 带分页
 *
 * @author zhangxiaojian
 * @date 2022/6/13 16:42
 */
@EqualsAndHashCode(callSuper = true)
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@NoArgsConstructor
public class PageResult<T> extends Result<T> {

    /**
     * 总共条数
     */
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Integer totalCount;

    /**
     * 页数
     */
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Integer pageNo;

    /**
     * 本页条数
     */
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Integer pageSize;

    public static <T> PageResult<T> success(T data, Integer totalCount, Integer pageNo, Integer pageSize) {
        PageResult<T> result = buildBasic(SUCCEED);
        result.setData(data);
        result.setTotalCount(totalCount);
        result.setPageNo(pageNo);
        result.setPageSize(pageSize);
        return result;
    }

    private static <T> PageResult<T> buildBasic(String status) {
        PageResult<T> result = new PageResult<>();
        result.setReturnStatus(status);
        result.setServerTime(System.currentTimeMillis());
        result.setRequestId(createRequestId());
        return result;
    }
}
