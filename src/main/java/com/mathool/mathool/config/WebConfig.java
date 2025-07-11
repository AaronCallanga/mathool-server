package com.mathool.mathool.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * WebConfig is a configuration class that sets up global CORS (Cross-Origin Resource Sharing)
 * settings for the entire application.
 *
 * This allows the front-end applications (development and production) to access the backend API.
 */
@Configuration
public class WebConfig implements WebMvcConfigurer {

    /**
     * Configures CORS mappings to allow frontend apps to interact with the backend API.
     *
     * Allowed Origins:
     * - http://localhost:5173 → for local development (Vite-based frontend)
     * - https://mathool.netlify.app/ → for deployed frontend
     * Allowed Methods and Headers:
     * - Allows all HTTP methods
     * - Allows all headers
     * - Allows credentials (cookies, authorization headers, etc.)
     */
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("http://localhost:5173", "https://mathool.netlify.app/")
                .allowedMethods("*")
                .allowedHeaders("*")
                .allowCredentials(true);
    }
}
