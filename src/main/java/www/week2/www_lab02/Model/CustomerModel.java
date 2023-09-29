//package www.week2.www_lab02.Model;
//
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//import www.week2.www_lab02.models.Customer;
//
//import java.io.IOException;
//
//public class CustomerModel {
//    public void insertEmp(HttpServletRequest req, HttpServletResponse resp) throws IOException {
//        String name = req.getParameter("name");
//        String address = req.getParameter("address");
//        String email = req.getParameter("email");
//        String phone = req.getParameter("phone");
//        Customer customer = new Customer(name, email, address, phone);
//        CustomerServices services = new CustomerServices();
//        services.insertCust(customer);
//        resp.sendRedirect("web/index.jsp");
//
//    }
//}
