package com.demo.warmedicapp.services;

import jakarta.servlet.http.Cookie;

public interface CookieService {
    Cookie generateCookieForToken(String token);
}
