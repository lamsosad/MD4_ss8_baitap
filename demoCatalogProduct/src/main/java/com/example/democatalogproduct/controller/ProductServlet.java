package com.example.democatalogproduct.controller;

import com.example.democatalogproduct.model.Catalog;
import com.example.democatalogproduct.model.Product;
import com.example.democatalogproduct.util.ConectionToBD;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "ProductServlet", value = "/ProductServlet")
public class ProductServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("UTF-8");
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":

                request.getRequestDispatcher("product/createPro.jsp").forward(request, response);
                break;
            default:
                Connection connection = ConectionToBD.getConnection();
                List<Product> productList = new ArrayList<>();
                Statement statement = null;
                try {
                    statement = connection.createStatement();
                    ResultSet rs = statement.executeQuery("select product.id,product.name,product.price,product.quantity,catalog.name as 'catalog' from product join catalog on product.idCatalog=catalog.idCatalog");
                    while (rs.next()) {
                        int id = rs.getInt(1);
                        String name = rs.getString(2);
                        float price = rs.getFloat(3);
                        int quantity = rs.getInt(4);
                        String catalog = rs.getString(5);
                        productList.add(new Product(id, name, price, quantity, catalog));
                    }
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                } finally {
                    ConectionToBD.closeConnection(connection, statement);
                }
                request.setAttribute("listPro", productList);
                request.getRequestDispatcher("product/Product.jsp").forward(request, response);
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
               float price = Float.parseFloat(request.getParameter("price"));
               int quantity = Integer.parseInt(request.getParameter("quantity"));
               int catalog = Integer.parseInt(request.getParameter("catalog"));
               Connection connection = ConectionToBD.getConnection();
                PreparedStatement preparedStatement=null;
                try {
                     preparedStatement=connection.prepareStatement("insert into product(name,price,quantity,idCatalog)VALUES (?,?,?,?);");
                     preparedStatement.setString(1,name);
                     preparedStatement.setFloat(2,price);
                     preparedStatement.setInt(3,quantity);
                     preparedStatement.setInt(4,catalog);
                     preparedStatement.executeUpdate();
                     response.sendRedirect("ProductServlet?action=show");

                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }finally {
                    ConectionToBD.closeConnection(connection,preparedStatement);
                }
                break;
            default:
                break;
        }
    }
}
