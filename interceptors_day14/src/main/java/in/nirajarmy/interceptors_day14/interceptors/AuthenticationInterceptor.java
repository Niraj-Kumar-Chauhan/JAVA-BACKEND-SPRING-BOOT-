package in.nirajarmy.interceptors_day14.interceptors;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.jspecify.annotations.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

@Component
public class AuthenticationInterceptor implements HandlerInterceptor {
//    public long startTime = 0;
    @Override
    public boolean preHandle (
            HttpServletRequest request,
            HttpServletResponse response
            , Object handler
    ) {

//        startTime = System.currentTimeMillis();
        System.out.println("preHandle called in AuthenticationInterceptor");
        String apikey = request.getHeader("x-api-key");

        if (apikey == null && !apikey.equals("secret123")) {
            return false;
        }

        return true;
    }

    @Override
    public void afterCompletion (
            HttpServletRequest request,
            HttpServletResponse response,
            Object handler,
            Exception ex
    ) {
//        long responseTime = System.currentTimeMillis() - startTime;
//
//        System.out.println("Response Time: " + responseTime);

        System.out.println("AfterCompletion called in AuthenticationInterceptor");
    }

}
