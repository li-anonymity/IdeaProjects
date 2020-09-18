package com.demo;

import com.sun.org.apache.xerces.internal.impl.xs.XSComplexTypeDecl;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.crypto.Data;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.SimpleFormatter;

@WebServlet(name = "Servlet1",urlPatterns = "/Servlet1")
public class Servlet1 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
//        response.setHeader("Refresh","5");
//        response.sendRedirect("/ServletDemo/Servlet2");
//        response.setDateHeader("Express",-1);
//        response.setHeader("Cache-Control","no-cache");
//        response.setHeader("Pragma","no-cache");
        PrintWriter out = response.getWriter();
        System.out.println(new Date().getTime());
        System.out.println(new Date(0).toString());
        out.println("现在时间：" + new Date().toString());

        Date date = new Date(); //获取当前的系统时间。
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss") ; //使用了默认的格式创建了一个日期格式化对象。
        String time = dateFormat.format(date); //可以把日期转换转指定格式的字符串
        System.out.println("当前的系统时间："+ time);

        String birthday = "2000年12月26日 11:29:08";
        Date date2 = null; //注意:指定的字符串格式必须要与SimpleDateFormat的模式要一致。
        try {
            date2 = dateFormat.parse(birthday);
            date2.getTime();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        System.out.println(date2);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
