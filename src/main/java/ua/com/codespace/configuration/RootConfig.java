package ua.com.codespace.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * Created by kernel32 on 05.05.2017.
 */
@Configuration
@ComponentScan(basePackages = {"ua.com.codespace"},
        excludeFilters = {
                @ComponentScan.Filter(type = FilterType.ANNOTATION, value = EnableWebMvc.class)
        })
@PropertySource("classpath:/application.properties")
public class RootConfig {

}
