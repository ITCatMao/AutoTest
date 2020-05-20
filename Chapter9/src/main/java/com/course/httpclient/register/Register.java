package com.course.httpclient.register;

import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Register {
    public static void main(String[] args) throws IOException {
        //接口自动化-第三方的框架工具：java net、HttpClient


        //1.请求链接，接口地址；2.请求参数；
        String url = "htto://120.78.128.25:8080";
        //3.请求方式get/post
        HttpPost post = new HttpPost(url);
        //添加多个参数
        List<BasicNameValuePair> parameters = new ArrayList<>();
        parameters.add(new BasicNameValuePair("mobile", "13688886666"));
        parameters.add(new BasicNameValuePair("pwd", "123456"));
        parameters.add(new BasicNameValuePair("regname", "tom"));
        //参数设置到请求体
        post.setEntity(new UrlEncodedFormEntity(parameters));

        //4.调用工具进行发包->发数据包、发起一个请求
        DefaultHttpClient httpClient = new DefaultHttpClient();
        org.apache.http.HttpResponse response = httpClient.execute(post);


        //5.响应->把返回的数据提取出来；
        String result = EntityUtils.toString(response.getEntity());


        //6.断言->判断->看最后的结果是否符合预期->符合则通过，否则不通过


    }

    public static void get() throws IOException {
        /**
         * 发包需要准备：
         * postman：1.请求链接，接口地址；2.请求参数；3.请求方式get/post；4.调用工具进行发包->发数据包、发起一个请求
         * 5.响应->把返回的数据提取出来；6.断言->判断->看最后的结果是否符合预期->符合则通过，否则不通过
         * */

        //1.请求链接，接口地址；2.请求参数；
        String url = "htto://120.78.128.25:8080";
        url += "?mobilephone=13688886666&pwd=123456&regname=tom";

        //3.请求方式get/post
        HttpGet get = new HttpGet(url);

        //4.调用工具进行发包->发数据包、发起一个请求
        DefaultHttpClient client = new DefaultHttpClient();
        org.apache.http.HttpResponse response = client.execute(get);


        //5.响应->把返回的数据提取出来；
        String result = EntityUtils.toString(response.getEntity());


        //6.断言->判断->看最后的结果是否符合预期->符合则通过，否则不通过
        System.out.println(result);
    }
}

