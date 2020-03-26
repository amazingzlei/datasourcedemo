package demo.common.exception;

/**
 * 业务异常都在这里，从1001开始,这个用法是为了优化往BaseException中传值，即自定义
 * 异常存在的可能性
 */
public enum BaseEnum {
    ERROR_1001(1001,"传入的id为空"),
    ERROR_1002(1002,"参数格式不正确");

    private Integer code;
    private String msg;

    BaseEnum(Integer code, String msg){
        this.code=code;
        this.msg=msg;
    }

    public Integer getCode(){
        return code;
    }

    public String getMsg(){
        return msg;
    }
}
