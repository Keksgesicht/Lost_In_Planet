package io.data.text;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class XML {
     
	/**
	 * 
	 * @param file the file for the sought root
	 * @return the root of the given file
	 */
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
	
	/**
	 * 
	 * @param childList the list of child-nodes you want to search in
	 * @param name the name of the sought child 
	 * @return the element which represents the child
	 */
    public Element getChildbyName(NodeList childList, String name) {
		for (int i = 0; i < childList.getLength();i++) {
			if (childList.item(i).getNodeName().equals(name)) {
				return (Element) childList.item(i);
			}
		}
		return null;
	}
	
    /**
     * 
     * @param attributeList list of attribute names
     * @param element the element where the attributes are found
     * @return values of the given attributes in the given element
     */
	public ArrayList<String> getAttributeValues(String[] attributeNames, Element element) {
		ArrayList<String> attributeValues = new ArrayList<String>();
		for (String attribute : attributeNames) {
			if (!element.getAttribute(attribute).equals(null)) {
				attributeValues.add(element.getAttribute(attribute));
			} else {
				attributeValues.add(null);
			}
		}
		return attributeValues;
	}
	
	/**
	 * 
	 * @param file the file where the element(s) are 
	 * @param name the tag name of the element(s)
	 * @return nodeList of the element(s) with the tagName within the given file
	 */
	public NodeList getElementsbyName(File file, String tagName) {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder;
		Document document = null;
		try {
			builder = factory.newDocumentBuilder();
			document = builder.parse(file);
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return document.getElementsByTagName(tagName);
	}
	
	/**
	 * 
	 * @param nodeList nodes where the values will be searched
	 * @param attributes name of the sought attributes
	 * @param values sought values of the given attributes
	 * @return ArrayList of elements which have the same values for the given attributes 
	 */
	public ArrayList<Element> getElementsbyValues(NodeList nodeList, String[] attributes, String[] values) {
		ArrayList<Element> returnList = new ArrayList<Element>() ;
		for (int i = 0 ; i < nodeList.getLength();i++) {
			ArrayList<String> realValues = new ArrayList<String>();
			if (nodeList.item(i).getNodeType() == Node.ELEMENT_NODE) {
		    realValues = getAttributeValues(attributes,(Element) nodeList.item(i));
			}
		   boolean same = true;
		   for (int j = 0; j < values.length;j++) {
			   if (!realValues.get(j).equals(values[j])) {
				   same = false;
			   } 
		   }
		   if (same) {
			   returnList.add((Element) nodeList.item(i));
		   }
		}
	   return returnList;
	}

}
