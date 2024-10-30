    package com.comso.backend_spring.config;

    import java.io.IOException;

    import org.springframework.context.annotation.Bean;
    import org.springframework.context.annotation.Configuration;
    import org.springframework.http.HttpMethod;
    import org.springframework.security.config.annotation.web.builders.HttpSecurity;
    import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
    import org.springframework.security.config.annotation.web.configurers.CsrfConfigurer;
    import org.springframework.security.config.annotation.web.configurers.HttpBasicConfigurer;
    import org.springframework.security.config.http.SessionCreationPolicy;
    import org.springframework.security.core.AuthenticationException;
    import org.springframework.security.web.AuthenticationEntryPoint;
    import org.springframework.security.web.SecurityFilterChain;
    import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
    import org.springframework.web.cors.CorsConfiguration;
    import org.springframework.web.cors.CorsConfigurationSource;
    import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

    import com.comso.backend_spring.filter.JwtAuthenticationFilter;

    import jakarta.servlet.ServletException;
    import jakarta.servlet.http.HttpServletRequest;
    import jakarta.servlet.http.HttpServletResponse;
    import lombok.RequiredArgsConstructor;

    @Configuration
    @EnableWebSecurity
    @RequiredArgsConstructor
    public class WebSecurityConfig {
        
        private final JwtAuthenticationFilter jwtAuthenticationFilter;

        
        @Bean
        protected SecurityFilterChain configure(HttpSecurity httpSecurity) throws Exception{
            httpSecurity
                .cors(cors -> cors
                    .configurationSource(corsConfigrationSource())
                )
                .csrf(CsrfConfigurer::disable)
                .httpBasic(HttpBasicConfigurer::disable)
                .sessionManagement(sessionManagement -> sessionManagement
                    .sessionCreationPolicy(SessionCreationPolicy.STATELESS)     
                )
                .authorizeHttpRequests(request -> request
                    .requestMatchers("/", "/api/v1/auth/**", "/api/v1/search/**", "/file/**", "/api/v1/**", "/ws/**", "api/v1/post/**", "api/v1/corporation/**").permitAll()
                    .requestMatchers(HttpMethod.GET, "/api/v1/board/**", "/api/v1/user/*", "/api/v1/category/**", "/api/v1/corporation/**", "/api/v1/notice/**", "api/v1/study-group/**", "/ws/**" , "/api/v1/post/**", "/api/v1/resume/**").permitAll()
                    .requestMatchers(HttpMethod.POST, "/api/v1/board/latest-list", "/api/v1/board/popularity-list", "/api/v1/board/mostviewed-list", "/api/v1/corporation/**", "/api/v1/resume/**").permitAll()
                    .anyRequest().authenticated()
                )
                .exceptionHandling(exceptionHandling -> exceptionHandling
                    .authenticationEntryPoint(new FailedAuthenticationEntryPoint())
                )
                .addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);


                /* .cors().and()
                .csrf().disable()
                .httpBasic().disable()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
                .authorizeRequests()
                .antMatchers("/", "/api/v1/auth/**", "/file/**").permitAll()
                .antMatchers(HttpMethod.GET, "/api/v1/board/**", "/api/v1/user/*").permitAll()
                .anyRequest().authenticated().and()
                .exceptionHandling().AuthenticationEntryPoint(new FailedAuthenticationEntryPoint()); */

                

                return httpSecurity.build();
        }

        @Bean
        protected CorsConfigurationSource corsConfigrationSource(){

            CorsConfiguration configuration = new CorsConfiguration();
            configuration.addAllowedOrigin("*");
            configuration.addAllowedMethod("*");
            configuration.addAllowedHeader("*");
            configuration.addExposedHeader("*");

            UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
            source.registerCorsConfiguration("/**", configuration);

            return source;
            

        }

    }

    class FailedAuthenticationEntryPoint implements AuthenticationEntryPoint{

        @Override
        public void commence(HttpServletRequest request, HttpServletResponse response,
                AuthenticationException authException) throws IOException, ServletException {
            
            response.setContentType("application/json");
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            response.getWriter().write("{ \"code:\":\"AP\", \"message\": \"Authorization Failed.\" }");

        }
        
        
    }
