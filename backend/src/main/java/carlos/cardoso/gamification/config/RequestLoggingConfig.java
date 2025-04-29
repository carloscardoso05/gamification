package carlos.cardoso.gamification.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.CommonsRequestLoggingFilter;

@Configuration
public class RequestLoggingConfig {

    @Bean
    public CommonsRequestLoggingFilter logFilter() {
        CommonsRequestLoggingFilter filter = new CommonsRequestLoggingFilter();
        filter.setIncludeQueryString(true); // Log the query string
        filter.setIncludePayload(true);     // Log the request body (payload)
        filter.setMaxPayloadLength(10000); // Truncate payload if longer
        filter.setIncludeHeaders(true);    // Log request headers
        filter.setAfterMessagePrefix("REQUEST DATA: "); // Prefix for the log message after request processing
        filter.setIncludeClientInfo(true); // Log client IP and session ID
        return filter;
    }

}
