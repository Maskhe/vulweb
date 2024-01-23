//package cn.bestsec.vulweb.configurer;
//
//import org.springframework.context.annotation.Configuration;
//import org.springframework.web.servlet.config.annotation.CorsRegistry;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
//
//@Configuration
//public class CorsConfig implements WebMvcConfigurer {
//
//    @Override
//    public void addCorsMappings(CorsRegistry registry) {
//        registry.addMapping("/**") //项目中的所有接口都支持跨域
//                .allowedOrigins("*")
////                .allowedOriginPatterns("www.baidu.com") // 允许的请求来源
////                .allowCredentials(true) // 允许携带认证信息
//                .allowedMethods("*")//"GET", "HEAD", "POST", "PUT", "DELETE", "OPTIONS"
//                .maxAge(3600);// 跨域允许时间;
//    }
//}
