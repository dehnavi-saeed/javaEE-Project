package controller;

import model.DA.DBConnectionManager;
import model.service.LoginService;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        boolean isValidUser=false;
        try {
            LoginService loginService = new LoginService(request.getParameter("username"),
                    request.getParameter("password"),
                    (DBConnectionManager) getServletContext().getAttribute("connectionManager"));
            isValidUser = loginService.isvalid();
        }finally {
            if(isValidUser && Boolean.valueOf(request.getParameter("remember"))){
                Cookie cookie = new Cookie("username",username);
                cookie.setMaxAge(7*24*60*60);
                response.addCookie(cookie);
            }
        }

    }
}
