package com.gopher.esjob.web;

import com.dangdang.ddframe.job.config.JobCoreConfiguration;
import com.dangdang.ddframe.job.config.simple.SimpleJobConfiguration;
import com.dangdang.ddframe.job.lite.api.JobScheduler;
import com.dangdang.ddframe.job.lite.config.LiteJobConfiguration;
import com.dangdang.ddframe.job.reg.base.CoordinatorRegistryCenter;
import com.dangdang.ddframe.job.reg.zookeeper.ZookeeperConfiguration;
import com.dangdang.ddframe.job.reg.zookeeper.ZookeeperRegistryCenter;
import com.gopher.esjob.job.SimpleJobAction;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 6c6763
 * @date 2020/10/28
 */
@RestController
@RequestMapping("action")
public class EjAction {

    public static void main(String[] args) {
        // ZK 注册中心
        CoordinatorRegistryCenter regCenter =
                new ZookeeperRegistryCenter(
                        new ZookeeperConfiguration("http://127.0.0.1:2181", "elastic-job-demo")
                );
        regCenter.init();
        // 定义作业核心配置
        JobCoreConfiguration simpleCoreConfig =
                JobCoreConfiguration.newBuilder(
                        "MyElasticJob",
                        "0/2 * * * * ?",
                        1).build();
        // 定义 SIMPLE 类型配置
        SimpleJobConfiguration simpleJobConfig = new SimpleJobConfiguration(simpleCoreConfig,
                SimpleJobAction.class.getCanonicalName());
        // 定义 Lite 作业根配置
        LiteJobConfiguration simpleJobRootConfig = LiteJobConfiguration.newBuilder(simpleJobConfig).build();
        //构建 job​new JobScheduler(regCenter, simpleJobRootConfig).init();
        new JobScheduler(regCenter,simpleJobRootConfig).init();
    }
}
