package com.heima.trade.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.heima.trade.domain.po.Order;
import com.heima.trade.domain.dto.OrderFormDTO;


/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 虎哥
 * @since 2023-05-05
 */
public interface IOrderService extends IService<Order> {

    Long createOrder(OrderFormDTO orderFormDTO);

    void markOrderPaySuccess(Long orderId);
}
