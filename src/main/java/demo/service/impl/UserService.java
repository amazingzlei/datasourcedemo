package demo.service.impl;

import demo.common.datasource.DataSource;
import demo.common.datasource.DataSourceContextHolder;
import demo.common.exception.UserNotFountException;
import demo.common.utils.ResultVOUtil;
import demo.common.vo.ResultVO;
import demo.dao.UserDao;
import demo.service.IUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.aop.framework.AopContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service
public class UserService implements IUserService {
    private static final Logger logger = LoggerFactory.getLogger(UserService.class);

    @Resource
    private UserDao userDao;

    @Override
//    @DataSource(DataSource.ORACLE)
//    @Transactional
    public ResultVO getAllUser() {

        List<Map<String, Object>> maps = userDao.queryAllUser();// pg

        userDao.insertValue(3,"test","test"); // 往mysql里面插

        userDao.insertValueOracle(3,"test","test");// 往oracle里面插

        int a = 1/0;

        return ResultVOUtil.success(maps);
    }

//    @DataSource(DataSource.MYSQL)
//    public void insertUser(){
////        DataSourceContextHolder.setDBType("mysql_dataSource");
//        userDao.insertValue(2,"test","test");
//    }
}
