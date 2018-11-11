package org.transitclock.railml;

import static org.junit.Assert.*;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class TestLoadRailML {
	private static final String filename="railML_SimpleExample_v11_railML2-4_01.xml";
	private static final Logger logger =
			LoggerFactory.getLogger(TestLoadRailML.class);

	@Test
	public void test() {		
		try {

		    File file = new File(this.getClass().getClassLoader().getResource(filename).getPath());
		    JAXBContext jaxbContext = JAXBContext.newInstance(Railml.class);
		    Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
		    Railml railml=(Railml) jaxbUnmarshaller.unmarshal(file);
		    if(railml==null)
		    	fail();
		 } catch (JAXBException e) {
		    logger.error(e.getMessage(), e);
		    fail();
		  }
	}

}
