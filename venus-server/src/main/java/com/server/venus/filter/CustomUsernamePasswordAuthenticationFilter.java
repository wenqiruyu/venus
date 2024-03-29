package com.server.venus.filter;

import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.server.venus.utils.Constants;
import com.server.venus.utils.TokenUtils;
import com.server.venus.vo.LoginUserVO;
import com.server.venus.vo.ResultVO;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

/**
 * 项目名称：permission-demo
 * 类名称：CustomUsernamePasswordAuthenticationFilter
 * 类描述：TODO
 * 创建人：yingx
 * 创建时间： 2019/10/10
 * 修改人：yingx
 * 修改时间： 2019/10/10
 * 修改备注：
 */
public class CustomUsernamePasswordAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

    private AuthenticationManager authenticationManager;

    public CustomUsernamePasswordAuthenticationFilter(AuthenticationManager authenticationManager) {

        super.setFilterProcessesUrl("/user/login");
        this.authenticationManager = authenticationManager;
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {

        try {
            LoginUserVO loginUser = new ObjectMapper().readValue(request.getInputStream(), LoginUserVO.class);
            System.out.println(loginUser.toString());
            return authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(loginUser.getUsername(), loginUser.getPassword(),new ArrayList<>())
            );

        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authResult) throws IOException, ServletException {

        UserDetails userDetail = (UserDetails)authResult.getPrincipal();
        String token = TokenUtils.getToken(userDetail.getUsername(), false);
        response.setHeader("token", Constants.TOKEN_PREFIX + token);
        response.getWriter().write(JSON.toJSONString(ResultVO.success(Constants.TOKEN_PREFIX + token)));
    }

    @Override
    protected void unsuccessfulAuthentication(HttpServletRequest request, HttpServletResponse response, AuthenticationException failed) throws IOException, ServletException {

        response.getWriter().write("authentication failed, reason: " + failed.getMessage());
    }
}
