package com.demo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

@WebServlet(name = "Servlet2",urlPatterns = "/Servlet2")
public class Servlet2 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        response.setHeader("Content-Disposition","attachment;filename=haha.jpg");
        OutputStream out = response.getOutputStream();
        String Referer = request.getHeader("Referer");

        String path = this.getServletContext().getRealPath("/img/下載.jfif");
        System.out.println(path);
        FileInputStream fis = new FileInputStream(path);

        byte[] b = new byte[1024];
        int len;
        while((len = fis.read(b)) > 0){
            System.out.println(len);
            out.write(b,0,len);//out.write(b);也可以
        }

        fis.close();
        out.close();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
