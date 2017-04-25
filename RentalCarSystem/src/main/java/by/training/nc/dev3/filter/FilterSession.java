package by.training.nc.dev3.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter({"/Admin", "/User"})
public class FilterSession implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponce= (HttpServletResponse) response;
        if (httpRequest.getSession().getAttribute("currentUserId") != null) {
            filterChain.doFilter(request, response);
        } else {
            httpResponce.sendRedirect("/Main");
        }
    }

    @Override
    public void destroy() {

    }
}
