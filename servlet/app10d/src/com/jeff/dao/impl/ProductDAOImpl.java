package com.jeff.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.jeff.DAOException;
import com.jeff.dao.BaseDao;
import com.jeff.dao.ProductDAO;
import com.jeff.model.Product;

public class ProductDAOImpl extends BaseDao implements ProductDAO {
    private static final String GET_PRODUCTS_SQL = "SELECT　name, description,price FROM products";

    @Override
    public List<Product> getProducts() throws DAOException{
        List<Product> products = new ArrayList<Product>();
        Connection connection = null;
        PreparedStatement pStatement = null;
        ResultSet resultSet = null;
        
        try {
            connection = getConnection();
            pStatement = connection.prepareStatement(GET_PRODUCTS_SQL);
            resultSet = pStatement.executeQuery();
            
            while (resultSet.next()) {
                Product product = new Product();
                product.setName(resultSet.getString("name"));
                product.setDescription(resultSet.getString("description"));
                product.setPrice(resultSet.getFloat("price"));
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }

    private static final String INSERT_PRODUCT_SQL = "INSERET INTO products (name, description, price) VALUE (?, ?, ?)";
    @Override
    public void insert(Product product) throws DAOException{
        Connection connection = null;
        PreparedStatement ps = null;
        
        try {
            connection = getConnection();
            ps = connection.prepareStatement(INSERT_PRODUCT_SQL);
            ps.setString(1, product.getName());
            ps.setString(2, product.getDescription());
            ps.setFloat(3, product.getPrice());
            ps.execute();
        } catch (SQLException e) {
            throw new DAOException("Error adding product. " + e.getMessage());
        } finally {
            closeDBObject(null, ps, connection);
        }
        
    }
}
