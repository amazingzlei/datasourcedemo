package demo.controller;

import demo.common.vo.ResultVO;
import demo.service.IUserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@Controller
public class DataSourceController {

    @Resource
    private IUserService userService;

    @ResponseBody
    @RequestMapping("queryFromMysql")
    public ResultVO queryFromMysql(){
        return userService.getAllUser();
    }
}
