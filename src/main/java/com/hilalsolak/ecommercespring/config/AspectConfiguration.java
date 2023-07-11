package com.hilalsolak.ecommercespring.config;
import com.hilalsolak.ecommercespring.service.LoggerService;
import com.hilalsolak.ecommercespring.utils.LoggingAspect;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AspectConfiguration {
    private final LoggerService loggerService;

    public AspectConfiguration(LoggerService loggerService) {
        this.loggerService = loggerService;
    }

    @Bean
    // Spring Context'inde bir bean yapmamız gerekir, çünkü Spring'in yönetmesi gereken herhangi bir nesneden haberdar olması gerekir.
    public LoggingAspect aspect() {
        return new LoggingAspect(loggerService);
    }
}
