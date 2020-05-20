package com.course.server;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@RestController
@Api(value = "/", description = "这是我全部的get方法")//swagger的
public class MyGetMethod {

    //浏览器访问：/getCookies
    @RequestMapping(value = "/getCookies", method = RequestMethod.GET)
    @ApiOperation(value = "通过该方法获取cookie值", httpMethod = "GET")
    public String getCookies(HttpServletResponse response) {
        //HttpServletRequest装请求信息的类
        //HttpServletResponse装响应信息的类
        Cookie cookie = new Cookie("login", "true");
        response.addCookie(cookie);
        return "恭喜你获得cookies成功";
    }

    /**
     * 要求客户端携带cookies访问
     * 这是一个需要携带cookies信息才能访问的get请求
     * 操作过程：启动jmeter，配置http请求，post方式，路径/get/with/cookies，地址：localhost，HttpCookie管理器中添加login：true localhost(域) /
     */
    @RequestMapping(value = "/get/with/cookies", method = RequestMethod.POST)
    public String getWithCookies(HttpServletRequest request) {
        Cookie[] cookies = request.getCookies();
        if (Objects.isNull(cookies)) {
            return "你必须携带cookies信息来";
        }
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals("login") && cookie.getValue().equals("true")) {
                return "这是一个需要携带cookies信息才能访问的get请求";
            }
        }
        return "你必须携带cookies信息来";
    }

    /**
     * 开发一个需要携带参数才能访问的get请求
     * 第一种实现方式  url:key=value&key=value
     * 我们来模拟获取商品列表
     * 浏览器访问：localhost:port/get/with/param?start=10&end=20
     */
    @RequestMapping(value = "/get/with/param", method = RequestMethod.GET)
    @ApiOperation(value = "需要携带参数才能访问的get请求第一种实现", httpMethod = "GET")
    public Map<String, Integer> getList(@RequestParam Integer start, @RequestParam Integer end) {
        Map<String, Integer> myList = new HashMap<>();
        myList.put("鞋子", 400);
        myList.put("干脆面", 1);
        myList.put("衬衣", 300);
        return myList;
    }

    /**
     * 第二种需要携带参数访问的get请求
     * 浏览器访问:localhost:port/get/with/param/10/20
     */
    @RequestMapping(value = "/get/with/param/{start}/{end}")
    @ApiOperation(value = "需要携带参数访问的get请求第二种实现", httpMethod = "GET")
    public Map myGetList(@PathVariable Integer start, @PathVariable Integer end) {
        Map<String, Integer> myList = new HashMap<>();
        myList.put("白色鞋子", 400);
        myList.put("小浣熊", 1);
        myList.put("衬衣", 300);
        return myList;
    }
}