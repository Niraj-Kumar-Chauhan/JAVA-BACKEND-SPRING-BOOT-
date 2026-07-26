package in.nirajarmy.interceptors_day14.config;

import in.nirajarmy.interceptors_day14.interceptors.*;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {
    public LoggingInterceptor loggingInterceptor;
    public AuthenticationInterceptor authenticationInterceptor;
    public AuthorizedInterceptor authorizedInterceptor;
    public RequestInterceptor requestInterceptor;
    public ResponseBodyInterceptor responseBodyInterceptor;

    public WebConfig (
            LoggingInterceptor loggingInterceptor,
            AuthenticationInterceptor authenticationInterceptor,
            AuthorizedInterceptor authorizedInterceptor,
            RequestInterceptor requestInterceptor,
            ResponseBodyInterceptor responseBodyInterceptor
    ) {
        this.loggingInterceptor = loggingInterceptor;
        this.authenticationInterceptor = authenticationInterceptor;
        this.authorizedInterceptor = authorizedInterceptor;
        this.requestInterceptor = requestInterceptor;
        this.responseBodyInterceptor = responseBodyInterceptor;
    }

    @Override
    public void addInterceptors (InterceptorRegistry registry) {
        registry.addInterceptor(authenticationInterceptor)
                .addPathPatterns("/api/**")
                .excludePathPatterns("/api/auth/login", "/api/public/**")
                .order(1);

        registry.addInterceptor(loggingInterceptor).order(3);

        registry.addInterceptor(authorizedInterceptor).order(2);

        registry.addInterceptor(requestInterceptor).order(4);

        registry.addInterceptor(responseBodyInterceptor).order(5);
    }
}
