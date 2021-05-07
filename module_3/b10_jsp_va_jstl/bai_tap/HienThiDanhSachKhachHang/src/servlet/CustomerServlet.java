package servlet;

import bean.Customer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
@WebServlet(name = "servlet.CustomerServlet", urlPatterns = "/customer")
public class CustomerServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    List<Customer> customerList = new ArrayList<>();
    customerList.add(new Customer("Mai Van Hoan","1983-08-20","Ha Noi", "image/cus1.jpg"));
    customerList.add(new Customer("Nguyen Van Nam","1983-08-21","Bac Giang", "image/cus2.jpg"));
    customerList.add(new Customer("Nguyen Thai Hoa","1983-08-22","Nam Dinh", "image/cus3.jpg"));
    customerList.add(new Customer("Tran Dang Khoa","1983-08-17","Ha Tay", "image/cus4.jpg"));
    customerList.add(new Customer("Nguyen Dinh Thi","1983-08-19","Ha Noi", "image/cus5.jpg"));
    request.setAttribute("customerListServlet",customerList);
    request.getRequestDispatcher("list_customer.jsp").forward(request,response);
    }
}
