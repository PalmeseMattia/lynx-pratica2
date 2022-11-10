package com.example.lynx_pratica2.testdb;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;

import org.springframework.beans.factory.annotation.Value;

@WebServlet("/testdb")
public class TestDbServlet extends HttpServlet {
    private static final long serialVersionUID=1L;

    @Value("${spring.datasource.username}")
    private String user;

    @Value("${spring.datasource.password}")
    private String pass;

    @Value(("${spring.datasource.driver-class-name}"))
    private String driver;

    @Value("${spring.datasource.url}")
    private String url;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String jdbcUrl=url +
                "?useSSL=false" +
                "&serverTimezone=UTC";

        try {
            PrintWriter out=resp.getWriter();
            out.println("Connecting to database");

            Class.forName(driver);

            Connection connection=DriverManager.getConnection(jdbcUrl,user,pass);

            out.println("success");
            connection.close();

        }catch (Exception e){
            e.printStackTrace();
            throw new ServletException(e);
        }
    }
}
