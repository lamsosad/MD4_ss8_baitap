package com.example.democatalogproduct.controller;

import com.example.democatalogproduct.model.Catalog;
import com.example.democatalogproduct.util.ConectionToBD;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "CatalogServlet", value = "/CatalogServlet")
public class CatalogServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("UTF-8");
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                request.getRequestDispatcher("catalog/createCatalog.jsp").forward(request, response);
                break;
            case "delete":
                Connection connection = ConectionToBD.getConnection();
                int idDel = Integer.parseInt(request.getParameter("id"));
                PreparedStatement preparedStatement = null;
                try {
                    preparedStatement = connection.prepareStatement("delete from Catalog where idCatalog=" + idDel);
                    preparedStatement.executeUpdate();
                    response.sendRedirect("CatalogServlet?action=show");
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                break;
            case "edit":
                selectEdit(request, response);
                break;
            default:
                Connection conn = ConectionToBD.getConnection();
                List<Catalog> list = new ArrayList<>();
                Statement st = null;
                try {
                    st = conn.createStatement();
                    ResultSet rs = st.executeQuery("select * from catalog");
                    while (rs.next()) {
                        int id = rs.getInt(1);
                        String name = rs.getString(2);
                        list.add(new Catalog(id, name));
                    }
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                } finally {
                    ConectionToBD.closeConnection(conn, st);
                }
                request.setAttribute("list", list);
                request.getRequestDispatcher("catalog/Catalog.jsp").forward(request, response);
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("UTF-8");
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                String name = request.getParameter("name");
                Connection conn = ConectionToBD.getConnection();
                PreparedStatement preparedStatement = null;
                try {
                    preparedStatement = conn.prepareStatement("insert into catalog(name) values (?)");
                    preparedStatement.setString(1, name);
                    preparedStatement.executeUpdate();
                    response.sendRedirect("CatalogServlet?action=show");
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                } finally {
                    ConectionToBD.closeConnection(conn, preparedStatement);
                }
                break;
            case "update":
                Connection connec = ConectionToBD.getConnection();
                String newName = request.getParameter("name");
                int newId = Integer.parseInt(request.getParameter("id"));
                PreparedStatement prepare = null;
                try {
                    prepare = connec.prepareStatement("update catalog set name = ? where idCatalog = ?");
                    prepare.setString(1, newName);
                    prepare.setInt(2, newId);
                    prepare.executeUpdate();
                    response.sendRedirect("CatalogServlet?action=show");
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                } finally {
                    ConectionToBD.closeConnection(connec, prepare);
                }
                break;
            default:
                break;
        }
    }

    private void selectEdit(HttpServletRequest request, HttpServletResponse response) {
        Catalog catalog = null;
        Connection connection = ConectionToBD.getConnection();
        PreparedStatement pre = null;
        int id = Integer.parseInt(request.getParameter("id"));
        try {
            pre = connection.prepareStatement("select * from Catalog where idCatalog = ?");
            pre.setInt(1, id);
            ResultSet rs = pre.executeQuery();
            while (rs.next()) {
                int catalogId = rs.getInt(1);
                String catalogName = rs.getString(2);
                catalog = new Catalog(catalogId, catalogName);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            ConectionToBD.closeConnection(connection, pre);
        }
        request.setAttribute("catalog", catalog);
        try {
            request.getRequestDispatcher("catalog/editCatalog.jsp").forward(request, response);
        } catch (ServletException | IOException e) {
            throw new RuntimeException(e);
        }
    }
}
