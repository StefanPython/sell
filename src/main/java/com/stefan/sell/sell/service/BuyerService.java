package com.stefan.sell.sell.service;

import com.stefan.sell.sell.dto.OrderDTO;

/**
 * Created by Stefan
 * Create Date 2017-12-05/19:22
 */
public interface BuyerService {
    //查询一个订单
    OrderDTO findOrderOne(String openid, String orderId);

    //取消订单
    OrderDTO cancelOrder(String openid, String orderId);
}
