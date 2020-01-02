package io.data;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

import javax.imageio.ImageIO;
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

public class DataManager {
	
	private static ClassLoader dirOfExecutable = DataManager.class.getClassLoader();
	public static File map;
	public static File cfg;
	public static File ply;
	public static File savegame;

	public static void setupDirs() {
		InputStream myData = dirOfExecutable.getResourceAsStream("data/data.xml");
	}

	/**
	 * Lädt ein Bild aus den Resourcen
	 * 
	 * @param name der Name der Datei
	 * @return das Bild als {@link BufferedImage}-Objekt
	 * @throws IOException Eine IOException wird geworfen, falls das Bild nicht
	 *                     gefunden wurde oder andere Probleme beim Laden auftreten
	 */
	public static BufferedImage loadImage(String name) throws IOException {
		URL res = dirOfExecutable.getResource(name);
		if (res == null)
			throw new IOException("Resource not found: " + name);
		return ImageIO.read(res);
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
