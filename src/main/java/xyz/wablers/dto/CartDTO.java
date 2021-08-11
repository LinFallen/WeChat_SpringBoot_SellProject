package xyz.wablers.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author Wablers
 * @version 1.0
 * @description: 购物车
 * @date 2021/8/11 20:10
 */

@Data
@AllArgsConstructor
public class CartDTO {

    //商品Id
    private String productId;
    //商品购买数量
    private Integer productQuantity;

    public CartDTO() {

    }
}
