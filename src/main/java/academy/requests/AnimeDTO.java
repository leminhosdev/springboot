package academy.requests;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class AnimeDTO {
    @NotNull(message = "this anime cannot be null")
    @NotEmpty(message = "this anime cannot be empty")
    private String name;


}
