package xyz.wablers.VO;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

/**
 * @author Wablers
 * @version 1.0
 * @description: http请求返回的最外层对象
 * @date 2021/8/5 17:15
 */

@Data
public class ResultVO<T> implements Serializable {
    /**
     * 这里使用GenerateSerialVersionUID插件自动生成序列化ID（快捷键为alt+z,可自己在setting中搜索GenerateSerial更改）
     *
     * 首先，必须知道，反序列化时会从序列化的二进制流中读取serialVersionUID与与本地实体类中的serialVersionUID进行比较
     * 若serialVersionUID相同，才能进行反序列化。
     *
     * Java序列化机制会根据编译时的class自动生成一个serialVersionUID作为序列化版本比较，
     * 但每次编译生成的class产生的serialVersionUID不同
     * 这个时候再反序列化时便会出现serialVersionUID不一致，导致反序列化失败。
     */
    private static final long serialVersionUID = 5690161981675865178L;
    // 错误码，0正确
    private Integer code;
    // 错误信息
    private String msg;
    // 数据
    private T data;
}
