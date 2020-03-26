package demo.common.exception;

public class UserNotFountException extends BaseException{
    private Integer code;

    public UserNotFountException() {
        super();
    }

    public UserNotFountException(Integer code, String message) {
        super(code,message);
        this.code = code;
    }

    public UserNotFountException(BaseEnum baseEnum) {
        this(baseEnum.getCode(), baseEnum.getMsg());
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}
