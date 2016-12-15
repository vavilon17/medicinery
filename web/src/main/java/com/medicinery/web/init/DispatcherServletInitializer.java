package com.medicinery.web.init;

import com.medicinery.core.conf.RootConfig;
import com.medicinery.web.conf.WebConfig;
import com.medicinery.web.filter.CharsetFilter;
import com.medicinery.web.filter.SegmentFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import javax.servlet.Filter;

public class DispatcherServletInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }

    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class<?>[]{RootConfig.class};
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class<?>[]{WebConfig.class};
    }

    @Override
    protected Filter[] getServletFilters() {
        return new Filter[] {new CharsetFilter(), new SegmentFilter()};
    }


}

