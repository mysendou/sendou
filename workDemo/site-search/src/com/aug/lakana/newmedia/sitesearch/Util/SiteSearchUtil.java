package com.aug.lakana.newmedia.sitesearch.Util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class SiteSearchUtil {
    public static Document getDocument(String resource) throws SAXException, IOException {
        InputStream is = null; 
        try {
            is = new FileInputStream(resource);
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setValidating(false);
        factory.setNamespaceAware(false);
        DocumentBuilder builder;
        Document doc = null; 
        try {
            builder = factory.newDocumentBuilder();
            doc = builder.parse(is);
        } catch (ParserConfigurationException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        return doc;
    }
}
