package xyz.wablers.dataobject;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

/**
 * @author Wablers
 * @version 1.0
 * @description: 商家账户JavaBean
 * @date 2021/8/13 16:42
 */

@Data
@Entity
public class SellerInfo {
    //卖家id
    @Id
    private String Id;
    //卖家用户名
    private String username;
    //卖家密码
    private String password;
    //卖家微信openid
    private String openid;
}

