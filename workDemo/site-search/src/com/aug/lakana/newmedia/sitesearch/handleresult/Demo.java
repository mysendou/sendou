package com.aug.lakana.newmedia.sitesearch.handleresult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import com.aug.lakana.newmedia.sitesearch.Util.SiteSearchUtil;

public class Demo {
    public static void main(String[] args) throws Exception {
        Document doc = SiteSearchUtil.getDocument("resource/the google responce.xml");
        
        Element e = doc.getDocumentElement();
        NodeList nodeList = e.getChildNodes();
        for(int i = 0; i < nodeList.getLength(); i++) {
            Node n = nodeList.item(i);
            
            String nodeName = n.getNodeName();
            //System.out.print("NodeName : "+ nodeName);
            
            if("TM".equals(nodeName)) {
                System.out.println("TM : " + n.getTextContent());
            } else if("Spelling".equals(nodeName)) {
                System.out.println("Spelling : " + n.getTextContent());
            } else if("RES".equals(nodeName)) {
                System.out.println("RES : " + n.getTextContent());
            }
        }
    }
}
