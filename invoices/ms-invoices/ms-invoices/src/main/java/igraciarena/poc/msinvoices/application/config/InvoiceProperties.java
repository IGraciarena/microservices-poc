package igraciarena.poc.msinvoices.application.config;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConstructorBinding;

@Getter
@AllArgsConstructor
@ConfigurationProperties(prefix = "invoice")
@ConstructorBinding
public class InvoiceProperties {

        private final Integer itemListMax;

}