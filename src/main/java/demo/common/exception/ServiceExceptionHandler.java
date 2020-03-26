package demo.common.exception;

import demo.common.utils.ResultVOUtil;
import demo.common.vo.ResultVO;
import org.apache.log4j.Logger;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class ServiceExceptionHandler {

    private static final Integer ERROR_CODE = 500;

    private static final Logger log = Logger.getLogger(ServiceExceptionHandler.class);

    private static Map<String,String> exceptionMap = new HashMap<>();

    //枚举常见异常类
    static {
        for(RuntimeExceptionEnum resultEnum:RuntimeExceptionEnum.values()){
            exceptionMap.put(resultEnum.getException(),resultEnum.getMsg());
        }
    }

    @ExceptionHandler(Exception.class)
    public ResultVO handlerException(Exception e){
        log.error("异常开始捕捉{}",e);

        // 自定义业务异常
        if(e instanceof BaseException){
            BaseException baseException = (BaseException) e;
            return ResultVOUtil.error(baseException.getCode(),baseException.getMessage());
        }

        // 系统运行时异常
        String msg = exceptionMap.get(e.getClass().getName());
        if(!StringUtils.isEmpty(msg)){
            // 已知的运行时异常，如数组越界等
            return ResultVOUtil.error(ERROR_CODE,msg);
        }else {
            return ResultVOUtil.error(ERROR_CODE,"未知错误,请联系管理员！");
        }
    }

}
