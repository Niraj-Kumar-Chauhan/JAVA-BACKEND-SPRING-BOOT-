package in.nirajarmy.filterSession2_day13.configuration;

import in.nirajarmy.filterSession2_day13.filters.DummyFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FilterConfig {

    @Bean
    public FilterRegistrationBean<DummyFilter> getDummyFilterBean () {
        FilterRegistrationBean<DummyFilter> registrationBean =
                new FilterRegistrationBean<>();

        registrationBean.setFilter(new DummyFilter());

//        registrationBean.setOrder(1);
        registrationBean.addUrlPatterns("/api/*");

        return registrationBean;
    }
}
