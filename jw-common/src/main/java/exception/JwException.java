package exception;

import enums.ExceptionEnums;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class JwException extends RuntimeException {
    private ExceptionEnums exceptionEnums;
}
