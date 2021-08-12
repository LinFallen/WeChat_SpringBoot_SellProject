package xyz.wablers.exception;

import lombok.Data;
import xyz.wablers.enums.ResultEnum;

/**
 * @author Wablers
 * @version 1.0
 * @description: 购买异常类
 * @date 2021/8/9 13:41
 */

@Data
public class SellException extends RuntimeException {
    //错误码
    private Integer code;

    public SellException(ResultEnum resultEnum) {
        super(resultEnum.getMsg());
        this.code = resultEnum.getCode();
    }

    public SellException(Integer code, String message) {
        super(message);
        this.code = code;
    }
}
