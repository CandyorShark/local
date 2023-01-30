package com.tj.service.dao;

import java.sql.*;

public class RegDao {

    public boolean RegisterDao(String name,String pass,String tpass){
        boolean re = One(name);
        boolean ra = tow(name,pass,tpass);
        if (re){
            if (ra){
                return true;
            }else {
                return false;
            }
        }else {
            return false;
        }
    }

    public boolean One(String name){
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet resu = null;

        try{
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/TANGDB", "TANG", "123456");
            ps = conn.prepareStatement("select * from t_user where name = ?");
            ps.setString(1, name);
            resu = ps.executeQuery();
            if (resu.next()){
                System.out.println("用户名已存在");
                return false;
            }else{
                System.out.println("用户名未注册");
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }finally {
            try {
                if (resu != null) resu.close();
                if (ps != null) ps.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
                return false;
            }
        }
    }

    public boolean tow(String name,String pass,String tpass){
        Connection conn = null;
        PreparedStatement ps = null;
        String pas = pass;
        String tpas = tpass;

        try{
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/TANGDB", "TANG", "123456");
            ps = conn.prepareStatement("insert into t_user values(null,?,?)");
            ps.setString(1, name);
            ps.setString(2,pass);
            if (pass.equals("")){
                System.out.println("密码为空");
                return false;
            }
            if (pass.equals(tpass)){
                ps.executeUpdate();
                System.out.println("注册成功");
                return true;
            }else{
                System.out.println("两次输入密码不一致");
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }finally {
            try{
                if (ps != null) ps.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
                return false;
            }finally {
                try {
                    if (ps != null) ps.close();
                    if (conn != null) conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                    return false;
                }
            }
        }
    }
}
