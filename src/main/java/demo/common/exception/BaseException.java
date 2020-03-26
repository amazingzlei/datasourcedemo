package demo.common.exception;

/**
 * 自定义业务异常，基类
 */
public class BaseException extends RuntimeException{
    private Integer code;

    public BaseException() {
        super();
    }

    public BaseException(Integer code, String message) {
        super(message);
        this.code = code;
    }

    public BaseException(BaseEnum baseEnum) {
        this(baseEnum.getCode(), baseEnum.getMsg());
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

}
