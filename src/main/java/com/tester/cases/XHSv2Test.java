package com.tester.cases;

import com.alibaba.fastjson.JSONObject;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.testng.annotations.Test;

import java.io.IOException;

public class XHSv2Test {
    @Test(groups = "xhsv2")
    public void call_nums() throws IOException {
        //调用次数
        String result;
        String url = "http://47.97.206.10/api/xhs_v2/call_nums";
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

    @Test(groups = "xhsv2")
    public void home_feed() throws IOException {
        //首页推荐
        String result;
        String url = "http://47.97.206.10/api/xhs_v2/home_feed";
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
    @Test(groups = "xhsv2")
    public void user_info() throws IOException {
        //用户信息
        String result;
        String url = "http://47.97.206.10/api/xhs_v2/user_info?user_id=5a73c5fa4eacab4c4ccc9778";
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
    @Test(groups = "xhsv2")
    public void user_note() throws IOException {
        //用户笔记
        String result;
        String url = "http://47.97.206.10/api/xhs_v2/user_note?user_id=5a73c5fa4eacab4c4ccc9778&page=1&page_size=10";
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
    @Test(groups = "xhsv2")
    public void note_detail() throws IOException {
        //笔记详情
        String result;
        String url = "http://47.97.206.10/api/xhs_v2/note_detail?note_id=5df5d21d000000000100790c";
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
    @Test(groups = "xhsv2")
    public void note_comments() throws IOException {
        //笔记评论
        String result;
        String url = "http://47.97.206.10/api/xhs_v2/note_comments?note_id=5df5d21d000000000100790c&num=10&start=5df738e200000000010091d4";
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
    @Test(groups = "xhsv2")
    public void user_video() throws IOException {
        //用户视频
        String result;
        String url = "http://47.97.206.10/api/xhs_v2/user_video?user_id=5a73c5fa4eacab4c4ccc9778&page=1&page_size=10";
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
    @Test(groups = "xhsv2")
    public void video_detail() throws IOException {
        //视频详情
        String result;
        String url = "http://47.97.206.10/api/xhs_v2/video_detail?note_id=5dadbbfa0000000001001129";
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
    @Test(groups = "xhsv2")
    public void user_focus() throws IOException {
        //用户关注
        String result;
        String url = "http://47.97.206.10/api/xhs_v2/user_focus?user_id=5a73c5fa4eacab4c4ccc9778";
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
    @Test(groups = "xhsv2")
    public void user_fans() throws IOException {
        //用户粉丝
        String result;
        String url = "http://47.97.206.10/api/xhs_v2/user_fans?user_id=5a73c5fa4eacab4c4ccc9778&start=5666f2cc82ec397fccb607a4";
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
    @Test(groups = "xhsv2")
    public void note_search() throws IOException {
        //笔记关键词搜索
        String result;
        String url = "http://47.97.206.10/api/xhs_v2/note/search?keyword=蛋糕&page=1&page_size=20";
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

    @Test(groups = "xhsv2")
    public void topic_notes() throws IOException {
        //话题笔记
        String result;
        String url = "http://47.97.206.10/api/xhs_v2/topic_notes?topic_id=5cc6ce90ec9d135e33e97b7e&page=1&page_size=200";
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
    @Test(groups = "xhsv2")
    public void channel_refresh() throws IOException {
        //刷新获取店铺及商品
        String result;
        String url = "http://47.97.206.10/api/xhs_v2/channel_refresh";
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
    @Test(groups = "xhsv2")
    public void item_search() throws IOException {
        //获取商品关键词搜索页
        String result;
        String url = "http://47.97.206.10/api/xhs_v2/item/search?keyword=EMXEE嫚熙&filters=&page=1&page_size=20";
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
    @Test(groups = "xhsv2")
    public void shop_items() throws IOException {
        //获取店铺商品
        String result;
        String url = "http://47.97.206.10/api/xhs_v2/shop_items?shop_id=59c5cbf577e3086597fc4706&page=1";
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
    @Test(groups = "xhsv2")
    public void shop_font() throws IOException {
        //获取店铺信息1
        String result;
        String url = "http://47.97.206.10/api/xhs_v2/shop_font?shop_id=59c5cbf577e3086597fc4706";
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
    @Test(groups = "xhsv2")
    public void shop_info() throws IOException {
        //获取店铺信息2
        String result;
        String url = "http://47.97.206.10/api/xhs_v2/shop_info?shop_id=59c5cbf577e3086597fc4706";
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
    @Test(groups = "xhsv2")
    public void item_info() throws IOException {
        //获取商品信息: 标题、描述、图片等
        String result;
        String url = "http://47.97.206.10/api/xhs_v2/item_info?item_id=5b1ccd8570e7527d5b74caae";
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
    @Test(groups = "xhsv2")
    public void item_price() throws IOException {
        //获取商品信息: 可提取商品价格
        String result;
        String url = "http://47.97.206.10/api/xhs_v2/item_price?item_id=5b1ccd8570e7527d5b74caae";
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
    @Test(groups = "xhsv2")
    public void item_comm() throws IOException {
        //获取商品评论内容
        String result;
        String url = "http://47.97.206.10/api/xhs_v2/item_comm?item_id=5b1ccd8570e7527d5b74caae&page=1";
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
