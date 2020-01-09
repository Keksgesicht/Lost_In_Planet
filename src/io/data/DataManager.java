package io.data;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;

import javafx.scene.image.Image;

public class DataManager {
	
	private static ClassLoader dirOfExecutable = DataManager.class.getClassLoader();
	static File map;
	static File cfg;
	static File ply;
	static File savegame;

	public static void setupDirs() {
		InputStream myData = dirOfExecutable.getResourceAsStream("data/data.xml");
	}

	/**
	 * @param iStream the stream from which to load the image
	 * @param width   the image's bounding box width
	 * @param height  the image's bounding box height
	 * @return the Image
	 * @throws NullPointerException if input stream is null
	 */
	public static Image loadImage(InputStream iStream, double width, double height) {
		return new Image(iStream, width, height, false, true);
	}
	
	/**
	 * @param fileLocation where the file should be located within the filesystem
	 * @param width        the image's bounding box width
	 * @param height       the image's bounding box height
	 * @return the Image
	 * @throws FileNotFoundException
	 */
	public static Image loadImage(String fileLocation, double width, double height) throws FileNotFoundException {
		return loadImage(new FileInputStream(fileLocation), width, height);
	}

	public static Document docBuilder() {
		
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
	    DocumentBuilder dBuilder = null;
		try {
			dBuilder = dbFactory.newDocumentBuilder();
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Document doc = dBuilder.newDocument();
		return doc;
	}
	
	public static void fileBuilder(Document doc, String pathname) {
		TransformerFactory transformerFactory = TransformerFactory.newInstance();
		try {
			Transformer transformer = transformerFactory.newTransformer();
			DOMSource source = new DOMSource(doc);
	        StreamResult result = new StreamResult(new File(pathname));
	        transformer.transform(source, result);
		} catch (TransformerConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (TransformerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
