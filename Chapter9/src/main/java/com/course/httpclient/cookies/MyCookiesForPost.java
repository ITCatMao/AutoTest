package com.course.httpclient.cookies;

import org.apache.http.HttpResponse;
import org.apache.http.client.CookieStore;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.cookie.Cookie;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

/**
 * 命令行进入到Chapter10
 * 执行：java -jar ./moco-runner-0.11.0-standalone.jar http -p 8888 -c startupWithCookies.json  启动
 * 再执行该处的Test方法即可
 */
public class MyCookiesForPost {

    private String url;

    private ResourceBundle bundle;

    private CookieStore store;//用来存储cookie信息

    @BeforeTest
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
        //CookieStore store = client.getCookieStore();
        this.store = client.getCookieStore();
        List<Cookie> cookieList = store.getCookies();

        for (Cookie cookie : cookieList) {
            String name = cookie.getName();
            String value = cookie.getValue();
            System.out.println("cookie name=" + name + ";cookie value =" + value);
        }
    }

    @Test(dependsOnMethods = {"testGetCookies"})
    private void testPostMethod() throws IOException {

        String uri = bundle.getString("test.post.with.cookies");
        String testurl = this.url + uri;//拼接最终的测试地址

        //声明一个client对象，用来进行方法的执行
        DefaultHttpClient client = new DefaultHttpClient();

        //声明一个方法，这个方法就是post方法
        HttpPost post = new HttpPost(testurl);

        //添加参数
        JSONObject param = new JSONObject();
        param.put("name", "huhansan");
        param.put("age", "18");

        //设置请求头信息 设置header信息
        post.setHeader("content-type", "application/json");

        //将参数信息添加到方法中
        StringEntity entity = new StringEntity(param.toString(), "utf-8");
        post.setEntity(entity);

        //声明一个对象来进行响应结果的存储
        String result;

        //设置cookies信息
        client.setCookieStore(this.store);

        //执行post方法
        HttpResponse response = client.execute(post);

        //获取响应结果
        result = EntityUtils.toString(response.getEntity(), "utf-8");
        System.out.println(result);

        //处理结果，就是判断返回结果是否符合预期
        //将返回的响应结果字符串转换成对象
        JSONObject resultJson = new JSONObject(result);

        //获取到结果值
        String success = (String) resultJson.get("huhansan");
        String status = (String) resultJson.get("status");

        //具体的判断返回结果的值
        Assert.assertEquals("success", success);
        Assert.assertEquals("1", status);
    }
}
