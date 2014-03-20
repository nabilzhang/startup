package me.nabil.sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.DriverPropertyInfo;
import java.sql.SQLException;
import java.util.Properties;

/**
 * 模拟Driver
 * 
 * @author zhangbi
 * @date 2014年3月20日下午5:59:10
 */
public class NabilDriver implements java.sql.Driver {

    private String prefix = "jdbc:nabil://";

    static {
        try {
            DriverManager.registerDriver(new NabilDriver());
        } catch (SQLException E) {
            throw new RuntimeException("Can't register driver!");
        }
    }

    @Override
    public Connection connect(String url, Properties info) throws SQLException {
        return new NabilConnection();
    }

    @Override
    public boolean acceptsURL(String url) throws SQLException {
        if (url.startsWith(prefix)) {
            return true;
        }
        return false;
    }

    @Override
    public DriverPropertyInfo[] getPropertyInfo(String url, Properties info)
            throws SQLException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public int getMajorVersion() {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public int getMinorVersion() {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public boolean jdbcCompliant() {
        // TODO Auto-generated method stub
        return false;
    }

}
