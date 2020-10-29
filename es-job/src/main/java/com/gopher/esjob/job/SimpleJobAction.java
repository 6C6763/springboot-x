package com.gopher.esjob.job;

import com.dangdang.ddframe.job.api.ShardingContext;
import com.dangdang.ddframe.job.api.simple.SimpleJob;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author 6c6763
 * @date 2020/10/28
 */
public class SimpleJobAction implements SimpleJob {

    @Override
    public void execute(ShardingContext context) {
        System.out.println(String.format("Item: %s | Time: %s | Thread: %s ",
                context.getShardingItem(),
                new SimpleDateFormat("HH:mm:ss").format(new Date()),
                Thread.currentThread().getId()));
    }
}
