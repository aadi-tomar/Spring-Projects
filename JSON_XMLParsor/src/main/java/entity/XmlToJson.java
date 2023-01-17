package entity;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.StringReader;

public class XmlToJson {

    String xmlString = "<user>\n" +
            "  <id>1</id>" +
            "  <firstName>Ram</firstName>" +
            "  <lastName>Tomar</lastName>" +
            "  <address>" +
            "    <houseNo>H-54</houseNo>" +
            "    <streetNo> gali no. 2</streetNo>" +
            "    <city>gzb</city>" +
            "    <pinCode>2010343</pinCode>" +
            "  </address>" +
            "</user>";

    public static void main(String[] args) throws JAXBException {
        XmlToJson xmlToJson = new XmlToJson();
        xmlToJson.converXMLtoJSON(xmlToJson.xmlString);
    }

    private void converXMLtoJSON(String xmlString) throws JAXBException {

        JAXBContext jaxbContext = JAXBContext.newInstance(User.class);
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
        User user = (User) unmarshaller.unmarshal(new StringReader(xmlString));
        System.out.println(user);
    }


}
