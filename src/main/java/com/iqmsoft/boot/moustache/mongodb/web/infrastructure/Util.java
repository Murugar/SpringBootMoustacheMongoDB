package com.iqmsoft.boot.moustache.mongodb.web.infrastructure;

import javax.servlet.ServletContext;
import java.util.Optional;

public class Util {

    public static String ctx(final ServletContext servletContext) {

        return Optional.ofNullable(servletContext)
                .map(ServletContext::getContextPath)
                .orElse("");
    }

    private Util() {}
}
