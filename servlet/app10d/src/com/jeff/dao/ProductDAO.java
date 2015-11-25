package com.jeff.dao;

import java.util.List;

import com.jeff.DAOException;
import com.jeff.model.Product;

public interface ProductDAO {
    List<Product> getProducts() throws DAOException;
    void insert(Product product) throws DAOException;
}
