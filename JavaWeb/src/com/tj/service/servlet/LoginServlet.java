package com.tj.service.servlet;

import com.tj.service.dao.MainDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.sql.SQLException;

public class LoginServlet extends HttpServlet {
    int index = 0;

    /*@Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("进入doGet方法");
        super.doGet(req, resp);
    }*/

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
        try {
            req.setCharacterEncoding("utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        System.out.println("进入doPost方法");
        String username = req.getParameter("user");
        String password = req.getParameter("pass");
        System.out.println(username + "\n" + password);
        MainDao maindao = new MainDao();
        boolean re = maindao.loginDao(username,password);
        if (re){
            try {
                req.getRequestDispatcher("/main.jsp").forward(req,resp);
            } catch (ServletException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }else{
            try {
                req.getRequestDispatcher("/fail.jsp").forward(req,resp);
            } catch (ServletException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        /*HttpSession session = req.getSession();
        session.setAttribute("username",username);
        resp.sendRedirect("main.jsp");*/

    }

    /*@Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("进入service方法");
        super.service(req, resp);
    }

    @Override
    public void destroy() {
        System.out.println("进入destroy方法");
        super.destroy();
    }

    @Override
    public void init() throws ServletException {
        index++;
        System.out.println("init初始化完毕，全局变量index：" + index);
    }*/
}
