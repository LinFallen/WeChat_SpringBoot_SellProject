package xyz.wablers.service;

/**
 * @author Wablers
 * @version 1.0
 * @description: 秒杀
 * @date 2021/8/17 12:15
 */
public interface SecKillService {

    /**
     * 查询秒杀活动特价商品的信息
     * @param productId
     * @return
     */
    String querySecKillProductInfo(String productId);

    /**
     * 模拟不同用户秒杀同一商品的请求
     * @param productId
     * @return
     */
    void orderProductMockDiffUser(String productId);

}