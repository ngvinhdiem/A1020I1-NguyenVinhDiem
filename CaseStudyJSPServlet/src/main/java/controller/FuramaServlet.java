package controller;

import model.bean.Customer;
import model.bean.Employee;
import model.bean.Service;
import model.service.CustomerService;
import model.service.EmployeeService;
import model.service.impl.CustomerServiceImpl;
import model.service.ServiceService;
import model.service.impl.EmployeeServiceImpl;
import model.service.impl.ServiceServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "FuramaServlet", urlPatterns = {"", "/furama"})
public class FuramaServlet extends HttpServlet {
    private CustomerService customerService;
    private ServiceService serviceService;
    private EmployeeService employeeService;

    public void init() {
        customerService = new CustomerServiceImpl();
        serviceService = new ServiceServiceImpl();
        employeeService = new EmployeeServiceImpl();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "add-customer":
                try {
                    addNewCustomer(request, response);
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                break;
            case "add-service":
                try {
                    addNewService(request, response);
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                break;
            case "add-employee":
                try {
                    addNewEmployee(request, response);
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                break;
            case "list-services":
                try {
                    searchService(request, response);
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                break;
            case "list-customers":
                try {
                    searchCustomer(request, response);
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                break;
            case "list-employees":
                try {
                    searchEmployee(request, response);
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                break;
            case "edit-customer":
                try {
                    updateCustomer(request, response);
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                break;
            case "edit-service":
                try {
                    updateService(request, response);
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                break;
            case "edit-employee":
                try {
                    updateEmployee(request, response);
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                break;
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "home":
                request.getRequestDispatcher("index.jsp").forward(request, response);
                break;
            case "employee":
                request.getRequestDispatcher("employee/employee.jsp").forward(request, response);
                break;
            case "customer":
                request.getRequestDispatcher("customer/customer.jsp").forward(request, response);
                break;
            case "service":
                request.getRequestDispatcher("service/service.jsp").forward(request, response);
                break;
            case "contract":
                request.getRequestDispatcher("contract/contract.jsp").forward(request, response);
                break;
            case "add-customer":
                request.getRequestDispatcher("customer/addCustomer.jsp").forward(request, response);
                break;
            case "add-service":
                request.getRequestDispatcher("service/addService.jsp").forward(request, response);
                break;
            case "add-employee":
                request.getRequestDispatcher("employee/addEmployee.jsp").forward(request, response);
                break;
            case "list-services":
                listAllServices(request, response);
                break;
            case "list-customers":
                listAllCustomers(request, response);
                break;
            case "list-employees":
                listAllEmployees(request, response);
                break;
            case "edit-customer":
                showEditCustomerForm(request, response);
                break;
            case "edit-service":
                showEditServiceForm(request, response);
                break;
            case "edit-employee":
                showEditEmployeeForm(request, response);
                break;
            case "delete-service":
                try {
                    deleteService(request, response);
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                break;
            case "delete-customer":
                try {
                    deleteCustomer(request, response);
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                break;
            case "delete-employee":
                try {
                    deleteEmployee(request, response);
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                break;

        }
    }


    private void listAllServices(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Service> serviceList = serviceService.selectAllService();
        request.setAttribute("serviceList", serviceList);
        request.getRequestDispatcher("service/listService.jsp").forward(request, response);
    }

    private void listAllCustomers(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Customer> customerList = customerService.selectAllCustomer();
        request.setAttribute("customerList", customerList);
        request.getRequestDispatcher("customer/listCustomer.jsp").forward(request, response);
    }

    private void listAllEmployees(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Employee> employeeList = employeeService.selectAllEmployee();
        request.setAttribute("employeeList", employeeList);
        request.getRequestDispatcher("employee/listEmployee.jsp").forward(request, response);
    }

    private void addNewCustomer(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        int id = (int) (Math.random() * 1000);
        int typeId = Integer.parseInt(request.getParameter("type"));
        String name = request.getParameter("name");
        String birthday = request.getParameter("birthday");
        int genderBit = Integer.parseInt(request.getParameter("gender"));
        String gender;
        if (genderBit == 1) gender = "Nam";
        else gender = "Nu";
        String idCard = request.getParameter("idCard");
        String phone = request.getParameter("phone");
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        Customer customer = new Customer(id, typeId, name, birthday, gender, idCard, phone, email, address);
        customerService.insertCustomerStore(customer);
        listAllCustomers(request, response);
    }

    private void addNewService(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        int id = (int) (Math.random() * 1000);
        String name = request.getParameter("name");
        int area = Integer.parseInt(request.getParameter("area"));
        double cost = Double.parseDouble(request.getParameter("cost"));
        int maxPeople = Integer.parseInt(request.getParameter("maxPeople"));
        int rentTypeId = Integer.parseInt(request.getParameter("rentType"));
        int typeId = Integer.parseInt(request.getParameter("type"));
        String standardRoom = request.getParameter("standardRoom");
        String descriptionOtherConvenience = request.getParameter("descriptionOtherConvenience");
        double poolArea = Double.parseDouble(request.getParameter("poolArea"));
        int numberOfFloors = Integer.parseInt(request.getParameter("numberOfFloors"));
        Service service = new Service(id, name, area, cost, maxPeople, rentTypeId, typeId, standardRoom,
                descriptionOtherConvenience, poolArea, numberOfFloors);
        serviceService.insertServiceStore(service);
        listAllServices(request, response);
    }

    private void addNewEmployee(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        int id = (int) (Math.random() * 1000);
        String name = request.getParameter("name");
        String birthday = request.getParameter("birthday");
        String idCard = request.getParameter("idCard");
        double salary = Double.parseDouble(request.getParameter("salary"));
        String phone = request.getParameter("phone");
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        int positionId = Integer.parseInt(request.getParameter("positionId"));
        int educationDegreeId = Integer.parseInt(request.getParameter("educationDegreeId"));
        int divisionId = Integer.parseInt(request.getParameter("divisionId"));
        Employee employee = new Employee(id,name,birthday,idCard,salary,phone,email,address,
                positionId,educationDegreeId,divisionId);
        employeeService.insertEmployeeStore(employee);
        listAllEmployees(request, response);
    }

    private void searchCustomer(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        String name = request.getParameter("search");
        customerService.selectByName(name);
        List<Customer> customerList = customerService.selectAllCustomer();
        List<Customer> customerListSearch = new ArrayList<>();
        for (Customer customer : customerList) {
            if (name.equals((customer.getCustomerName()))) {
                customerListSearch.add(customer);
            }
        }
        request.setAttribute("customerList", customerListSearch);
        request.getRequestDispatcher("customer/listCustomer.jsp").forward(request, response);
    }

    private void searchService(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        String name = request.getParameter("search");
        serviceService.selectByName(name);
        List<Service> serviceList = serviceService.selectAllService();
        List<Service> serviceListSearch = new ArrayList<>();
        for (Service service : serviceList) {
            if (name.equals((service.getServiceName()))) {
                serviceListSearch.add(service);
            }
        }
        request.setAttribute("serviceList", serviceListSearch);
        request.getRequestDispatcher("service/listService.jsp").forward(request, response);
    }

    private void searchEmployee(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        String name = request.getParameter("search");
        employeeService.selectByName(name);
        List<Employee> employeeList = employeeService.selectAllEmployee();
        List<Employee> employeeListSearch = new ArrayList<>();
        for (Employee employee : employeeList) {
            if (name.equals((employee.getEmployeeName()))) {
                employeeListSearch.add(employee);
            }
        }
        request.setAttribute("employeeList", employeeListSearch);
        request.getRequestDispatcher("employee/listEmployee.jsp").forward(request, response);
    }

    private void showEditCustomerForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Customer customer = customerService.getCustomerById(id);
        String gender1 = "";
        String gender0 = "";
        if (customer.getCustomerGender().equals("Nam")) gender1 = "selected";
        else gender0 = "selected";
        Date customerBirthday = Date.valueOf(customer.getCustomerBirthday());
        request.setAttribute("gender0", gender0);
        request.setAttribute("gender1", gender1);
        request.setAttribute("customerBirthday", customerBirthday);
        request.setAttribute("customer", customer);
        String type1 = "";
        String type2 = "";
        String type3 = "";
        String type4 = "";
        String type5 = "";
        switch (customer.getCustomerTypeId()) {
            case 1:
                type1 = "selected";
                break;
            case 2:
                type2 = "selected";
                break;
            case 3:
                type3 = "selected";
                break;
            case 4:
                type4 = "selected";
                break;
            case 5:
                type5 = "selected";
                break;
        }

        request.setAttribute("type1", type1);
        request.setAttribute("type2", type2);
        request.setAttribute("type3", type3);
        request.setAttribute("type4", type4);
        request.setAttribute("type5", type5);
        request.getRequestDispatcher("customer/editCustomerForm.jsp").forward(request, response);
    }

    private void showEditServiceForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Service service = serviceService.getServiceById(id);
        int rentTypeId = service.getRentTypeId();
        int typeId = service.getServiceTypeId();
        String rentType1 = "";
        String rentType2 = "";
        String rentType3 = "";
        String rentType4 = "";
        String type1 = "";
        String type2 = "";
        String type3 = "";
        switch (rentTypeId) {
            case 1:
                rentType1 = "selected";
                break;
            case 2:
                rentType2 = "selected";
                break;
            case 3:
                rentType3 = "selected";
                break;
            case 4:
                rentType4 = "selected";
                break;
        }
        switch (typeId) {
            case 1:
                type1="selected";
                break;
            case 2:
                type2="selected";
                break;
            case 3:
                type3="selected";
                break;

        }
        request.setAttribute("rentType1", rentType1);
        request.setAttribute("rentType2", rentType2);
        request.setAttribute("rentType3", rentType3);
        request.setAttribute("rentType4", rentType4);
        request.setAttribute("type1", type1);
        request.setAttribute("type2", type2);
        request.setAttribute("type3", type3);
        request.setAttribute("service",service);
        request.getRequestDispatcher("service/editServiceForm.jsp").forward(request, response);
    }

    private void showEditEmployeeForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Employee employee = employeeService.getEmployeeById(id);
        String position1="";
        String position2="";
        String position3="";
        String position4="";
        String position5="";
        String position6="";
        String educationDegree1="";
        String educationDegree2="";
        String educationDegree3="";
        String educationDegree4="";
        String division1="";
        String division2="";
        String division3="";
        String division4="";
        switch (employee.getEmployeePositionId()) {
            case 1:
                position1 = "selected";
                break;
            case 2:
                position2 = "selected";
                break;
            case 3:
                position3 = "selected";
                break;
            case 4:
                position4 = "selected";
                break;
            case 5:
                position5 = "selected";
                break;
            case 6:
                position6 = "selected";
                break;

        }

        switch (employee.getEducationDegreeId()) {
            case 1:
                educationDegree1 = "selected";
                break;
            case 2:
                educationDegree2 = "selected";
                break;
            case 3:
                educationDegree3 = "selected";
                break;
            case 4:
                educationDegree4 = "selected";
                break;

        }

        switch (employee.getDivisionId()) {
            case 1:
                division1 = "selected";
                break;
            case 2:
                division2 = "selected";
                break;
            case 3:
                division3 = "selected";
                break;
            case 4:
                division4 = "selected";
                break;

        }
        request.setAttribute("position1", position1);
        request.setAttribute("position2", position2);
        request.setAttribute("position3", position3);
        request.setAttribute("position4", position4);
        request.setAttribute("position5", position5);
        request.setAttribute("position6", position6);
        request.setAttribute("educationDegree1", educationDegree1);
        request.setAttribute("educationDegree2", educationDegree2);
        request.setAttribute("educationDegree3", educationDegree3);
        request.setAttribute("educationDegree4", educationDegree4);
        request.setAttribute("division1", division1);
        request.setAttribute("division2", division2);
        request.setAttribute("division3", division3);
        request.setAttribute("division4", division4);
        request.setAttribute("employee",employee);
        request.getRequestDispatcher("employee/editEmployeeForm.jsp").forward(request, response);
    }

    private void updateCustomer(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        int id = Integer.parseInt(request.getParameter("id"));
        int typeId = Integer.parseInt(request.getParameter("type"));
        String name = request.getParameter("name");
        String birthday = request.getParameter("birthday");
        int genderBit = Integer.parseInt(request.getParameter("gender"));
        String gender;
        if (genderBit == 1) gender = "Nam";
        else gender = "Nu";
        String idCard = request.getParameter("idCard");
        String phone = request.getParameter("phone");
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        Customer customer = new Customer(id, typeId, name, birthday, gender, idCard, phone, email, address);
        customerService.updateCustomer(customer);
        listAllCustomers(request, response);
    }

    private void updateService(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        int area = Integer.parseInt(request.getParameter("area"));
        double cost = Double.parseDouble(request.getParameter("cost"));
        int maxPeople = Integer.parseInt(request.getParameter("maxPeople"));
        int rentTypeId = Integer.parseInt(request.getParameter("rentType"));
        int typeId = Integer.parseInt(request.getParameter("type"));
        String standardRoom = request.getParameter("standardRoom");
        String descriptionOtherConvenience = request.getParameter("descriptionOtherConvenience");
        double poolArea = Double.parseDouble(request.getParameter("poolArea"));
        int numberOfFloors = Integer.parseInt(request.getParameter("numberOfFloors"));
        Service service = new Service(id, name, area, cost, maxPeople, rentTypeId, typeId, standardRoom,
                descriptionOtherConvenience, poolArea, numberOfFloors);
        serviceService.updateService(service);
        listAllServices(request, response);
    }

    private void updateEmployee(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String birthday = request.getParameter("birthday");
        String idCard = request.getParameter("idCard");
        double salary = Double.parseDouble(request.getParameter("salary"));
        String phone = request.getParameter("phone");
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        int positionId = Integer.parseInt(request.getParameter("positionId"));
        int educationDegreeId = Integer.parseInt(request.getParameter("educationDegreeId"));
        int divisionId = Integer.parseInt(request.getParameter("divisionId"));
        Employee employee = new Employee(id,name,birthday,idCard,salary,phone,email,address,
                positionId,educationDegreeId,divisionId);
        employeeService.updateEmployee(employee);
        listAllEmployees(request, response);
    }

    private void deleteService(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        int id = Integer.parseInt(request.getParameter("id"));
        serviceService.deleteService(id);
        listAllServices(request, response);
    }


    private void deleteCustomer(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        int id = Integer.parseInt(request.getParameter("id"));
        customerService.deleteCustomer(id);
        listAllCustomers(request, response);
    }

    private void deleteEmployee(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        int id = Integer.parseInt(request.getParameter("id"));
        employeeService.deleteEmployee(id);
        listAllEmployees(request, response);
    }


}
