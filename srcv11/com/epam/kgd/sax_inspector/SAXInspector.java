package com.epam.kgd.sax_inspector;

import java.io.IOException;
import java.util.List;

import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import com.epam.kgd.bean.Treasure;
import com.epam.kgd.sax.handler.TreasureSaxHandler;

public class SAXInspector {

	public static void main(String[] args) throws SAXException, IOException {
		XMLReader reader = XMLReaderFactory.createXMLReader();
		TreasureSaxHandler handler = new TreasureSaxHandler();
		reader.setContentHandler(handler);
		
		reader.parse(new InputSource("src/xml_xsd/treasures.xml"));
		
		List<Treasure> list = handler.getTreasureList();
		
		for(Treasure tr : list){
			System.out.println(tr.toString());
		}

	}

}
