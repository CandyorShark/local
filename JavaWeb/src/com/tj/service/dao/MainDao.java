package com.tj.service.dao;

import java.sql.*;

public class MainDao {

    public boolean loginDao(String name, String pass) {

        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet resu = null;

        try {
            //1.注册驱动（固定格式）
            Class.forName("com.mysql.jdbc.Driver");
            //2.获取连接--连接库
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/TANGDB", "TANG", "123456");
            ps = conn.prepareStatement("select * from t_user where name = ? and password = ?");
            ps.setString(1, name);
            ps.setString(2, pass);
            //获取SQL语句
            resu = ps.executeQuery();

            //输出结果
           /* while (resu.next()) {
                System.out.println(resu.getInt("id") + "\t" + resu.getString("name") +
                        "\t" + resu.getString("password"));
            }*/

            if (resu.next()) {
                System.out.println("登录成功");
                return true;
            } else {
                System.out.println("用户名或密码错误");
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            try{
                if (resu != null) resu.close();
                if (ps != null) ps.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
                return false;
            }
        }

    }

}
