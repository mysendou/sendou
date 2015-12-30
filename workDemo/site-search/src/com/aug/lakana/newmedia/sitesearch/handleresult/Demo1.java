package com.aug.lakana.newmedia.sitesearch.handleresult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import com.aug.lakana.newmedia.sitesearch.Util.SearchConstants;
import com.aug.lakana.newmedia.sitesearch.Util.SiteSearchUtil;

public class Demo1 {
    public static void main(String[] args) throws Exception {
        Document doc = SiteSearchUtil.getDocument("resource/result.xml");
        Element e = doc.getDocumentElement();
        System.out.println(e.getNodeName());

        String resultNumber = e.getAttribute(SearchConstants.ATTR_RES_EN);
        String startNumber = e.getAttribute(SearchConstants.ATTR_RES_SN);
        System.out.println("result number: " + resultNumber);
        System.out.println("start number: "+ startNumber);
        NodeList nodeList = e.getChildNodes();
        for (int i = 0; i < nodeList.getLength(); i++) {
            Node n = nodeList.item(i);

            String nodeName = n.getNodeName();

            if ("TM".equals(nodeName)) {
                System.out.println("TM : " + n.getTextContent());
            } else if ("Spelling".equals(nodeName)) {
                System.out.println("Spelling : " + n.getTextContent());
            } else if ("RES".equals(nodeName)) {
                System.out.println("RES : " + n.getTextContent());
            }
        }
    }
}
