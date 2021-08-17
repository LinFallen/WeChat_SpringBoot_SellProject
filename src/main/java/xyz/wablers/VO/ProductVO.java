package xyz.wablers.VO;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author Wablers
 * @version 1.0
 * @description: 商品类目概要
 * @date 2021/8/5 17:20
 */

@Data
public class ProductVO implements Serializable {

    private static final long serialVersionUID = 3479655511742083760L;
    // 则返回的Json数据为name，而不是categoryName
    @JsonProperty("name")
    private String categoryName;
    @JsonProperty("type")
    private Integer categoryType;
    @JsonProperty("foods")
    private List<ProductInfoVO> products;

    public ProductVO(String categoryName, Integer categoryType) {
        this.categoryName = categoryName;
        this.categoryType = categoryType;
    }

    public ProductVO() {
    }
}
