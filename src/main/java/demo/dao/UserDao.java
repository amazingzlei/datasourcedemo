package demo.dao;

import demo.common.datasource.DataSource;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface UserDao {
    List<Map<String, Object>> queryAllUser();

    @DataSource(DataSource.MYSQL)
    int insertValue(@Param("id") Integer id, @Param("name") String name, @Param("value") String value);

    @DataSource(DataSource.ORACLE)
    int insertValueOracle(@Param("id") Integer id, @Param("name") String name, @Param("value") String value);
}
