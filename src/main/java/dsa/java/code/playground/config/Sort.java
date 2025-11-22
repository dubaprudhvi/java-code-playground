package dsa.java.code.playground.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import lombok.Data;

@ConfigurationProperties(prefix = "sort")
@Component
@Data
public class Sort {
    private boolean config;
}