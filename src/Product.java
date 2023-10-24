import java.math.BigDecimal;
import java.math.RoundingMode;

public class Product {
    private String name;
    private BigDecimal quantity;
    private BigDecimal pricePerUnit;
    private StorageType storageType;
    private ProductCategory productCategory;

    public Product(String name, BigDecimal quantity, BigDecimal pricePerUnit, StorageType storageType, ProductCategory productCategory) {
        if (name == null || quantity == null || pricePerUnit == null || storageType == null || productCategory == null)
            return;
        this.name = name;
        this.storageType = storageType;
        this.productCategory = productCategory;
        this.quantity = scaleQuantity(quantity);
        this.pricePerUnit = pricePerUnit.setScale(2, RoundingMode.DOWN);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null)
            return;
        this.name = name;
    }

    public BigDecimal getQuantity() {
        return quantity;
    }

    public void setQuantity(BigDecimal quantity) {
        if (quantity == null)
            return;
        this.quantity = scaleQuantity(quantity);
    }

    public BigDecimal getPricePerUnit() {
        return pricePerUnit;
    }

    public void setPricePerUnit(BigDecimal pricePerUnit) {
        if (pricePerUnit == null)
            return;
        this.pricePerUnit = pricePerUnit.setScale(3, RoundingMode.HALF_UP);
    }

    public StorageType getStorageType() {
        return storageType;
    }

    public void setStorageType(StorageType storageType) {
        if (storageType == null)
            return;
        this.storageType = storageType;
    }

    public ProductCategory getProductCategory() {
        return productCategory;
    }

    public void setProductCategory(ProductCategory productCategory) {
        if (productCategory == null)
            return;
        this.productCategory = productCategory;
    }
    public BigDecimal getFullPrice(){
        return quantity.multiply(pricePerUnit).setScale(2, RoundingMode.HALF_UP);
    }
    private BigDecimal scaleQuantity(BigDecimal bigDecimal) {
        switch (storageType) {
            case KILOGRAM -> {
                return bigDecimal.setScale(3, RoundingMode.DOWN);
            }
            case PIECE -> {
                return bigDecimal.setScale(0, RoundingMode.DOWN).setScale(3, RoundingMode.DOWN);
            }
            default -> {
                return bigDecimal.setScale(3, RoundingMode.HALF_UP);//TODO: exception?
            }
        }
    }

    @Override
    public String toString() {
        return " Name: " + name +
                "\n Category: " + productCategory.getCategoryName()+
                "\n Price: " + pricePerUnit +
                "\n Quantity: " + quantity + " " + storageType.getAbbreviation();
    }
}
