package in.nirajarmy.interceptors_day14.interceptors;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.jspecify.annotations.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import java.io.BufferedReader;
import java.io.IOException;

@Component
public class RequestInterceptor implements HandlerInterceptor {
    public boolean preHandle(
            HttpServletRequest request,
            HttpServletResponse response,
            Object handler) throws IOException {

        System.out.println("preHandle called in RequestInterceptor");

        BufferedReader reader = request.getReader();

        StringBuilder body = new StringBuilder();

        String line = reader.readLine();

        while (line != null) {
            body.append(line);

            line = reader.readLine();
        }
        System.out.println(body);
        return true;
    }

    public void afterCompletion(
            HttpServletRequest request,
            HttpServletResponse response,
            Object handler,
            Exception ex) throws Exception {

        System.out.println("afterCompletion called in RequestInterceptor");
    }
}
