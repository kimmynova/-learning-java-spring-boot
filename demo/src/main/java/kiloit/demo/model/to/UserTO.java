package kiloit.demo.model.to;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NonNull;

@Data
public class UserTO {
    @NotNull
    @Min(1)
    private Long id;
    @NotBlank
    private String name;
}
