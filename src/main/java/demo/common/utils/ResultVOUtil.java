package demo.common.utils;

import demo.common.vo.ResultVO;

public class ResultVOUtil {

    private static final Integer SUCCESS_CODE = 200;

    public static ResultVO success(Object object) {
        ResultVO resultVO = new ResultVO();
        resultVO.setCode(SUCCESS_CODE);
        resultVO.setMsg("操作成功");
        resultVO.setData(object);
        return resultVO;
    }

    public static ResultVO success() {
        return success(null);
    }

    public static ResultVO error(Integer code, String msg) {
        ResultVO resultVO = new ResultVO();
        resultVO.setCode(code);
        resultVO.setMsg(msg);
        return resultVO;
    }
}
