package com.jeff.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

import com.jeff.DAOException;
import com.jeff.action.SaveProductionAction;
import com.jeff.form.ProductionForm;
import com.jeff.model.Product;

//@WebFilter(filterName = "DispatcherFilter", urlPatterns = { "/*" })
public class DispatcherFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response,
            FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        String uri = req.getRequestURI();
        int lastIndex = uri.lastIndexOf("/");
        String action = uri.substring(lastIndex + 1);
        if (action.equals("product_input")) {
            // do nothing
        } else if (action.equals("product_save")) {
            ProductionForm productionForm = new ProductionForm();
            productionForm.setName(req.getParameter("name"));
            productionForm.setDescription(req.getParameter("description"));
            productionForm.setPrice(req.getParameter("price"));

            Product product = new Product();
            product.setName(productionForm.getName());
            product.setDescription(productionForm.getDescription());

            try {
                product.setPrice(Float.parseFloat(productionForm.getPrice()));
            } catch (NumberFormatException e) {
                // TODO handler exception
            }

            SaveProductionAction saveProductionAction = new SaveProductionAction();
            try {
                saveProductionAction.save(product);
            } catch (DAOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

            req.setAttribute("product", product);
        }

        String dispathurl = null;

        if ("product_input".equals(action)) {
            dispathurl = "/jsp/ProductForm.jsp";
        } else if ("product_save".equals(action)) {
            dispathurl = "/jsp/ProductDetail.jsp";
        }

        if (null != dispathurl) {
            RequestDispatcher rd = req.getRequestDispatcher(dispathurl);
            rd.forward(req, response);
        } else {
            chain.doFilter(req, response);
        }
    }

    @Override
    public void destroy() {
    }

}
