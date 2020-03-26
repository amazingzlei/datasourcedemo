package demo.common.exception;

/**
 * 系统常见异常在这里，从405开始
 */
public enum RuntimeExceptionEnum {
    ERROR_405("java.lang.ArithmeticException","算数异常"),
    ERROR_406("java.lang.NullPointerException","空指针异常");

    private String exception;
    private String msg;

    RuntimeExceptionEnum(String exception, String msg){
        this.exception=exception;
        this.msg=msg;
    }

    public String getException(){
        return exception;
    }

    public String getMsg(){
        return msg;
    }
}
