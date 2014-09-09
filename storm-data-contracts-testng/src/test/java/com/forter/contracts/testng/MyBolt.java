package com.forter.contracts.testng;

import backtype.storm.task.TopologyContext;
import com.forter.contracts.IContractsBolt;
import com.google.common.collect.Lists;

import java.util.Collection;
import java.util.Map;

/**
 * Sample ContractBolt
 */
public class MyBolt implements IContractsBolt<MyBoltInput,Collection<MyBoltOutput>> {

    @Override
    public void prepare(Map stormConf, TopologyContext context) {

    }

    @Override
    public Collection<MyBoltOutput> execute(MyBoltInput input) {
        MyBoltOutput output = new MyBoltOutput();
        if (input.y.isPresent()) {
            output.z = input.y.get() + input.x;
        }
        else {
            output.z = "default" + input.x;
        }
        return Lists.newArrayList(output);
    }

    @Override
    public Collection<MyBoltOutput> createDefaultOutput() {
        return Lists.newArrayList();
    }

    @Override
    public void cleanup() {

    }

    @Override
    public Map<String, Object> getComponentConfiguration() {
        return null;
    }
}