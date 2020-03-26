package demo.common.datasource;

import java.lang.annotation.*;

/**
 * 自定义注解，配合aop使用：
 *
 * 注解指明使用哪一个数据源
 * aop指明在那些方法前添加exchange()方法
 * exchange()方法解读注解，根据注解判断切换哪一个数据源数据源
 */

@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Documented
public @interface DataSource {

    String ORACLE="oracle_dataSource";

    String MYSQL="mysql_dataSource";

    String PG = "pg_dataSource";

    String value() default DataSource.MYSQL;
}
