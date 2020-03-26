package com.tester.cases;

import com.alibaba.fastjson.JSONObject;
import com.tester.dao.TestResultDao;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;
import java.util.Date;
@RunWith(SpringRunner.class)
@SpringBootTest
public class TBTest {
    @Autowired
    private TestResultDao testResultDao;
    @Test
    public void get_tb_comment() throws IOException {
        //淘宝评论
        String result = new String();
        String url = "http://47.97.206.10/api/tb/get_tb_comment?item_id=22538999781&page=1&size=20";
        HttpGet get = new HttpGet(url);
        HttpClient client = new DefaultHttpClient();
        Integer code,Statuscode;
        try {
            HttpResponse response = client.execute(get);
            result = EntityUtils.toString(response.getEntity(), "utf-8");
            Statuscode = response.getStatusLine().getStatusCode();
            JSONObject jsonObject = JSONObject.parseObject(result);
            code = jsonObject.getInteger("code");
        } catch (Exception e) {
            testResultDao.insertResult("TB",500, new Date(), "测试异常，e:" + e.getMessage(), url, "get_tb_comment",result);
            return;
        }
        if (Statuscode != 200){
            testResultDao.insertResult("TB",Statuscode, new Date(), "http请求错误", url,"get_tb_comment",result);

        }
        else if (code != 0) {
            testResultDao.insertResult("TB",code, new Date(), "业务请求错误", url,"get_tb_comment",result);

        }
        else {
            testResultDao.insertResult("TB",200, new Date(), "成功", url,"get_tb_comment",result);
            System.out.println("成功，" + "请求url：" + url);
        }

    }
}
