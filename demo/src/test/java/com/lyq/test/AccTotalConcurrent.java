package com.lyq.test;

/**
 * Created by 云强 on 2017/11/27.
 */
public class AccTotalConcurrent extends ConcurrentAbstract {

    public AccTotalConcurrent(int num) {
        super(num);
    }

    @Override
    void doWork() {
        AccTotalTest.addMoney();
    }
}
