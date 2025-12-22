package dsa.java.code.playground.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import lombok.Getter;
import lombok.Setter;

@ConfigurationProperties(prefix = "flags")
@Component
@Getter
@Setter
public class Flags {
    private boolean sort;
    private boolean collection;
    private boolean threads;
}