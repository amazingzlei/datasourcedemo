package demo.common.datasource;

public class DataSourceContextHolder {

    private DataSourceContextHolder(){}

    private static final ThreadLocal<String> contextHolder = new ThreadLocal<String>();

    public static void setDBType(String dbType) {
        System.out.println("设置之前:"+contextHolder.get());
        contextHolder.set(dbType);
        System.out.println("设置之后:"+contextHolder.get());
    }

    public static String getDBType() {
        return ((String) contextHolder.get());
    }

    public static void clearDBType() {
        contextHolder.remove();
    }
}
