package com.kulishd.filter;


import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.logging.Logger;

public class SessionLocaleFilter implements Filter {
    private static Logger logger = Logger.getLogger("SessionLocaleFilter");
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        if (req.getParameter("sessionLocale") != null) {
            logger.info("sessionLocale != null");
            req.getSession().setAttribute("lang", req.getParameter("sessionLocale"));
        }
        filterChain.doFilter(servletRequest, servletResponse);
    }
    @Override
    public void destroy() {
    }
}
