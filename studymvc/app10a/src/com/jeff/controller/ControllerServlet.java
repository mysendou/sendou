package com.jeff.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jeff.action.SaveProductionAction;
import com.jeff.form.ProductionForm;
import com.jeff.model.Product;

@WebServlet(name = "ControllerServlet", urlPatterns = { "/product_input",
		"/product_save" })
public class ControllerServlet extends HttpServlet {

	private static final long serialVersionUID = 1579L;

	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		process(req, resp);
	}

	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		process(req, resp);
	}

	private void process(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String uri = req.getRequestURI();
		int lastIndex = uri.lastIndexOf('/');
		String action = uri.substring(lastIndex + 1);

		if ("product_input".equals(action)) {
			// no action
		} else if ("product_save".equals(action)) {
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
			saveProductionAction.save(product);

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
			rd.forward(req, resp);
		}
	}
}
