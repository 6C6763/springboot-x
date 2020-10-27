package com.gopher.api.service.dubbo.order;

/**
 * @author gopher lee
 * @date 2020/10/21
 */
public interface OrderDuService {

    /**
     * 查询订单接口
     * @param param json
     * @return json
     */
    String listOrders(String param);
}
