package com.epam.kgd.stax;

import java.io.FileWriter;
import java.io.IOException;

import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;

public class StAXWriteExample {
	public static void main(String[] args) throws XMLStreamException, IOException {
		XMLOutputFactory factory = XMLOutputFactory.newInstance();

		XMLStreamWriter writer = factory.createXMLStreamWriter(new FileWriter("src/xml_xsd/out.xml"));
	
		//writer.writeStartDocument();
		
		writer.writeStartElement("ancient_book");
		writer.writeAttribute("id", "245");
		
		writer.writeStartElement("title");
		writer.writeCharacters("Book of the future");
		writer.writeEndElement();
		
		writer.writeStartElement("age");
		writer.writeCharacters("265");
		writer.writeEndElement();
		
		writer.writeStartElement("type");
		writer.writeCharacters("Old");
		writer.writeEndElement();
		
		writer.writeStartElement("pages");
		writer.writeCharacters("388");
		writer.writeEndElement();
		
		writer.writeStartElement("lanquage");
		writer.writeCharacters("en-US");
		writer.writeEndElement();
		
		writer.writeStartElement("price");
		writer.writeCharacters("18.55");
		writer.writeEndElement();
		
		writer.writeEndElement();
		//writer.writeEndDocument();
		
		writer.flush();
		writer.close();

	}
}
