package com.example.javaproject.filters;

import com.example.javaproject.connection.ConnectionUtils;
import com.example.javaproject.utils.MyUtils;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.sql.Connection;
import java.util.Collection;
import java.util.Map;

@WebFilter(filterName = "JDBCFilter", urlPatterns = {"/*"})
public class JDBCFilter implements Filter {
    public void init(FilterConfig config) throws ServletException {
    }

    public void destroy() {
    }

    private boolean needJDBC(HttpServletRequest request) {
        System.out.println("JDBC Filter");
        String servletPath = request.getServletPath();
        String pathInfo = request.getPathInfo();

        String urlPattern = servletPath;

        if (pathInfo != null) {
            urlPattern = servletPath + "/*";
        }

        Map<String, ? extends ServletRegistration> servletRegistrations;
        servletRegistrations = request.getServletContext()
                .getServletRegistrations();

        Collection<? extends ServletRegistration> values = servletRegistrations.values();
        for (ServletRegistration sr : values) {
            Collection<String> mappings = sr.getMappings();
            if (mappings.contains(urlPattern)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest) request;

        if (this.needJDBC(req)) {

            System.out.println("Open Connection for: " + req.getServletPath());

            Connection conn = null;
            try {
                conn = ConnectionUtils.getConnection();
                conn.setAutoCommit(false);

                MyUtils.storeConnection(request, conn);

                chain.doFilter(request, response);

                conn.commit();
            } catch (Exception e) {
                e.printStackTrace();
                ConnectionUtils.rollbackQuietly(conn);
                throw new ServletException();
            } finally {
                ConnectionUtils.closeQuietly(conn);
            }
        }
        else {
            chain.doFilter(request, response);
        }

    }



}

