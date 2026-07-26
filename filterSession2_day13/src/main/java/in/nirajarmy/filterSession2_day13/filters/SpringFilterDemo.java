package in.nirajarmy.filterSession2_day13.filters;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

public class SpringFilterDemo extends OncePerRequestFilter {

    @Override
    protected boolean shouldNotFilter (HttpServletRequest request) {
        String uri = request.getRequestURI();

        return !uri.startsWith("/api/");
    }
    @Override
    protected void doFilterInternal(
            HttpServletRequest request,
            HttpServletResponse response,
            FilterChain filterChain
    ) throws ServletException, IOException {

        filterChain.doFilter(request, response);

    }
}
