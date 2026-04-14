package com.voidis.sea_orange_pre.interceptor;

import com.auth0.jwt.interfaces.DecodedJWT;
import com.voidis.sea_orange_pre.exception.CustomException;
import com.voidis.sea_orange_pre.utils.JwtUtils;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.NonNull;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

@Component
public class JwtInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, @NonNull HttpServletResponse response, @NonNull Object handler) {
        if ("OPTIONS".equals(request.getMethod())) {
            return true;
        }
        String token = request.getHeader("Authorization");
        if (token == null || token.trim().isEmpty()) {
            throw new CustomException(401,"用户未登录");
        }
        try {
            if (token.startsWith("Bearer ")) {
                token = token.substring(7);
            }
            DecodedJWT decodedJWT = JwtUtils.verifyToken(token);
            Long userId = decodedJWT.getClaim("id").asLong();
            request.setAttribute("userId",userId);
            return true;
        } catch (Exception e) {
            throw new CustomException(401,"登录失效或过期，请重新登录");
        }
    }
}
