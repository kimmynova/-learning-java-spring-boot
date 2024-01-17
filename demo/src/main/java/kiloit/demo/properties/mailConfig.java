package kiloit.demo.properties;


import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
//in prefix (spring) that from files mail file
@ConfigurationProperties(prefix = "spring.mail")
@Data //for library use in Lombok that show object
public class mailConfig {
    private  String username;
    private String password ;
    private List<String> multi_Config;

    // standard getter and setter

}
