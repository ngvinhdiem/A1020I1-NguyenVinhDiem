package controller;

import model.bean.Product;
import model.service.ProductService;
import model.service.impl.ProductServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "ProductServlet ", urlPatterns = "/product")
public class ProductServlet extends HttpServlet {
    ProductService productService = new ProductServiceImpl();


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String actionUser = request.getParameter("actionUser");
        if (actionUser == null) {
            actionUser = "";
        }
        switch (actionUser) {
            case "create":
                create(request, response);
                break;
            case "update":
                update(request, response);
                break;
            default:
                search(request, response);
        }

    }

    void create(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        int price = Integer.parseInt(request.getParameter("price"));
        String description = request.getParameter("description");
        String producer = request.getParameter("producer");
        int id = (int) (Math.random() * 1000);

        Product product = new Product(id, name, price, description, producer);

        this.productService.addNewProduct(product);
        List<Product> productList = new ArrayList<>();
        productList = this.productService.showAll();
        request.setAttribute("productListServlet", productList);
        request.getRequestDispatcher("showAll.jsp").forward(request, response);
    }

    void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int updateID = Integer.parseInt(request.getParameter("id"));
        String updateName = request.getParameter("name");
        int updatePrice = Integer.parseInt(request.getParameter("price"));
        String updateDescription = request.getParameter("description");
        String updateProducer = request.getParameter("producer");

        Product updateProduct = new Product(updateID, updateName, updatePrice, updateDescription, updateProducer);

        this.productService.addNewProduct(updateProduct);
        request.setAttribute("productListServlet", this.productService.showAll());
        request.getRequestDispatcher("showAll.jsp").forward(request, response);
    }

    void search(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String searchName = request.getParameter("search");
        for (Product eachProduct : this.productService.showAll()) {
            if (searchName.equals(eachProduct.getName())) {
                request.setAttribute("productDetail", eachProduct);
                request.getRequestDispatcher("search.jsp").forward(request, response);
                break;
            }
        }
        request.getRequestDispatcher("search.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String actionUser = request.getParameter("actionUser");
        if (actionUser == null) {
            actionUser = "";
        }

        switch (actionUser) {
            case "showAll":
                request.setAttribute("productListServlet", this.productService.showAll());
                request.getRequestDispatcher("showAll.jsp").forward(request, response);
                break;
            case "create":
                response.sendRedirect("create.jsp");
                break;
            case "update":
                request.setAttribute("productListServlet", this.productService.showAll());
                request.getRequestDispatcher("update.jsp").forward(request, response);
                break;
            case "delete":
                request.setAttribute("productListServlet", this.productService.showAll());
                request.getRequestDispatcher("delete.jsp").forward(request, response);
                break;
            case "showList":
                request.setAttribute("productListServlet", this.productService.showAll());
                request.getRequestDispatcher("showList.jsp").forward(request, response);
                break;
            case "search":
                response.sendRedirect("search.jsp");
                break;
        }
        if (request.getParameter("indexUpdate") != null) {
            int index = Integer.parseInt(request.getParameter("indexUpdate")) - 1;
            request.setAttribute("updateProduct", this.productService.showAll().get(index));
            request.getRequestDispatcher("detailUpdate.jsp").forward(request, response);
        }
        if (request.getParameter("indexDelete") != null) {
            int index = Integer.parseInt(request.getParameter("indexDelete")) - 1;
            this.productService.delete(this.productService.showAll().get(index).getId());
            request.setAttribute("productListServlet", this.productService.showAll());
            request.getRequestDispatcher("showAll.jsp").forward(request, response);
        }
        if (request.getParameter("indexShowDetail") != null) {
            int index = Integer.parseInt(request.getParameter("indexShowDetail")) - 1;
            request.setAttribute("productShowDetail", this.productService.showAll().get(index));
            request.getRequestDispatcher("showDetail.jsp").forward(request, response);
        }
    }
}