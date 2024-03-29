package com.iqmsoft.boot.moustache.mongodb.web.infrastructure.fallback;

import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.web.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.iqmsoft.boot.moustache.mongodb.web.infrastructure.Util;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Optional;

import static org.springframework.http.HttpStatus.NOT_FOUND;

@Slf4j
@Controller
@RequiredArgsConstructor
public class FallbackHandler implements ErrorController {

    static final String ENDPOINT = "/error";

    ServletContext servletContext;

    @SneakyThrows
    @GetMapping(ENDPOINT)
    void handle404(final HttpServletRequest request, 
    		final HttpServletResponse response, final Exception e) throws IOException {

        if (NOT_FOUND.value() != response.getStatus()) {
            return;
        }

        Optional.ofNullable(e).ifPresent(ex -> {

            if (Optional.ofNullable(e.getMessage()).isPresent()) {

               // log.error("{} fallback: {} {}", e.getClass().getSimpleName(), e.getMessage());

            } else {

                //log.error("{} fallback", e.getClass().getSimpleName());
            }
        });

        //if (log.isDebugEnabled()) {
            //log.debug(e.getMessage(), e);
        //}

        response.sendRedirect(Util.ctx(servletContext));
    }

    @Override
    public String getErrorPath() {
        return ENDPOINT;
    }
}
