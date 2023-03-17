package academy.excepetions;

import lombok.Getter;
import lombok.experimental.SuperBuilder;

@Getter
@SuperBuilder
public class validationExcepetionDetails extends ExceptionDetails{
    private final String fields;
    private final String fieldsmessage;
}
