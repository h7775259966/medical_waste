package com.common.Interceptor;

import com.common.Utils.JwtUtils;
import com.common.Exception.ExceptionCast;
import com.common.Response.system.role.UserCode;
import io.jsonwebtoken.Claims;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 自定义拦截器
 *      继承HandlerInterceptorAdapter
 *      preHandle:进入到控制器方法(也就是调用controller里面的接口方法之前)之前执行的内容
 *          boolean：
 *              true：可以继续执行控制器方法
 *              false：拦截
 *      posthandler：执行控制器方法之后(也就是完成controller里面的接口调用，有返回数据时)执行的内容
 *      afterCompletion：响应结束之前执行的内容
 */
@Component
public class JwtInterceptor extends HandlerInterceptorAdapter {

    @Autowired
    private JwtUtils jwtUtils;

    /**
     * 1.获取token数据校验（是否登录）
     * 2.判断用户是否具有当前访问接口的权限
     * @param request
     * @param response
     * @param handler
     * @return
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        // 1.通过request获取请求token信息
        String authorization = request.getHeader("Authorization");
        //判断请求头信息是否为空，或者是否已Bearer开头
        if(!StringUtils.isEmpty(authorization) && authorization.startsWith("Bearer")) {
            //获取token数据
            String token = authorization.replace("Bearer ","");
            //解析token获取claims
            Claims claims = jwtUtils.parseJwt(token);
            if(claims != null) {
                //通过claims获取到当前用户的可访问API权限字符串
                String apis = (String) claims.get("apis");
                //通过handler
                //handler转换成HandlerMethod后，可以获得被请求接口内的注解的数据
                HandlerMethod h = (HandlerMethod) handler;
                //获取接口上的@reqeustmapping注解上的name属性
                RequestMapping annotation = h.getMethodAnnotation(RequestMapping.class);
                //获取当前请求接口中的name属性
                String name = annotation.name();
                //判断当前用户是否具有响应的请求权限
                if(apis.contains(name)) {
                    request.setAttribute("user_claims",claims);
                    return true;
                }else {
                    ExceptionCast.cast(UserCode.UNAUTHORISE);
                }
            }
        }
        ExceptionCast.cast(UserCode.UNAUTHENTICATED);
        return false;
    }
}
