package com.gopher.esjob.job;

import com.dangdang.ddframe.job.api.ShardingContext;
import com.dangdang.ddframe.job.api.dataflow.DataflowJob;

import java.util.Arrays;
import java.util.List;

/**
 * @author 6c6763
 */
public class DataFlowJobAction implements DataflowJob<String> {
    @Override
    public List<String> fetchData(ShardingContext shardingContext) {
        // 获取到了数据
        return Arrays.asList("vincent", "liao", "fen");
    }

    @Override
    public void processData(ShardingContext shardingContext, List<String> data) {
        data.forEach(x -> System.out.println("开始处理数据：" + x));
    }
}