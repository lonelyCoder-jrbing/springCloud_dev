import java.sql.Connection;
import java.sql.DriverManager;
/*
 在多线程实现同步的策略中，threadLOcal是以空间换取时间，而线程实现加锁则是以时间换取空间。
 threadLocal为每一个线程提供一个独立的变量副本，从而隔离了多个 线程对数据的访问冲突


 */
public class ConnectionManager {

    private static ThreadLocal<Connection> connectionHolder = new ThreadLocal<Connection>() {
        @Override
        protected Connection initialValue() {

            Connection conn = null;
            try {
                conn = DriverManager.getConnection(
                        "jdbc:mysql://localhost:3306/test", "username",
                        "password");
            } catch (Exception e) {
                e.printStackTrace();
            }

            return conn;
        }
    };

    public static Connection getConn() {
        return connectionHolder.get();
    }

    public static void setConn(Connection conn) {
        connectionHolder.set(conn);
    }

    public static void clear(){
        connectionHolder.remove();
    }
}
