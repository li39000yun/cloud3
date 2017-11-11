package com.lyq.test;

import com.lyq.dao.AccTotalDao;
import com.lyq.model.AccTotal;
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
public class OrderDaoTest {

    @Autowired
    private AccTotalDao accTotalDao;

    @Test
    public void testUpdateTotal() throws Exception {
        AccTotal accTotal = new AccTotal();
        accTotal.setAccTotal(2000);
        accTotal.setUserId(1510418044960L);
        accTotalDao.updateTotal(accTotal);
    }

    @Test
    public void find() {
        AccTotal accTotal = accTotalDao.findByUserId(1510418044960L);
        System.out.println("accTotal is " + accTotal.getAccTotal());
    }

}
