package com.course.httpclient.cookies;

import org.apache.http.HttpResponse;
import org.apache.http.client.CookieStore;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.cookie.Cookie;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import javax.swing.text.html.parser.Entity;
import java.io.IOException;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

/**
 * 命令行进入到Chapter10
 * 执行：java -jar ./moco-runner-0.11.0-standalone.jar http -p 8888 -c startupWithCookies.json  启动
 * 再执行该处的Test方法即可
 *
 * */

public class MyCookiesForGet {

    private String url;

    private ResourceBundle bundle;

    private CookieStore store;//用来存储cookie信息

    @BeforeTest //读取application/properties中的配置
    public void beforeTest() {
        bundle = ResourceBundle.getBundle("application", Locale.CHINA);
        url = bundle.getString("test.url");
    }

    @Test
    public void testGetCookies() throws IOException {
        String result;
        //配置文件中拼接测试url
        String uri = bundle.getString("getCookies.uri");
        String testurl = this.url + uri;

        HttpGet get = new HttpGet(testurl);
        DefaultHttpClient client = new DefaultHttpClient();
        HttpResponse response = client.execute(get);
        result = EntityUtils.toString(response.getEntity(), "UTF-8");
        System.out.println(result);

        //获取cookies信息
//        CookieStore store = client.getCookieStore();
        this.store = client.getCookieStore();
        List<Cookie> cookieList = store.getCookies();

        for (Cookie cookie : cookieList) {
            String name = cookie.getName();
            String value = cookie.getValue();
            System.out.println("cookie name=" + name + ";cookie value =" + value);
        }
    }


    @Test(dependsOnMethods = {"testGetCookies"})//依赖上述测试方法
    private void testGetWithCookies() throws IOException {

        String uri = bundle.getString("test.get.with.cookies");
        String testurl = this.url + uri;

        HttpGet get = new HttpGet(testurl);
        DefaultHttpClient client = new DefaultHttpClient();

        //设置cookies信息
        client.setCookieStore(this.store);

        HttpResponse response = client.execute(get);

        //获取响应的状态码
        int statusCode = response.getStatusLine().getStatusCode();
        System.out.println("statusCode=" + statusCode);

        if (statusCode == 200) {
            String result = EntityUtils.toString(response.getEntity(), "UTF-8");
            System.out.println(result);
        }

    }

}
