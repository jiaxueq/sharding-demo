package com.example.shardingdemo.config;

import lombok.extern.slf4j.Slf4j;
import org.apache.shardingsphere.api.sharding.standard.PreciseShardingAlgorithm;
import org.apache.shardingsphere.api.sharding.standard.PreciseShardingValue;



import java.util.Collection;

//自定义分表规则类
@Slf4j
public class UserShardingAlgorithm implements PreciseShardingAlgorithm<Integer> {

    @Override
    public String doSharding(Collection<String> availableTargetNames, PreciseShardingValue<Integer> shardingValue) {
        // 真实节点
        availableTargetNames.forEach(item -> log.info("actual node table:{}", item));
        log.info("logic table name:{},rout column:{}", shardingValue.getLogicTableName(), shardingValue.getColumnName());
        // 精确分片
        log.info("column value:{}", shardingValue.getValue());
        for (String each : availableTargetNames) {
            if (("user_c_" + shardingValue.getValue()%4).equals(each)) {
                return each;
            }
        }
        return null;
    }

}

