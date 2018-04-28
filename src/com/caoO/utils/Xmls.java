package com.caoO.utils;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

public class Xmls {
    private Xmls() {}

    /**
     * Parse the text of the specified property of the specified xml
     *
     * @param xmlPath the full path of xml
     * @param propUrl the full url of property from the root
     * @return the text of the specified property
     */
    public static String parse(String xmlPath, String propUrl) {
        Document doc = null;
        try {
            doc = new SAXReader().read(xmlPath);
            Element ele = (Element) doc.selectSingleNode("//" + propUrl);
            return ele.getText();
        } catch (DocumentException e) {
            e.printStackTrace();
        }
        return null;
    }
}
