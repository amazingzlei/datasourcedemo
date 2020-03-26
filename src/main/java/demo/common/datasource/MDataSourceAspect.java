package demo.common.datasource;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Method;

public class MDataSourceAspect {
    private static final Logger logger = LoggerFactory.getLogger(MDataSourceAspect.class);
    /**
     * 拦截目标方法，获取由@DataSource指定的数据源标识，设置到线程存储中以便切换数据源
     *
     * @param point
     * @throws Exception
     */
    public void intercept(JoinPoint point) throws Exception {
        Class<?> target = point.getTarget().getClass();
        MethodSignature signature = (MethodSignature) point.getSignature();
        // 默认使用目标类型的注解，如果没有则使用其实现接口的注解
        for (Class<?> clazz : target.getInterfaces()) {
            resolveDataSource(clazz, signature.getMethod());
        }
        resolveDataSource(target, signature.getMethod());
    }

    /**
     * 提取目标对象方法注解和类型注解中的数据源标识
     *
     * @param clazz
     * @param method
     */
    private void resolveDataSource(Class<?> clazz, Method method) {
        try {
            Class<?>[] types = method.getParameterTypes();

            // 先判断方法上有没有注解，有的话就切换了
            Method m = clazz.getMethod(method.getName(), types);
            if (m != null && m.isAnnotationPresent(DataSource.class)) {
                DataSource source = m.getAnnotation(DataSource.class);
                DataSourceContextHolder.setDBType(source.value());
            }else {
                // 如果方法上没有注解，再判断类上有没有注解，有的话再去切换
                if (clazz.isAnnotationPresent(DataSource.class)) {
                    DataSource source = clazz.getAnnotation(DataSource.class);
                    DataSourceContextHolder.setDBType(source.value());
                }
            }
        } catch (Exception e) {
            logger.error("MDataSourceAspect异常{}", clazz, e);
        }
    }

    /**
     * 方法执行完毕后，清理本地线程存储值
     */
    public void afterIntercept(){
        System.out.println("清空数据源之前："+DataSourceContextHolder.getDBType());
        DataSourceContextHolder.clearDBType();
        System.out.println("清空数据源之后："+DataSourceContextHolder.getDBType());
    }
}
