package xyz.wablers.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xyz.wablers.dataobject.SellerInfo;
import xyz.wablers.repository.SellerInfoRepository;
import xyz.wablers.service.SellerService;

/**
 * @author Wablers
 * @version 1.0
 * @description: TODO
 * @date 2021/8/13 16:48
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
