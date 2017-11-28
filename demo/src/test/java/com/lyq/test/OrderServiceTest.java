package com.lyq.test;

import com.lyq.model.AccTotal;
import com.lyq.service.AccTotalService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by 云强 on 2017/11/8.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderServiceTest {

    @Autowired
    private AccTotalService accTotalService;

//    @Test
    public void find() {
        AccTotal accTotal = accTotalService.findByUserId(1510418044960L);
        if (accTotal != null) {
            System.out.println("accTotal is " + accTotal.getAccTotal());
        }
    }

}
