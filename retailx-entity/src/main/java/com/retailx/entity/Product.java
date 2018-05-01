package com.retailx.entity;

import com.retailx.servlet.RequestAttribute;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "products")
public class Product extends BaseObject implements Serializable {

    public static final String PRODUCT_TYPE_STANDARD = "Standard";

    public static final String PRODUCT_TYPE_SERVICE = "Service";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @RequestAttribute(name = "productID")
    private long id;

    @Column(name = "name")
    @RequestAttribute(name = "name")
    private String productName;

    @Column(name = "price")
    @RequestAttribute(name="price")
    private double price;

    @Column(name = "description")
    private String description;

    @Column(name = "product_code")
    @RequestAttribute(name="code")
    private String productCode;

    @Column(name = "product_type")
    @RequestAttribute(name = "type")
    private String productType = Product.PRODUCT_TYPE_STANDARD;

    @Column(name = "cost_price")
    @RequestAttribute(name="cost")
    private double costPrice;

    @Column(name = "tax")
    @RequestAttribute(name="productTax")
    private String tax;

    @Column(name = "tax_method")
    @RequestAttribute(name="taxMethod")
    private String taxMethod;

    @OneToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "categoryId")
//    @RequestAttribute(name="category")
    private Category category;

    @OneToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "supplierId")
    private Supplier supplier;

    @Column(name = "image_path")
    private String imagePath;

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public Product() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    public double getCostPrice() {
        return costPrice;
    }

    public void setCostPrice(double costPrice) {
        this.costPrice = costPrice;

    }

    public String getTax() {
        return tax;
    }

    public void setTax(String tax) {
        this.tax = tax;
    }


    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Supplier getSupplier() {
        return supplier;
    }

    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
    }

    public String getTaxMethod() {
        return taxMethod;
    }

    public void setTaxMethod(String taxMethod) {
        this.taxMethod = taxMethod;
    }



    public String getRequestPath() {
        return "/product/";
    }
}
