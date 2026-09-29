package week02_databases.entities;

import java.util.ArrayList;

// Creating class Products and populating it with empty data
public class Products {
    // variables as placeholder names for the data
    private String productCode;
    private String productName;
    private String productLine;
    private String productScale;
    private String productVendor;
    private String productDescription;
    private int quantityInStock;
    private double buyPrice;
    private double MSRP;

    // Creating a constructor method to initialize variables
    public Products(String productCode, String productName, String productLine,
                    String productScale, String productVendor, String productDescription,
                    int quantityInStock, double buyPrice, double MSRP )
    {
        // this is the process of establishing the variables (names can also be changed during process)
        this.productCode = productCode;
        this.productName = productName;
        this.productLine = productLine;
        this.productScale = productScale;
        this.productVendor = productVendor;
        this.productDescription = productDescription;
        this.quantityInStock = quantityInStock;
        this.buyPrice = buyPrice;
        this.MSRP = MSRP;
    }

    // GETTERS - returns the value of the assigned variable
    public String getProductCode() {
        return productCode;
    }
    public String getProductName() { return productName; }
    public String getProductLine() { return productLine; }
    public String getProductScale() { return productScale; }
    public String getProductVendor() { return productVendor; }
    public String getProductDescription() { return productDescription; }
    public int getQuantityInStock() { return quantityInStock; }
    public double getBuyPrice () { return buyPrice; }
    public double getMSRP () { return MSRP; }

    // this method is created to display the objects in a specific way
    @Override
    public String toString() {
        return "Product{" +
                "productCode='" + productCode + '\'' +
                ", productName='" + productName + '\'' +
                ", productLine='" + productLine + '\'' +
                ", productScale='" + productScale + '\'' +
                ", productVendor='" + productVendor + '\'' +
                ", productDescription='" + productDescription + '\'' +
                ", quantityInStock=" + quantityInStock +
                ", buyPrice=" + buyPrice +
                ", MSRP=" + MSRP +
                '}';

    }
    //Products = the TYPE of object
    //products = the LIST containing those objects
//    ArrayList<Products> products = new ArrayList<>();
}
