import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import java.sql.*;


import java.io.IOException;

public class Server {
    public static void main(String[] args) {
        try {
            // Establish database connection
            String url = "jdbc:mysql://localhost:3306/rmilaravel";
            String username = "root";
            String password = "";
    
            Connection connection = DriverManager.getConnection(url, username, password);
            System.out.println("Database connection established...");

            // Load MySQL JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            System.setProperty("java.rmi.server.hostname", "127.0.0.1");
            System.out.println("Server has been started...");

            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse("C:/laragon/www/RMILaravel/Products.xml");
            document.getDocumentElement().normalize();

            NodeList productList = document.getElementsByTagName("Product");
            for (int i = 0; i < productList.getLength(); i++) {
                Node productNode = productList.item(i);

                // Parse product details from XML
                if (productNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element productElement = (Element) productNode;
                    int productCode = Integer.parseInt(productElement.getAttribute("productCode"));
                    String name = productElement.getAttribute("name");
                    String description = productElement.getAttribute("description");
                    double retailPrice = Double.parseDouble(productElement.getAttribute("retailPrice"));
                    double storePrice = Double.parseDouble(productElement.getAttribute("storePrice"));
                    int quantity = Integer.parseInt(productElement.getAttribute("quantity"));

                    // Insert product details into the database
                    String insertQuery = "INSERT INTO products (product_code, name, description, retail_price,  store_price, quantity) VALUES (?, ?, ?, ?, ?, ?)";
                    PreparedStatement preparedStatement = connection.prepareStatement(insertQuery);
                    preparedStatement.setInt(1, productCode);
                    preparedStatement.setString(2, name);
                    preparedStatement.setString(3, description);
                    preparedStatement.setDouble(4, retailPrice);
                    preparedStatement.setDouble(5, storePrice);
                    preparedStatement.setInt(6, quantity);

                    System.out.println("Inserted rows into the products table");

                    int rowsAffected = preparedStatement.executeUpdate();
                    if (rowsAffected > 0) {
                        System.out.println("Inserted product: " + name);
                    } else {
                        System.out.println("Failed to insert product: " + name);
                    }

                    preparedStatement.close();
                }
            }

            // Exporting and binding of Objects has been completed
            Cart serve = new Cart();
            CartInterface cart = (CartInterface) UnicastRemoteObject.exportObject(serve, 0);
            Registry registry = LocateRegistry.getRegistry("127.0.0.1", 9100);
            registry.rebind("cart", cart);

            System.out.println("Exporting and binding of Objects has been completed...");
        } catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            System.err.println("SQL Error: " + e.getMessage());
        } catch (ClassNotFoundException e) {
            System.err.println("MySQL JDBC Driver not found: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Some server error..." + e);
        }
    }
}
