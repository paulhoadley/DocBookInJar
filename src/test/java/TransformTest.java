import static org.junit.jupiter.api.Assertions.fail;

import java.io.ByteArrayInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMResult;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamSource;

import org.junit.jupiter.api.Test;
import org.w3c.dom.Document;

public class TransformTest {
	private static final String DOCUMENT = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n"
			+ "<chapter version=\"5.0\" xmlns=\"http://docbook.org/ns/docbook\">\n"
			+ "<title>My title goes here</title>\n"
			+ "\n"
			+ "<para>\n"
			+ " Paragraph text goes here.\n"
			+ "</para>\n"
			+ "\n"
			+ "<section>\n"
			+ " <title>A section title</title>\n"
			+ "\n"
			+ "<para>\n"
			+ " More paragraph text. Some in <emphasis>italics</emphasis>.\n"
			+ "</para>\n"
			+ "</section>\n"
			+ "</chapter>";

	@Test
	public void transformTest() {
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		dbf.setNamespaceAware(true);
		try (InputStream is = new ByteArrayInputStream(DOCUMENT.getBytes(StandardCharsets.UTF_8))) {
			DocumentBuilder db = dbf.newDocumentBuilder();
			Document d = db.parse(is);
			transformDocument(d);
			return;
		} catch (Exception e) {
			e.printStackTrace();
			fail(e);
		}
	}

	private Document transformDocument(Document document) throws TransformerException, FileNotFoundException {
		DOMResult result = new DOMResult();
		TransformerFactory factory = TransformerFactory.newInstance();
		Source source = new StreamSource("cp:/xsl/driver.xsl");
		Transformer transformer = factory.newTransformer(source);
		transformer.transform(new DOMSource(document), result);
		return (Document) result.getNode();
	}
}
