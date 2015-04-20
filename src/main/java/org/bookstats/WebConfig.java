package org.bookstats;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Created with IntelliJ IDEA.
 * User: Serger
 * Date: 18.11.2014
 * Time: 10:46
 */
@EnableWebMvc
@Configuration
public class WebConfig extends WebMvcConfigurerAdapter {

//    public ResourceBundleMessageSource messageSource() {
//
//        ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
//
//        String[] strBaseNames = {
//                "/resources/templates/main"
////                "/WEB-INF/messages/global/GlobalResources",
////                "/WEB-INF/messages/user/UserResources",
//        };
//
//        messageSource.setUseCodeAsDefaultMessage(true);
//        messageSource.setDefaultEncoding("UTF-8");
//
//        // # -1 : never reload, 0 always reload
//        messageSource.setCacheSeconds(0);
//        messageSource.setBasenames(strBaseNames);
//
//        return messageSource;
//    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/resources/**")
                .addResourceLocations("/", "classpath:/static/");
    }
}
