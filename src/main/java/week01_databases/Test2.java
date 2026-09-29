package week01_databases;

import week02_databases.entities.Products;
import java.util.ArrayList;

import java.sql.*;

public class Test2 {
    static void main (String[] args) {

        //Products = the TYPE of object
        //products = the LIST containing those objects
        ArrayList<Products> products = new ArrayList<>();

        // Declare database constants
        String driver = "com.mysql.cj.jdbc.Driver";
        String dbUrl = "jdbc:mysql://127.0.0.1:3306/classicmodels";
        String username = "root";
        String password = "";

        try {
            // 1) Add driver files
            Class.forName(driver);

            // 2) Create connection to database
            try(Connection conn = DriverManager.getConnection(dbUrl, username, password)) {

                // 3) Write SQL to be used
                String sql = "SELECT * FROM products";

                // 4) Prepare SQL for execution - compile it into something that can be run
                try(Statement ps = conn.createStatement()){

                    // 5) Execute query and store results in ResultSet
                    try(ResultSet rs = ps.executeQuery(sql)){

                        // 6) Process results
                        while(rs.next()){
                            String productCode = rs.getString("ProductCode");
                            String productName = rs.getString("ProductName");
                            String productLine = rs.getString("ProductLine");
                            String productScale = rs.getString("ProductScale");
                            String productVendor = rs.getString("ProductVendor");
                            String productDescription = rs.getString("ProductDescription");
                            System.out.println("-------------------------------------");
                            int quantityInStock = rs.getInt("quantityInStock");
                            double buyPrice = rs.getDouble("buyPrice");
                            double MSRP = rs.getDouble("MSRP");

                            // Creating Product Object
                            Products product = new Products (
                                    productCode,
                                    productName,
                                    productLine,
                                    productScale,
                                    productVendor,
                                    productDescription,
                                    quantityInStock,
                                    buyPrice,
                                    MSRP
                            );

                            // This method adds products to the Arraylist
                            products.add(product);
                        }

                        // for
                        for (Products product : products){
                            System.out.println(product);
                        }

                        conn.close();

                    }catch(SQLException e){
                        System.out.println("Query\"" + sql + "\" could not be executed or" +
                                "result extraction could not be completed ");
                    }

                }catch(SQLException e){
                    System.out.println("Could not prepare SQL \"" + sql + "\" ");
                }

            }catch(SQLException e) {
                System.out.println("Could not establish connection to " + dbUrl +
                        " " + "using "+ username + "as username");
            }

        }catch(ClassNotFoundException e){
            System.out.println("ClassNotFoundException:" +
                    "Driver cannot be found");
            System.out.println("System terminating...");
        }
    }
}
