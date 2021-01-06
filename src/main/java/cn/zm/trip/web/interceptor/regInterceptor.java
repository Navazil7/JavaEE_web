package cn.zm.trip.web.interceptor;

import cn.zm.trip.web.domain.User;
import cn.zm.trip.web.service.UserService;
import org.apache.ibatis.jdbc.Null;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.PrintWriter;

//注册前验证账号信息注册邮箱是否已存在
public class regInterceptor implements HandlerInterceptor {
         @Autowired
         private UserService userService;
        @Override
        public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
            System.out.println("进行拦截");
            //获取请求的RUi:去除http:localhost:8080这部分剩下的
            String uri = request.getRequestURI();
            System.out.println(uri);
            //获取session
           String name= (String) request.getParameter("uname");
            System.out.println(name);
           String email=(String) request.getParameter("uemail");
           System.out.println(email);
//           String uname=userService.selectbyname(name).getUname();
////           System.out.println(uname);
            if(userService.selectbyname(name)!=null&&name.equals(userService.selectbyname(name).getUname())){
            request.setCharacterEncoding("UTF-8");
            response.setCharacterEncoding("UTF-8");
            response.setHeader("Content-type", "text/html;charset=UTF-8");
            PrintWriter out = response.getWriter();
            String loginPage = "/index";
            StringBuilder builder = new StringBuilder();
            builder.append("<script type=\"text/javascript\">");
            builder.append("alert('用户名已被注册！');");
            builder.append("window.top.location.href='");
            builder.append(loginPage);
            builder.append("';");
            builder.append("</script>");
            out.print(builder.toString());
            //判断数据库中是否有同名用户数据，如果有，则返回信息
                return false;
            }
            if(userService.selectbyemail(email)!=null&&email.equals(userService.selectbyemail(email).getUemail())){
                request.setCharacterEncoding("UTF-8");
                response.setCharacterEncoding("UTF-8");
                response.setHeader("Content-type", "text/html;charset=UTF-8");
                PrintWriter out = response.getWriter();
                String loginPage = "/index";
                StringBuilder builder = new StringBuilder();
                builder.append("<script type=\"text/javascript\">");
                builder.append("alert('邮箱已被注册！');");
                builder.append("window.top.location.href='");
                builder.append(loginPage);
                builder.append("';");
                builder.append("</script>");
                out.print(builder.toString());
                //判断数据库中是否有已注册邮箱用户数据，如果有，则返回注册界面
                return false;
            }

            return true;
        }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

        }
    }
