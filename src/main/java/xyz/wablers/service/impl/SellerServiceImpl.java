package xyz.wablers.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xyz.wablers.dataobject.SellerInfo;
import xyz.wablers.repository.SellerInfoRepository;
import xyz.wablers.service.SellerService;

/**
 * @author Wablers
 * @version 1.0
 * @description: 买家端接口实现
 * @date 2021/8/13 21:48
 */
@Service
public class SellerServiceImpl implements SellerService {

    @Autowired
    private SellerInfoRepository repository;

    @Override
    public SellerInfo findSellerInfoByOpenid(String openid) {
        return repository.findByOpenid(openid);
    }
}
