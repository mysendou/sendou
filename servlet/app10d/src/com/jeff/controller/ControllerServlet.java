package com.jeff.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jeff.DAOException;
import com.jeff.action.SaveProductionAction;
import com.jeff.form.ProductionForm;
import com.jeff.model.Product;
import com.jeff.validator.ProductValidator;

@WebServlet(name = "ControllerServlet", urlPatterns = { "/product_input",
        "/product_save" })
public class ControllerServlet extends HttpServlet {

    private static final long serialVersionUID = 1579L;

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        try {
            process(req, resp);
        } catch (DAOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        try {
            process(req, resp);
        } catch (DAOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    private void process(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException, DAOException {
        String uri = req.getRequestURI();
        int lastIndex = uri.lastIndexOf('/');
        String action = uri.substring(lastIndex + 1);
        String dispathurl = null;

        if ("product_input".equals(action)) {
            dispathurl = "/jsp/ProductForm.jsp";
        } else if ("product_save".equals(action)) {
            ProductionForm productionForm = new ProductionForm();
            productionForm.setName(req.getParameter("name"));
            productionForm.setDescription(req.getParameter("description"));
            productionForm.setPrice(req.getParameter("price"));

            ProductValidator productValidator = new ProductValidator();
            List<String> errors = productValidator.validator(productionForm);
            if (errors.isEmpty()) {
                Product product = new Product();
                product.setName(productionForm.getName());
                product.setDescription(productionForm.getDescription());
                product.setPrice(Float.parseFloat(productionForm.getPrice()));

                SaveProductionAction saveProductionAction = new SaveProductionAction();
                saveProductionAction.save(product);

                req.setAttribute("product", product);
                dispathurl = "/jsp/ProductDetail.jsp";
            } else {
                req.setAttribute("errors", errors);
                req.setAttribute("form", productionForm);
                dispathurl = "/jsp/ProductForm.jsp";
            }

        }

        if (null != dispathurl) {
            RequestDispatcher rd = req.getRequestDispatcher(dispathurl);
            rd.forward(req, resp);
        }
    }
}
