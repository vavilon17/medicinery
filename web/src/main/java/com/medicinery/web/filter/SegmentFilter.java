package com.medicinery.web.filter;


import com.medicinery.core.util.Const;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public class SegmentFilter implements Filter {

    private static final Logger log = LoggerFactory.getLogger(SegmentFilter.class);

    private static final String GEOIP_HEADER = "GEOIP_COUNTRY_CODE";

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain)
            throws IOException, ServletException {
        HttpServletRequest req =  (HttpServletRequest) request;
        String segment = (String) req.getSession().getAttribute(Const.SEGM_SESSION_ATTR);
        if (!StringUtils.isEmpty(segment)) {
            log.info("setting up the segment '%s' into session", segment);
            req.getSession().setAttribute(Const.SEGM_SESSION_ATTR, req.getHeader(GEOIP_HEADER));
        }
        req.getSession().setAttribute(Const.SEGM_SESSION_ATTR, "RU"); //todo
        filterChain.doFilter(request, response);
    }

    @Override
    public void destroy() {

    }
}
