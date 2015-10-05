package hello;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.ServerSocket;
import java.net.URL;

import javax.xml.namespace.QName;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.soap.MessageFactory;
import javax.xml.soap.SOAPMessage;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMResult;
import javax.xml.transform.dom.DOMSource;
import javax.xml.ws.Dispatch;
import javax.xml.ws.Service;

import org.junit.Test;
import org.w3c.dom.Document;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.core.AprLifecycleListener;
import org.apache.catalina.core.StandardServer;
import org.apache.catalina.startup.Tomcat;


import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;

@SpringApplicationConfiguration(classes = Application.class)
public class helloJUnit {

	protected static Tomcat tomcat; 
	protected static URL wsdlURL;
	protected static QName serviceName;
   	protected static QName portName;
   	protected static String address;
   	
   	@BeforeClass
   	public static void setUp() throws Exception
   	{
   		try {
   			address = "http://localhost:8080/greeting";
			wsdlURL = new URL(address+"?wsdl");
			serviceName = new QName("GET");
			tomcat = new Tomcat();
			tomcat.setPort(8080);
			tomcat.setBaseDir(".");
			tomcat.getHost().setAppBase("./greeting");
			
			StandardServer server = (StandardServer) tomcat.getServer();
			AprLifecycleListener listener = new AprLifecycleListener();
			server.addLifecycleListener(listener);
			tomcat.addWebapp("/greeting", "greeting.war");
			tomcat.start();
			
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
   	}
   	
	@Test
	public void test() throws Exception{
		if(tomcat != null){
			tomcat.stop();
			tomcat.destroy();
			tomcat = null;
		}
	
	}

}
