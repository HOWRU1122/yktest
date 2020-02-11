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
public class DouyinShareTest {

    @Autowired
    private TestResultDao testResultDao;
    @Test
    public void user_info() throws IOException {
        //用户信息
        String result = "";
        String url = "http://47.97.206.10/api/douyin_share/user_info?share_id=104255897823";
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
            testResultDao.insertResult("DouyinShare",200, new Date(), "测试异常，e:" + e.getMessage(), url, "user_info",result);
            return;
        }
        if (Statuscode != 200){
            testResultDao.insertResult("DouyinShare",Statuscode, new Date(), "http请求错误", url,"user_info",result);

        }
        else if (code != 0) {
            testResultDao.insertResult("DouyinShare",code, new Date(), "业务请求错误", url,"user_info",result);

        }
        else {
            testResultDao.insertResult("DouyinShare",200, new Date(), "成功", url,"user_info",result);
            System.out.println("成功，" + "请求url：" + url);
        }

    }

    @Test
    public void user_video() throws IOException {
        //用户视频
        String result = "";
        String url = "http://47.97.206.10/api/douyin_share/user_video?share_id=104255897823&max_cursor=0";
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
            testResultDao.insertResult("DouyinShare",200, new Date(), "测试异常，e:" + e.getMessage(), url, "user_video",result);
            return;
        }
        if (Statuscode != 200){
            testResultDao.insertResult("DouyinShare",Statuscode, new Date(), "http请求错误", url,"user_video",result);

        }
        else if (code != 0) {
            testResultDao.insertResult("DouyinShare",code, new Date(), "业务请求错误", url,"user_video",result);

        }
        else {
            testResultDao.insertResult("DouyinShare",200, new Date(), "成功", url,"user_video",result);
            System.out.println("成功，" + "请求url：" + url);
        }

    }

}
