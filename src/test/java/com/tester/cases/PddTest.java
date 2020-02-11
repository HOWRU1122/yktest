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
public class PddTest {

    @Autowired
    private TestResultDao testResultDao;

    @Test
    public void get_pdd_date() throws IOException {
        //获取拼多多某个类目下的某个价格区间的某页数据信息
        String result = "";
        String url = "http://47.97.206.10/api/pdd_spider_api/get_pdd_date?cat_id=-1&range_from=400&range_to=410&page_number=1";
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
            testResultDao.insertResult("Pdd",500, new Date(), "测试异常，e:" + e.getMessage(), url, "get_pdd_date",result);
            return;
        }
        if (Statuscode != 200){
            testResultDao.insertResult("Pdd",Statuscode, new Date(), "http请求错误", url,"get_pdd_date",result);

        }
        else if (code != 0) {
            testResultDao.insertResult("Pdd",code, new Date(), "业务请求错误", url,"get_pdd_date",result);

        }
        else {
            testResultDao.insertResult("Pdd",200, new Date(), "成功", url,"get_pdd_date",result);
            System.out.println("成功，" + "请求url：" + url);
        }

    }

    @Test
    public void get_cat_id_list() throws IOException {
        //获取catid的列表
        String result = "";
        String url = "http://47.97.206.10/api/pdd_spider_api/get_cat_id_list";
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
            testResultDao.insertResult("Pdd",500, new Date(), "测试异常，e:" + e.getMessage(), url, "get_cat_id_list",result);
            return;
        }
        if (Statuscode != 200){
            testResultDao.insertResult("Pdd",Statuscode, new Date(), "http请求错误", url,"get_cat_id_list",result);

        }
        else if (code != 0) {
            testResultDao.insertResult("Pdd",code, new Date(), "业务请求错误", url,"get_cat_id_list",result);

        }
        else {
            testResultDao.insertResult("Pdd",200, new Date(), "成功", url,"get_cat_id_list",result);
            System.out.println("成功，" + "请求url：" + url);
        }


    }
}
