package com.jeff.util;

import com.jeff.dao.ProductDAO;
import com.jeff.dao.impl.ProductDAOImpl;

public class DAOFactory {
    public static ProductDAO getProductDao(){
        return new ProductDAOImpl();
    }
}
