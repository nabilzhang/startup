package me.nabil.sql.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

/**
 * 测试下驱动
 * 
 * @author zhangbi
 * @date 2014年3月20日下午5:54:51
 */
public class TestJdbc {
    public static void main(String args[]) throws ClassNotFoundException,
            SQLException, NamingException {
        // DriverManager方式连接
        ConnectByDriverManager();

        // DataSource连接
        ConnectByDataSource();

    }

    /**
     * 
     * @throws NamingException
     * @throws SQLException
     */
    private static void ConnectByDataSource() throws NamingException,
            SQLException {
        Context context = new InitialContext();
        DataSource ds = (DataSource) context.lookup("jdbc/nabil");
        Connection conn = ds.getConnection();
        Statement stmt = conn.createStatement();

        ResultSet rs = stmt.executeQuery("get a");
        int i = 0;
        while (rs.next()) {
            System.out.println(rs.getString(i));
            i++;
            if (i > 10) {
                break;
            }
        }
    }

    /**
     * 
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    private static void ConnectByDriverManager() throws ClassNotFoundException,
            SQLException {

        Class.forName("me.nabil.sql.NabilDriver");
        Connection conn = DriverManager.getConnection(
                "jdbc:a://192.168.0.1:3344/default", "user", "name");
        Statement stmt = conn.createStatement();

        ResultSet rs = stmt.executeQuery("get a");
        int i = 0;
        while (rs.next()) {
            System.out.println(rs.getString(i));
            i++;
            if (i > 10) {
                break;
            }
        }
    }
}
