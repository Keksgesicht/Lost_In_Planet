package io.data.text;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class XML {

	public Element getRoot(File file) {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		Document document = null;
		try {
			DocumentBuilder builder = factory.newDocumentBuilder();
		    document = builder.parse(file);
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		Element root = document.getDocumentElement();
		return root;
	}
	
    public Element getChild(NodeList childList, String name) {
		for (int i = 0; i < childList.getLength();i++) {
			if (childList.item(i).getNodeName().equals(name)) {
				return (Element) childList.item(i);
			}
		}
		return null;
	}
	
	public ArrayList<String> getAttributeValues(String[] attributeList, Element element) {
		ArrayList<String> attributeValues = new ArrayList<String>();
		for (String attribute : attributeList) {
			if (!element.getAttribute(attribute).equals(null)) {
				attributeValues.add(element.getAttribute(attribute));
			} else {
				attributeValues.add(null);
			}
		}
		return attributeValues;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
