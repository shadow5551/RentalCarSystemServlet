package by.training.nc.dev3.filter;



import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.servlet.jsp.jstl.core.Config;
import java.io.IOException;

import static javax.servlet.jsp.jstl.core.Config.FMT_LOCALE;


@WebFilter("/*")
public class MainFilter implements Filter {

    private HttpSession session;


    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        System.out.println("Filter");
        session = request.getSession();
        Config.set( session, FMT_LOCALE, new java.util.Locale("es_ES"));
        filterChain.doFilter(servletRequest,servletResponse);
    }

    @Override
    public void destroy() {

    }


}
