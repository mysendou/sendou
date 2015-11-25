package com.jeff.action;

import com.jeff.DAOException;
import com.jeff.dao.ProductDAO;
import com.jeff.model.Product;
import com.jeff.util.DAOFactory;

public class SaveProductionAction {
    ProductDAO productDAO = DAOFactory.getProductDao();
    public void save(Product product) throws DAOException{
        productDAO.insert(product);
    }
}
