/**
 * $Id$
 * Copyright 2012-2014 Oak Pacific Interactive. All rights reserved.
 */
package t2d.util;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import t2d.util.bean.Column;
import t2d.util.bean.Table;

/**
 * @author <a href="mailto:xiaowei.hu@renren-inc.com">Xiaowei Hu</a>
 * @version 1.0 2012-10-10 下午07:24:10
 * @since 1.0
 */
public class JdbcUtils {

    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new ExceptionInInitializerError(e);
        }
    }

    public static interface Session<T> {

        public T done(Connection conn);
    }

    public static <T> T query(Session<T> session) {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection("jdbc:mysql://10.32.16.19:3306/?user=root&password=");
            return session.done(conn);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    
    public static List<String> getAllCatalogs() {
        return (List<String>) query(new Session<List<String>>(){

            @Override
            public List<String> done(Connection conn) {
                
                List<String> result = new ArrayList<String>();
                try {
                    DatabaseMetaData dbmd = conn.getMetaData();
                    ResultSet rs = dbmd.getCatalogs();
                    
                    while (rs.next()) {
                        result.add(rs.getString(1));
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                
                return result;
            }});
    }
    
    public static List<String> getAllTables(final String schemaName) {
        return (List<String>) query(new Session<List<String>>(){

            @Override
            public List<String> done(Connection conn) {
                
                List<String> result = new ArrayList<String>();
                try {
                    DatabaseMetaData dbmd = conn.getMetaData();
                    ResultSet rs = dbmd.getTables(schemaName, null, null, null);
                    
                    while (rs.next()) {
                        result.add(rs.getString(3));
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                
                return result;
            }});
    }

    public static Table getTable(final String schemaName, final String tabName) {
        return new Table(tabName, getAllColumnsOfTab(schemaName, tabName));
    }
    
    public static List<Column> getAllColumnsOfTab(final String schemaName, final String tabName) {
        return (List<Column>) query(new Session<List<Column>>(){

            @Override
            public List<Column> done(Connection conn) {
                
                List<Column> result = new ArrayList<Column>();
                try {
                    DatabaseMetaData dbmd = conn.getMetaData();
                    ResultSet rs = dbmd.getColumns(schemaName, null, tabName, null);
                    
                    while (rs.next()) {
                        result.add(new Column(rs.getString(4), rs.getString(6)));
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                
                return result;
            }});
    }
    
    public static void main(String[] args) {
        System.out.println(getAllCatalogs());
        System.out.println(getAllTables("games_kp"));
        for (Column col : (getAllColumnsOfTab("games_kp", "user_info"))) {
            System.out.println(col.getType() + " -> " + Type.mapping(col.getType()));
        }
    }
}
