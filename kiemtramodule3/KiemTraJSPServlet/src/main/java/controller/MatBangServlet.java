package controller;

import model.bean.MatBang;
import model.repository.impl.MatBangRepositoryImpl;
import model.service.MatBangService;
import model.service.impl.MatBangServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "MatBangServlet", urlPatterns = {"", "/matbang"})
public class MatBangServlet extends HttpServlet {
    private MatBangService matBangService;

    public void init() {
       matBangService = new MatBangServiceImpl();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "add-mat-bang":
                try {
                    addMatBang(request,response);
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                break;
            case "list-mat-bang":
                try {
                    searchLoaiMatBang(request, response);
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                break;
                case "selectByTang":
                try {
                    searchTang(request, response);
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                break;
                case "selectByGiaThue":
                try {
                    searchGiaThue(request, response);
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
            case "add-mat-bang":
                request.getRequestDispatcher("matbang/addMatBang.jsp").forward(request,response);
                break;
            case "list-mat-bang":
                listMatBang(request,response);
                break;
            case "delete-mat-bang":
                try {
                    deleteMatBang(request,response);
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                break;
        }
    }


    private void addMatBang(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        String maMatBang = request.getParameter("maMatBang").trim();
        String trangThai = request.getParameter("trangThai");
        int dienTich = Integer.parseInt(request.getParameter("dienTich").trim());
        int tang = Integer.parseInt(request.getParameter("tang"));
        String loaiMatBang = request.getParameter("loaiMatBang");
        int giaTien = Integer.parseInt(request.getParameter("giaTien").trim());
        String ngayBatDau = request.getParameter("ngayBatDau");
        String ngayKetThuc = request.getParameter("ngayKetThuc");
        MatBang matBang = new MatBang(maMatBang,trangThai,dienTich,tang,loaiMatBang,giaTien,ngayBatDau,ngayKetThuc);
        matBangService.insertMatBangStore(matBang);
        listMatBang(request,response);
    }


    private void listMatBang(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<MatBang> matBangList = matBangService.selectAllMatBang();
        request.setAttribute("matBangList", matBangList);
        request.getRequestDispatcher("matbang/listMatBang.jsp").forward(request, response);
    }

    private void deleteMatBang(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        String id = request.getParameter("id");
        matBangService.deleteMatBang(id);
        listMatBang(request, response);
    }

    private void searchLoaiMatBang(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        String loaiMatBang = request.getParameter("loaiMatBang");
        List<MatBang> matBangListSearch = new ArrayList<>();
            matBangService.selectByLoaiMatBang(loaiMatBang);
            List<MatBang> matBangList = matBangService.selectAllMatBang();

            for (MatBang matBang : matBangList) {
                if (loaiMatBang.equals((matBang.getLoaiMatBang()))) {
                    matBangListSearch.add(matBang);
                }
            }
        request.setAttribute("matBangList", matBangListSearch);
        request.getRequestDispatcher("matbang/listMatBang.jsp").forward(request, response);
    }

    private void searchTang(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        int tang;
        if (request.getParameter("tang").trim().equals("")) tang=0;
        else {
            tang = Integer.parseInt(request.getParameter("tang"));
        }
        matBangService.selectByTang(tang);
        List<MatBang> matBangList = matBangService.selectAllMatBang();
        List<MatBang> matBangListSearch = new ArrayList<>();
        for (MatBang matBang : matBangList) {
            if (tang==((matBang.getTang()))) {
                matBangListSearch.add(matBang);
            }
        }
        request.setAttribute("matBangList", matBangListSearch);
        request.getRequestDispatcher("matbang/listMatBang.jsp").forward(request, response);
    }

    private void searchGiaThue(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        int giaThue;
        if (request.getParameter("giaThue").trim().equals("")) giaThue=0;
        else {
            giaThue = Integer.parseInt(request.getParameter("giaThue"));
        }
        matBangService.selectByGiaThue(giaThue);
        List<MatBang> matBangList = matBangService.selectAllMatBang();
        List<MatBang> matBangListSearch = new ArrayList<>();
        for (MatBang matBang : matBangList) {
            if (giaThue==((matBang.getGiaTien()))) {
                matBangListSearch.add(matBang);
            }
        }
        request.setAttribute("matBangList", matBangListSearch);
        request.getRequestDispatcher("matbang/listMatBang.jsp").forward(request, response);
    }
}
