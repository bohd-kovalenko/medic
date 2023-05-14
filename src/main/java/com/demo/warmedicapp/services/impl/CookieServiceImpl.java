package com.demo.warmedicapp.services.impl;

import com.demo.warmedicapp.services.CookieService;
import jakarta.servlet.http.Cookie;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CookieServiceImpl implements CookieService {
    @Value("${token-cookie-name}")
    private String tokenCookieName;
    @Value("${maximum-age-of-token-cookie-seconds}")
    private String maximumAgeOfTokenCookie;

    @Override
    public Cookie generateCookieForToken(String token) {
        Cookie cookie = new Cookie(tokenCookieName, token);
        cookie.setHttpOnly(true);
//        cookie.setSecure(true);
        cookie.setMaxAge(Integer.parseInt(maximumAgeOfTokenCookie));
        return cookie;
    }
}
