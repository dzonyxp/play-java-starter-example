package controllers;


import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import io.ebean.migration.util.IOUtils;
import models.Contact;


import com.fasterxml.jackson.databind.JsonNode;
import models.Contacts;
import models.Export;
import org.xml.sax.SAXException;
import play.mvc.BodyParser;
import play.mvc.Controller;
import play.mvc.Http;
import play.mvc.Result;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.StringReader;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.xml.sax.InputSource;

import javax.inject.Inject;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import play.libs.ws.*;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletionStage;

public class JSONController extends Controller implements WSBodyReadables, WSBodyWritables {

    private final WSClient ws;
    private String string;

    @Inject
    public JSONController(WSClient ws) {
        this.ws = ws;
    }






    public Result feed(){
        WSRequest request = ws.url("https://www.jobscontact.cz/feed/freelance");
        request.get().thenApply(response -> {save (response.getBody());

            return ok("Download done");});
        return ok("Download started");
    }

    public static void stringToDom(String xmlSource)
            throws SAXException, ParserConfigurationException, IOException, TransformerException {
        // Parse the given input
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document doc = builder.parse(new InputSource(new StringReader(xmlSource)));

        // Write the parsed document to an xml file
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        DOMSource source = new DOMSource(doc);

        StreamResult result =  new StreamResult(new File("data/test02.xml"));
        transformer.transform(source, result);
    }

    public Result my_xml() throws IOException, ParserConfigurationException, TransformerException, SAXException {
//        stringToDom(this.string);
        File file = new File("data/test02.xml");
        String xml = convertStreamToString(new FileInputStream(file));
        XmlMapper xmlMapper = new XmlMapper();
//        Contact value = xmlMapper.readValue("<contact id='1'> <firstname><![CDATA[Blanka]]></firstname> <lastname><![CDATA[Hanáková]]></lastname> <fullname><![CDATA[Blanka Hanáková]]></fullname> <email><![CDATA[b.hanakova@jobscontact.cz]]></email> <phone><![CDATA[+420 775 070 470]]></phone> <skype><![CDATA[jobscontact-jcc001]]></skype> <address><![CDATA[Křenová 531/69a, 602 00 Brno]]></address> </contact>", Contact.class);
//        System.out.println(value.getAddress());
        Export myObjects = xmlMapper.readValue(file, Export.class);
        System.out.println(myObjects);
        return ok();
    }

    static String convertStreamToString(java.io.InputStream is) {
        java.util.Scanner s = new java.util.Scanner(is).useDelimiter("\\A");
        return s.hasNext() ? s.next() : "";
    }
    public void save(String s){
        this.string = s;
        //System.out.println(s);
    }

    public void whenJavaGotFromXmlStr_thenCorrect() throws IOException {
        XmlMapper xmlMapper = new XmlMapper();
        Contact value = xmlMapper.readValue(this.string, Contact.class);
        System.out.println(value.getAddress());
    }

        @BodyParser.Of(BodyParser.Json.class)
    public Result sayHello(Http.Request request) {
        JsonNode json = request.body().asJson();
        String name = json.findPath("name").textValue();
        if (name == null) {
            return badRequest("Missing parameter [name]");
        } else {
            return ok("Hello " + json.toString());
        }
    }
    public static Document convertStringToXMLDocument(String xmlString)
    {
        //Parser that produces DOM object trees from XML content
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

        //API to obtain DOM Document instance
        DocumentBuilder builder = null;
        try
        {
            //Create DocumentBuilder with default configuration
            builder = factory.newDocumentBuilder();

            //Parse the content to Document object
            Document doc = builder.parse(new InputSource(new StringReader(xmlString)));
            Transformer transformer = TransformerFactory.newInstance().newTransformer();
            StreamResult output = new StreamResult(new File("data/output.xml"));
            Source input = new DOMSource(doc);
            StreamResult console = new StreamResult(System.out);
            transformer.transform(input, console);
            return doc;
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return null;
    }
}
