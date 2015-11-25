package com.jeff.app11a.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

public class SingleUploadServlet extends HttpServlet{

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    /*
     * 获取content-disposition的表头，将其分解，然后遍历各个元素，找到filename的元素
     */
    private String getFileName(Part part){
        String contentDispositionHeader = part.getHeader("content-disposition");
        String []elements = contentDispositionHeader.split(";");
        for (String element : elements) {
            if(element.trim().startsWith("filename")){
                return element.substring(element.indexOf('=') + 1).trim().replace("\"", "");
            }
        }
        return null;
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Part part = req.getPart("filename");
        String fileName = getFileName(part);
        if (fileName != null && !fileName.isEmpty()) {
            part.write(getServletContext().getRealPath("/WEB_INF"+"/"+fileName));
        }
        resp.setContentType("text/html");
        PrintWriter pw = resp.getWriter();
        pw.print("<br/>Uploaded file name: "+ fileName);
        pw.print("<br/>File size: "+part.getSize());
        pw.print("<br/>Author: "+ req.getParameter("author"));
    }
}
