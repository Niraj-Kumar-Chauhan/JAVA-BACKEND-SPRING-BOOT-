package in.nirajarmy.interceptors_day14.interceptors;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.jspecify.annotations.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import java.io.IOException;

@Component
public class AuthorizedInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle (
            HttpServletRequest request,
            HttpServletResponse response
            , Object handler
    ) throws IOException {
        System.out.println("preHandle called in AuthorizedInterceptor");
        String userRole = request.getHeader("x-user-role");

        if (userRole == null || !userRole.equals("ADMIN")) {
            response.setStatus(HttpServletResponse.SC_FORBIDDEN);
            response.setContentType("application/json");
            response.getWriter().write(
                    "{\n" +
                            "    \"message\": \"you are not authorized to perform this action\"\n" +
                            "}"
            );
            return false;
        }

        return true;
    }

    public void afterCompletion(
            HttpServletRequest request,
            HttpServletResponse response,
            Object handler,
            Exception ex) throws Exception {

        System.out.println("afterCompletion called in AuthorizedInterceptor");

    }
}