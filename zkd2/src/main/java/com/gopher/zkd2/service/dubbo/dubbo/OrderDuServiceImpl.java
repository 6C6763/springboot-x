package com.gopher.zkd2.service.dubbo.dubbo;

import com.gopher.api.service.dubbo.order.OrderDuService;
import org.apache.dubbo.config.annotation.Service;


/**
 * @author 6c6763
 * @date 2020/10/21
 */
@Service
public class OrderDuServiceImpl implements OrderDuService {

    @Override
    public String listOrders(String param) {
        return "hello gopher";
    }
}
