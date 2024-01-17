package kiloit.demo.model.to;

import kiloit.demo.properties.mailConfig;
import lombok.Data;

import java.util.List;
@Data
public class ConfigTo {
    private String username;
    private String password;
    private List<String>multi_config;

    public ConfigTo(mailConfig mailConfig) {

        this.username = mailConfig.getUsername();
        this.password = mailConfig.getPassword();
        this.multi_config = mailConfig.getMulti_Config();

    }
}
