package cn.hncht.plug.Controller;

import cn.hncht.plug.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/login")
public class Login {


    @RequestMapping("/getUser")
    @ResponseBody
    public Map getBacklog(HttpServletRequest request,HttpServletResponse response) throws UnsupportedEncodingException {
        Map<String,String> res = new HashMap<String, String>();
        String account = request.getParameter("account");
        String password = request.getParameter("password");
        response.setHeader("Access-Control-Allow-Origin", "*"); //设置允许任何域名跨域访问
        if ("admin".equals(account) && "123456".equals(password)){
            res.put("flag","success");
            return res;
        }else {
            res.put("flag","error");
            return res;
        }
    }


}
