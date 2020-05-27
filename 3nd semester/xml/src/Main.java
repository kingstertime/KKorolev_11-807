import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
/*
http://java-course.ru/begin/xml/ - взят код парсинга
 */

public class Main {
    public static void main(String[] args) {
        List<Integer> indexesOfBooks = new ArrayList<>();
        try {
            DocumentBuilder documentBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            Document document = documentBuilder.parse("books.tld");
            Node root = document.getDocumentElement();
            System.out.println("List of books:");
            System.out.println();
            NodeList books = root.getChildNodes();
            for (int i = 0; i < books.getLength(); i++) {
                Node book = books.item(i);
                if (book.getNodeType() != Node.TEXT_NODE) {
                    NodeList bookProps = book.getChildNodes();
                    for (int j = 0; j < bookProps.getLength(); j++) {
                        Node bookProp = bookProps.item(j);
                        if (bookProp.getNodeType() != Node.TEXT_NODE && bookProp.getNodeName().equals("price") && Double.parseDouble(bookProp.getChildNodes().item(0).getTextContent()) > 30) {
                            indexesOfBooks.add(i);
                        }
                    }
                }
            }
            for (int i = 0; i < indexesOfBooks.size(); i++) {
                Node soutBook = books.item(indexesOfBooks.get(i));
                if (soutBook.getNodeType() != Node.TEXT_NODE) {
                    NodeList soutBookProps = soutBook.getChildNodes();
                    for (int j = 0; j < soutBookProps.getLength(); j++) {
                        Node soutBookProp = soutBookProps.item(j);
                        if (soutBookProp.getNodeType() != Node.TEXT_NODE) {
                            System.out.println(soutBookProp.getNodeName() + ": " + soutBookProp.getChildNodes().item(0).getTextContent());
                        }
                    }
                }
                System.out.println("<===================>");
            }

        } catch (ParserConfigurationException ex) {
            ex.printStackTrace(System.out);
        } catch (SAXException ex) {
            ex.printStackTrace(System.out);
        } catch (IOException ex) {
            ex.printStackTrace(System.out);
        }
    }
}