package xyz.wablers.service;

import xyz.wablers.dataobject.SellerInfo;

/**
 * @author Wablers
 * @version 1.0
 * @description: 卖家端
 * @date 2021/8/13 21:41
 */
public interface SellerService {

    /**
     * 通过openid查询卖家端信息
     * @param openid
     * @return
     */
    SellerInfo findSellerInfoByOpenid(String openid);
}
