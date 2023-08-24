package com.lulu.tools.db;

import com.alibaba.druid.pool.DruidDataSource;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class JDBCUtil {

    private static final DruidDataSource dataSource = new DruidDataSource();
    private static final ThreadLocal<Connection> threads = new ThreadLocal<>();
    private static boolean hump = false;

    static {
        //可替换为配置文件读入
        dataSource.setUsername("root");
        dataSource.setPassword("12345678");
        dataSource.setUrl("jdbc:mysql://localhost:3306/atguigudb");
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        //还有其他常见设置参数
    }

    public static void setAutoCommit(boolean autoCommit) throws SQLException {
        if (threads.get() == null) threads.set(dataSource.getConnection());
        threads.get().setAutoCommit(autoCommit);
    }

    public static void setHump(boolean isHump) {
        hump = isHump;
    }

   public static void commit() throws SQLException {
       if (threads.get() == null) return;
       threads.get().commit();
   }

   public static void rollback() throws SQLException {
        if (threads.get() == null) return;
        threads.get().rollback();
   }

   public static void close() throws SQLException {
       if (threads.get() == null) throw new NullPointerException("无对应数据库连接");
       Connection connection = threads.get();
       connection.setAutoCommit(false);
       connection.close();
       threads.remove();
   }

   public static Integer executeUpdate(String sql, Object... args) throws SQLException {
        if (threads.get() == null) threads.set(dataSource.getConnection());
        Integer res;
        Connection connection = null;
       PreparedStatement statement = null;

       try {
           connection = threads.get();
           statement = connection.prepareStatement(sql);
           for (int i = 1; i <= args.length; ++i) {
               statement.setObject(i, args[i - 1]);
           }
           res = statement.executeUpdate();
       } finally {
           if (statement != null) statement.close();
           if (connection != null && connection.getAutoCommit()) close();
       }
       return res;
   }

   public static <T> List<T> executeQuery(Class<T> t, String sql, Object... args) throws SQLException, NoSuchMethodException {
        if (threads.get() == null) threads.set(dataSource.getConnection());
        List<T> res = new ArrayList<>();

        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            connection = threads.get();
            statement = connection.prepareStatement(sql);
            for (int i = 1; i <= args.length; ++i) {
                statement.setObject(i, args[i - 1]);
            }
            resultSet = statement.executeQuery();
            ResultSetMetaData metaData = resultSet.getMetaData();
            int columnCount = metaData.getColumnCount();
            while (resultSet.next()) {
                T instance = t.getConstructor().newInstance();
                for (int i = 0; i < columnCount; i++) {
                    String name = metaData.getColumnLabel(i + 1);
                    Object value = resultSet.getObject(name);
                    if (hump) name = changeName(name);
                    Field field = t.getDeclaredField(name);
                    field.setAccessible(true);
                    field.set(instance, value);
                }
                res.add(instance);
            }
        } catch (NoSuchFieldException | InvocationTargetException | InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        } finally {
            if (resultSet != null) resultSet.close();
            if (statement != null) statement.close();
            if (connection != null && connection.getAutoCommit()) close();
        }
        return res;
   }

    private static String changeName(String name) {
        String[] split = name.split("_");
        StringBuilder res = new StringBuilder(split[0]);
        for (int i = 1; i < split.length; ++i) {
            if (split[i].length() <= 1) res.append(split[i].toUpperCase(Locale.ROOT));
            else {
                res.append(split[i].substring(0, 1).toUpperCase(Locale.ROOT)).append(split[i].substring(1));
            }

        }
        return res.toString();
    }

}
