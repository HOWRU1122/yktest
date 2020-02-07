package com.tester.cases;

import com.alibaba.fastjson.JSONObject;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.testng.annotations.Test;

import java.io.IOException;

public class DouyinShareTest {
    @Test(groups = "douyinshare")
    public void user_info() throws IOException {
        //用户信息
        String result;
        String url = "http://47.97.206.10/api/douyin_share/user_info?share_id=104255897823";
        HttpGet get = new HttpGet(url);
        HttpClient client = new DefaultHttpClient();
        HttpResponse response = client.execute(get);
        result = EntityUtils.toString(response.getEntity(),"utf-8");
        int StatusCode = response.getStatusLine().getStatusCode();
        JSONObject jsonObject = JSONObject.parseObject(result);
        Integer code = jsonObject.getInteger("code");
        if(code == -200){
            System.out.println(result);
            throw new RuntimeException(result+"\n"+"请求url："+url);
        }
        if (code == -1){
            System.out.println(result);
            throw new RuntimeException(result+"\n"+"请求url："+url);
        }
        if (StatusCode != 200){
            System.out.println(result);
            throw new RuntimeException("失败，"+"请求url："+url);
        }
        else{
            System.out.println("成功，"+"请求url："+url);

        }

    }

    @Test(groups = "douyinawe")
    public void user_video() throws IOException {
        //用户视频
        String result;
        String url = "http://47.97.206.10/api/douyin_share/user_video?share_id=104255897823&max_cursor=0";
        HttpGet get = new HttpGet(url);
        HttpClient client = new DefaultHttpClient();
        HttpResponse response = client.execute(get);
        result = EntityUtils.toString(response.getEntity(),"utf-8");
        int StatusCode = response.getStatusLine().getStatusCode();
        JSONObject jsonObject = JSONObject.parseObject(result);
        Integer code = jsonObject.getInteger("code");
        if(code == -200){
            System.out.println(result);
            throw new RuntimeException(result+"\n"+"请求url："+url);
        }
        if (code == -1){
            System.out.println(result);
            throw new RuntimeException(result+"\n"+"请求url："+url);
        }
        if (StatusCode != 200){
            System.out.println(result);
            throw new RuntimeException("失败，"+"请求url："+url);
        }
        else{
            System.out.println("成功，"+"请求url："+url);

        }

    }

}
