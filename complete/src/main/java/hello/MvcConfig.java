package hello;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MvcConfig implements WebMvcConfigurer {

    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/home").setViewName("home");
        registry.addViewController("/").setViewName("home");
        registry.addViewController("/hello").setViewName("hello");
        registry.addViewController("/login").setViewName("login");

        /*
        * The addViewControllers() method (overriding the method of the same name in WebMvcConfigurer)
        * adds four view controllers. Two of the view controllers reference the view
        * whose name is "home" (defined in home.html), and another references the view named "hello"
        * (defined in hello.html). The fourth view controller references another view named "login".
        * You’ll create that view in the next section.
        * */

        /*If Spring Security is on the classpath, then Spring Boot automatically secures all HTTP endpoints with
        * https://docs.spring.io/spring-boot/docs/2.0.3.RELEASE/reference/htmlsingle/#boot-features-security
        * "basic" authentication. But you can further customize the security settings.
        * The first thing you need to do is add Spring Security to the classpath.
        * /
    }

}
