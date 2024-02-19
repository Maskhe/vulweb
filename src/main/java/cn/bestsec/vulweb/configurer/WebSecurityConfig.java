//package cn.bestsec.vulweb.configurer;
//
//import org.springframework.context.annotation.Configuration;
//import org.springframework.http.HttpMethod;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.web.cors.CorsConfiguration;
//import org.springframework.web.cors.CorsConfigurationSource;
//import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
//
//import java.util.Arrays;
//import java.util.Collections;
//
//@Configuration
//public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
//
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http.authorizeRequests()
//                .anyRequest().authenticated()
//                .and()
//                .csrf().disable()
//                .antMatcher("*")
//                .cors().configurationSource(corsConfiguration()).and()
//                .formLogin().disable(); // 配置 CorsFilter 配置信息
//    }
//
//    /**
//     * Cors 的配置信息 配置+路径
//     */
//    CorsConfigurationSource corsConfiguration (){
//        // Cors配置类
//        CorsConfiguration corsConfiguration = new CorsConfiguration();
//        corsConfiguration.setAllowCredentials(false); // 是否返回时生成凭证
//        corsConfiguration.setAllowedHeaders(Arrays.asList("*")); // 允许请求携带哪些请求头信息
//        corsConfiguration.setAllowedMethods(Arrays.asList("*")); // 允许哪些类型的请求方法
//        corsConfiguration.setAllowedOrigins(Arrays.asList("*")); // 允许哪些域可以进行方法
//        corsConfiguration.setMaxAge(3600L); // 设置预检的最大的时长
////        corsConfiguration.setExposedHeaders(Collections.emptyList()); // 设置返回暴露的响应头信息
//
//        // 设置注册URL 配置类
//        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource() ;
//        source.registerCorsConfiguration("/**",corsConfiguration);
//
//        return source;
//    }
//}
