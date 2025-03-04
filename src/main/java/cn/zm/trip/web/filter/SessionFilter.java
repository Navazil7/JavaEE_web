package cn.zm.trip.web.filter;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.filter.OncePerRequestFilter;

/**
 * 登录过滤
 *
 * @author wjk
 * @date
 */
public class SessionFilter extends OncePerRequestFilter {

    /*
     * (non-Javadoc)
     *
     * @see
     * org.springframework.web.filter.OncePerRequestFilter#doFilterInternal(
     * javax.servlet.http.HttpServletRequest,
     * javax.servlet.http.HttpServletResponse, javax.servlet.FilterChain)
     */
    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {

        // 不过滤的uri
        String[] notFilter = new String[] { "/index","captcha",
                "error/product_off",
                "/admin/login","/static",
                "/view/point","/hotel/content",
                "/user/login","/user/regst"
                ,"/about/index"
                ,"/user/regstform",
                "/traffic/selectByCurrentAndDestination",
                "/cust/viewPoint","/cust/hotel",
                "/traffic/selectTrafficByid",
                "proscenium/order/attractionContent",
                "proscenium/order/hotelContent"};

        // 请求的uri
        String uri = request.getRequestURI();
        System.out.println(uri);
        // uri中包含background时才进行过滤

            // 是否过滤
            boolean doFilter = true;
            for (String s : notFilter) {
                if (uri.indexOf(s)!=-1) {
                    // 如果uri中包含不过滤的uri，则不进行过滤
                    doFilter = false;
                    break;
                }
            }
             if(uri.equals("/"))doFilter=false;//处理首页‘/’访问情况
            if(uri.indexOf("favicon.ico")==-1)
            if(uri.indexOf("admin")!=-1&&!uri.equals("/admin/login")&&uri.indexOf("static")==-1){
                //执行管理员过滤
                Object obj = request.getSession().getAttribute("admin");
                if (null == obj) {
                    // 如果session中不存在登录者实体，则弹出框提示重新登录
                    // 设置request和response的字符集，防止乱码
                    request.setCharacterEncoding("UTF-8");
                    response.setCharacterEncoding("UTF-8");
                    response.setHeader("Content-type", "text/html;charset=UTF-8");
                    PrintWriter out = response.getWriter();
                    String loginPage = "/admin/login";
                    StringBuilder builder = new StringBuilder();
                    builder.append("<script type=\"text/javascript\">");
                    builder.append("alert('网页过期或未登录，请重新登录！');");
                    builder.append("window.top.location.href='");
                    builder.append(loginPage);
                    builder.append("';");
                    builder.append("</script>");
                    out.print(builder.toString());
                } else {
                    // 如果session中存在登录者实体，则继续
                    filterChain.doFilter(request, response);
                }
            }
            else if (doFilter) {
                // 执行yhu过滤
                // 从session中获取登录者实体
                Object obj = request.getSession().getAttribute("user");
                if (null == obj) {
                    // 如果session中不存在登录者实体，则弹出框提示重新登录
                    // 设置request和response的字符集，防止乱码
                    request.setCharacterEncoding("UTF-8");
                    response.setCharacterEncoding("UTF-8");
                    response.setHeader("Content-type", "text/html;charset=UTF-8");
                    PrintWriter out = response.getWriter();
                    String loginPage = "/index";
                    StringBuilder builder = new StringBuilder();
                    builder.append("<script type=\"text/javascript\">");
                    builder.append("alert('网页过期或未登录，请重新登录！');");
                    builder.append("window.top.location.href='");
                    builder.append(loginPage);
                    builder.append("';");
                    builder.append("</script>");
                    out.print(builder.toString());
                } else {
                    // 如果session中存在登录者实体，则继续
                    filterChain.doFilter(request, response);
                }
            } else {
                // 如果不执行过滤，则继续
                filterChain.doFilter(request, response);
            }
        }
    }


