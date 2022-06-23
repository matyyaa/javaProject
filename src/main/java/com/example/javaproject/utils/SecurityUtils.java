package com.example.javaproject.utils;

import com.example.javaproject.config.SecurityConfig;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Set;

public class SecurityUtils {
    public static boolean isSecurityPage(HttpServletRequest request) {
        String urlPattern = UrlPatternUtils.getUrlPattern(request);

        Set<String> roles = SecurityConfig.getAllRoles();

        for (String role : roles) {
            List<String> urlPatterns = SecurityConfig.getUrlPatternsForRole(role);
            if (urlPatterns != null && urlPatterns.contains(urlPattern)) {
                return true;
            }
        }
        return false;
    }

    public static boolean hasPermission(HttpServletRequest request) {
        String urlPattern = UrlPatternUtils.getUrlPattern(request);

        Set<String> allRoles = SecurityConfig.getAllRoles();

        for (String role : allRoles) {
            if (!request.isUserInRole(role)) {
                continue;
            }
            List<String> urlPatterns = SecurityConfig.getUrlPatternsForRole(role);
            if (urlPatterns != null && urlPatterns.contains(urlPattern)) {
                return true;
            }
        }
        return false;
    }

}
