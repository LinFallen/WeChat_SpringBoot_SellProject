package xyz.wablers.utils;

import xyz.wablers.VO.ResultVO;

/**
 * @author Wablers
 * @version 1.0
 * @description: 响应结果集工具类
 * @date 2021/8/6 9:47
 */
public class ResultVOUtil {

    public static ResultVO success(Object data) {
        return new ResultVO(0, "请求成功", data);
    }

    public static ResultVO success() {
        return success(null);
    }

    public static ResultVO error(Integer code, String msg) {
        return new ResultVO(code, msg, null);
    }
}
