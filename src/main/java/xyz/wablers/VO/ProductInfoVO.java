package xyz.wablers.VO;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @author Wablers
 * @version 1.0
 * @description: 商品详情
 * @date 2021/8/5 17:23
 */

@Data
public class ProductInfoVO implements Serializable {

    private static final long serialVersionUID = 2184499351863851479L;
    // 商品id,使用string防止爆long，模拟大型项目
    @JsonProperty("id")
    private String productId;
    // 商品名称
    @JsonProperty("name")
    private String productName;
    // 商品单价
    @JsonProperty("price")
    private BigDecimal productPrice;
    // 商品描述
    @JsonProperty("description")
    private String productDescription;
    // 商品图片url
    @JsonProperty("icon")
    private String productIcon;
}
