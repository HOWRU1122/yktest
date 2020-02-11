package com.tester;

import com.tester.dao.TestResultDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

/**
 * @author xuyj
 * @date 2020/2/11
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class TestResultDaoTest {

    @Autowired
    private TestResultDao testResultDao;

    @Test
    public void testInsert() throws Exception {
        testResultDao.insertResult("item",200,new Date(),"成功","http://xzz","call_nums","result");
    }

}
