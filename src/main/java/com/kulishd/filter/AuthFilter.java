package com.kulishd.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.logging.Logger;

public class AuthFilter implements Filter {
    private static Logger logger = Logger.getLogger("AuthFilter");
    @Override
    public void init(FilterConfig filterConfig)  {

    }
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1.
        response.setHeader("Pragma", "no-cache"); // HTTP 1.0.
        response.setDateHeader("Expires", 0);
        String path = request.getRequestURI();
        HttpSession session = request.getSession(false);
        if (path.contains("admin")) {
            Object role = session.getAttribute("role");
            if (role == null) {
                response.sendRedirect("/login.jsp");
                logger.info("returning method doFilter cause role==null");
                return;
            }
            if ("ADMIN".equals(session.getAttribute("role").toString())) {
                logger.info("filterChain.dofilter role==ADMIN");
                filterChain.doFilter(servletRequest, servletResponse);
            } else {
                logger.info("redirect role!=ADMIN");
                response.sendRedirect("/login.jsp");
                //  return;
            }
        } else filterChain.doFilter(servletRequest, servletResponse);
    }
}

