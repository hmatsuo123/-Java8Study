package ch09.ex04;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class SaxParser {
    public static class SimpleHandler extends DefaultHandler {
        @Override
        public void startDocument() {
            System.out.println("startDocument");
        }

        @Override
        public void endDocument() {
            System.out.println("endDocument");
        }

        @Override
        public void startElement(String namespaceURI, String localName, String qName, org.xml.sax.Attributes attrs) {
            System.out.println("\tstartElement: " + qName);
        }

        @Override
        public void endElement(String namespaceURI, String localName, String qName) {
            System.out.println("\tendElement: " + qName);
        }

        @Override
        public void characters(char[] ch, int start, int length) {
            StringBuilder builder = new StringBuilder("\t\tcharacters: ");
            for (int i = 0; i < length; i++) {
                builder.append(ch[start + i]);
            }
            System.out.println(builder.toString());
        }
    }

    public static void main(String[] args) {
        SAXParser parser;
        try {
            SAXParserFactory factory = SAXParserFactory.newInstance();
            parser = factory.newSAXParser();
        }
        // ここの記述が楽
        catch (ParserConfigurationException | SAXException e) {
            e.printStackTrace();
            return;
        }
        try {
        	String filePath = "." + File.separator + "src" + File.separator + "ch09" + File.separator + "ex04" + File.separator + "test.xml";
            parser.parse(new File(filePath), new SimpleHandler());
        } catch (SAXException | IOException e) {
            e.printStackTrace();
        }
    }
}
