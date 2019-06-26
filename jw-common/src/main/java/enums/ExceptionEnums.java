package enums;

public enum ExceptionEnums {
    ID_OR_PASSWORD_NOT_FOUND(404, "用户名或密码错误!"),
    NOT_FOUND_AUTH_FUNCTION(400, "用户权限审核失败，进行入侵清除!"),
    COLLEGE_ALREADY_EXIST(400, "学院已经存在！"),
    INVAILD_FILE_TYPE(400, "文件类型错误!"),
    FILE_UPLOAD_FAIL(400, "文件上传失败!"),
    FILE_IS_ESIXT(400, "文件已存在，不允许重复上传"),
    FILE_VIEW_FAIL(500, "文件浏览失败！");;

    private Integer code;
    private String message;
    private Object object;

    ExceptionEnums(Integer code, String message, Object object) {
        this.code = code;
        this.message = message;
        this.object = object;
    }

    ExceptionEnums(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    ExceptionEnums() {
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getObject() {
        return object;
    }

    public void setObject(Object object) {
        this.object = object;
    }
}
