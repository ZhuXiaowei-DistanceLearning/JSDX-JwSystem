package com.zxw.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import com.zxw.auth.utils.JwtUtils;
import com.zxw.config.FilterProperties;
import com.zxw.config.JwtProperties;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Component;
import utils.CookieUtils;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;

@Component
@EnableConfigurationProperties({JwtProperties.class, FilterProperties.class})
public class LoginFilter extends ZuulFilter {

    @Autowired
    private JwtProperties jwtProperties;

    @Autowired
    private FilterProperties filterProperties;
    private Logger logger = LoggerFactory.getLogger(ZuulFilter.class);

    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 2;
    }

    @Override
    public boolean shouldFilter() {
        //返回false不拦截
        //获取request
        RequestContext currentContext = RequestContext.getCurrentContext();

        HttpServletRequest request = currentContext.getRequest();

        String uri = request.getRequestURI();

        List<String> allowPaths = filterProperties.getAllowPaths();
        //判断是否拦截
        boolean isFilter = true;

        //如果请求的uri在允许的列表之内，循环停止，并且不拦截
        for (String allowPath : allowPaths) {//  /api/auth
            if (uri.startsWith(allowPath)) {
                isFilter = false;
                break;
            }
        }
        return isFilter;
    }

    @Override
    public Object run() throws ZuulException {
        //获取request
        RequestContext currentContext = RequestContext.getCurrentContext();

        HttpServletRequest request = currentContext.getRequest();

        //request.getRequestURI();
        String token = CookieUtils.getCookieValue(request, jwtProperties.getCookieName());

        String upgrad = request.getHeader("Upgrad");
        if (null != upgrad && "websocket".equalsIgnoreCase(upgrad)) {
            currentContext.addZuulRequestHeader("connection", "Upgrade");
        }
        try {
            //不为空再去解析token
            if (StringUtils.isNotBlank(token)) {
                //解析token 通过后什么都不做
                JwtUtils.getInfoFromToken(token, jwtProperties.getPublicKey());
            } else {
                //为空没有值，需要拦截
                currentContext.setSendZuulResponse(false);
                currentContext.setResponseStatusCode(403);
                currentContext.setResponseBody("身份已过期，请重新登录");
                currentContext.getResponse().sendRedirect("/login");
            }

        } catch (Exception e) {
            e.printStackTrace();
            //验证失败要做拦截
            currentContext.setSendZuulResponse(false);
            currentContext.setResponseStatusCode(403);
            currentContext.setResponseBody("身份已过期，请重新登录");
            try {
                currentContext.getResponse().sendRedirect("/login");
            } catch (IOException ex) {
                ex.printStackTrace();
                currentContext.setResponseBody("页面跳转失败");
            }
        }
        return null;
    }
}
