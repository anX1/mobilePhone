package cn.hncht.plug.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

/**
 * 待办页面请求测试
 */
@Controller
@RequestMapping("/user")
public class TestBacklog {

    @RequestMapping("/index.bts")
    public String index() {
        return "/WEB-INF/index.html";
    }

    @RequestMapping("/getBacklog")
    @ResponseBody
    public Map getBacklog(HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException {
        request.setCharacterEncoding("UTF-8");
        String name = request.getParameter("name");
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("name",name);
        map.put("age","20");
        map.put("sex","男");
        return map;
    }

    @RequestMapping("/getXietong")
    @ResponseBody
    public Map getXietong(HttpServletRequest request) throws UnsupportedEncodingException {
        request.setCharacterEncoding("UTF-8");
        String name = request.getParameter("name").trim();
        int bs = 0;
        if ("协同-已办".equals(name)){
            bs = 1;
        } else if ("协同-已发".equals(name)) {
            bs = 2;
        } else if ("协同-待发".equals(name)) {
            bs = 3;
        }
        System.out.println(name);
        System.out.println(bs);
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("url","xietong.html?bs="+bs);
        map.put("bs",bs);
        return map;
    }



}
