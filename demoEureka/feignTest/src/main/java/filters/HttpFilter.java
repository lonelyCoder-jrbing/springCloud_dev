package filters;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Configuration
public class HttpFilter {
    private static final Logger log = LoggerFactory.getLogger(FilterConfig.class);

    @Bean
    @Order(Integer.MIN_VALUE)
    @Qualifier("filterRegistration")
    public FilterRegistrationBean filterRegistration() {
        FilterRegistrationBean<Filter> registration = new FilterRegistrationBean<>();
        registration.setFilter(controllerFilter());
        registration.addUrlPatterns("/*");
        return registration;
    }

    private Filter controllerFilter() {
        return new Filter() {
            @Override
            public void init(FilterConfig filterConfig) {
                log.info("ControllerFilter init Success");
            }

            @Override
            public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain) throws IOException, ServletException {
                HttpServletRequest request = (HttpServletRequest) servletRequest;
                HttpServletResponse response = (HttpServletResponse) servletResponse;
                String requestId = request.getHeader("Request-Id");
                if (requestId == null) requestId = request.getRequestedSessionId();
                System.out.println();
                log.info("Http Request APP-Request-Id : " + requestId);
                log.info("Http Request APP-Information : {\"URI\":\"" + request.getRequestURL() +
                        "\",\"RequestMethod\":\"" + request.getMethod() +
                        "\",\"ClientIp\":\"" + HttpCommon.getIpAddress(request) +
                        "\",\"Content-Type\":\"" + request.getContentType() +
                        "\"}");
                chain.doFilter(request, response);
            }

            @Override
            public void destroy() {
                log.info("ControllerFilter destroy");
            }
        };
    }
}
