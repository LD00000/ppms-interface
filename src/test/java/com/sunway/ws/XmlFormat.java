package com.sunway.ws;

import java.io.StringWriter;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.XMLWriter;

public class XmlFormat {
	
	public static void main(String[] args) {
		StringWriter writer = new StringWriter();
		String xml = "<?xml version=" + "\"1.0\"" +  " encoding=" + "\"utf-8\"" + "?>"
				+"<DOCUMENT><INFO><BEGINTIME>2015 11-21 00:00:00</BEGINTIME><ENDTIME>2015 12-22 00:00:00</ENDTIME></INFO></DOCUMENT>"
				;
		try {
			Document doc = DocumentHelper.parseText(xml);
			
			OutputFormat format = new OutputFormat("  ", true);
			format.setEncoding("UTF-8");
			
			XMLWriter xmlwriter = new XMLWriter(writer, format);
			xmlwriter.write(doc);
			System.out.println(writer.toString());
		} catch (Exception e) {
			throw new RuntimeException("xml format error...", e);
		}
	}

}
