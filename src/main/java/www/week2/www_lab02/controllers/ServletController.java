//package www.week2.www_lab02.controllers;
//
//import jakarta.servlet.ServletException;
//import jakarta.servlet.annotation.WebServlet;
//import jakarta.servlet.http.HttpServlet;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//
//import java.io.IOException;
//
//@WebServlet("/controls")
//public class ServletController extends HttpServlet {
//    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
//        Object actionObject = req.getParameter("action");
//        if(actionObject != null){
//            String action = actionObject.toString();
//            if(action.equals("insertCus")){
//                CustomerModel empModel = new CustomerModel();
//                empModel.insertEmp(req, resp);
//            }
//        }else{
//            resp.sendRedirect("test.jsp");
//        }
//    }
//}
