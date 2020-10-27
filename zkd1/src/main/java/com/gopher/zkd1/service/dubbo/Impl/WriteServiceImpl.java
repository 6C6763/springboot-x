package com.gopher.zkd1.service.dubbo.Impl;

import com.gopher.zkd1.service.dubbo.WriteService;
import org.apache.dubbo.config.annotation.Service;

/**
 * @author 6c6763
 * @date 2020/10/22
 */
@Service(cluster = "failfast", loadbalance = "leastactive", owner = "6c6763")
public class WriteServiceImpl implements WriteService {
}
