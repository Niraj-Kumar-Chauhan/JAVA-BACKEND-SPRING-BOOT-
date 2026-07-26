package in.nirajarmy.interceptors_day14.interceptors;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.util.ContentCachingResponseWrapper;

import java.io.BufferedReader;
import java.io.IOException;

@Component
public class ResponseBodyInterceptor implements HandlerInterceptor  {

    public boolean preHandle(
            HttpServletRequest request,
            HttpServletResponse response,
            Object handler) throws IOException {

        System.out.println("preHandle called in ResponseBodyInterceptor");

        return true;
    }

    public void afterCompletion (HttpServletRequest request,
                                 HttpServletResponse response,
                                 Object handler,
                                 Exception ex
    ) throws Exception {

        System.out.println("afterCompletion called in ResponseBodyInterceptor");

//        ContentCachingResponseWrapper wrappedResponse =
//                new ContentCachingResponseWrapper(response);
//
//        byte[] originalBodyBytes = wrappedResponse.getContentAsByteArray();
//
//        String originalBody = new String(originalBodyBytes);
//
//        String modifiedBody =
//                """
//                 {
//                    "originalBody": %s,
//                    "appName": "student management application"
//                 }
//                """.formatted(originalBody);
//
//        wrappedResponse.reset();
//
//        wrappedResponse.getWriter().write(modifiedBody);
//
//        wrappedResponse.copyBodyToResponse();
    }

}
