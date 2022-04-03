package com.Lozijy.dao;



import java.io.IOException;
import java.sql.*;

public class  BaseDao{



    //编写连接数据库
    public static Connection getConnection() throws IOException {
        Connection cnn = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            cnn = DriverManager.getConnection("jdbc:mysql://localhost:3305/usr?useUnicode=true&characterEncoding=utf-8", "root", "qwaszxa2");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return cnn;
    }
    //编写查询公共类方法自己写的是cnn(调用getconnection),sql其他三个参数均写null
    public static  ResultSet execute(Connection cnn,String sql,Object[]params,ResultSet resultSet,PreparedStatement preparedStatement) throws SQLException {
        PreparedStatement ps = cnn.prepareStatement(sql);
        for (int i = 0; i < params.length; i++) {
            ps.setObject(i+1,params[i]);
        }
        resultSet  = ps.executeQuery();
        return resultSet;
    }
    //编写增删改方法(重构execute)
    public static  int execute(Connection cnn,String sql,Object[]params,PreparedStatement preparedStatement) throws SQLException {
        PreparedStatement ps = cnn.prepareStatement(sql);
        for (int i = 0; i < params.length; i++) {
            ps.setObject(i+1,params[i]);
        }
        int updateRows = ps.executeUpdate();
        return updateRows;
    }
    //编写释放资源方法(connection,preparedstatement,resulset)
    public  static  boolean free(Connection cnn,PreparedStatement preparedStatement,ResultSet resultSet) throws SQLException {
        boolean flag=true;
        if(cnn!=null){
            cnn.close();
            cnn=null;//GC回收
        }
        if(preparedStatement!=null){
            preparedStatement.close();
            preparedStatement=null;//GC回收
        }
        if(resultSet!=null){
            resultSet.close();
            resultSet=null;//GC回收
        }
        return flag;
    }
}
