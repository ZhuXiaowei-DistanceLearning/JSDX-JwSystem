package vo;

import enums.ExceptionEnums;

public class ExceptionResult {
    private Integer code;
    private String message;
    private Long timestamp;

    public ExceptionResult(ExceptionEnums exceptionEnums) {
        this.code = exceptionEnums.getCode();
        this.message = exceptionEnums.getMessage();
        this.timestamp = System.currentTimeMillis();
    }
}
