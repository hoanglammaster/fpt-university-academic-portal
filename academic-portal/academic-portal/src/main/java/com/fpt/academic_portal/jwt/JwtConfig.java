package com.fpt.academic_portal.jwt;

import org.springframework.context.annotation.Configuration;

@Configuration
public class JwtConfig {

    private String secretKey;
    private String tokenPrefix;
    private String tokenExpiredAfterMinutes;
}
