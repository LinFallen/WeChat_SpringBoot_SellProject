package xyz.wablers.dataobject;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * @author Wablers
 * @version 1.0
 * @description: TODO
 * @date 2021/8/13 16:42
 */

@Data
@Entity
public class SellerInfo {

    @Id
    private String sellerId;

    private String username;

    private String password;

    private String openid;
}

