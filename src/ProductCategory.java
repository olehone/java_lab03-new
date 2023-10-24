public enum ProductCategory {
    BAG("Bag"),
    BAKERY("Bakery"),
    BEVERAGES("Beverages"),
    BREAD("Bread"),
    CANNED("Canned"),
    CHILDREN("Children"),
    COFFEE_TEA("Coffee and Tea"),
    CONFECTIONERY("Confectionery"),
    DAIRY("Dairy"),
    DRINKS("Drinks"),
    EGGS("Eggs"),
    FISH("Fish"),
    FROZEN("Frozen"),
    FRUITS("Fruits"),
    GROCERY("Grocery"),
    HOUSEHOLD("Household"),
    HYGIENE("Hygiene"),
    MEAT("Meat"),
    PACKAGES("Packages"),
    PET("Pet"),
    READY("Ready"),
    SAUCES_AND_SPICES("Sauces and Spices"),
    SEAFOOD("Seafood"),
    SNACKS("Snacks"),
    SWEETS("Sweets"),
    UNCATEGORIZED("Uncategorized"),
    UNDEFINED("Undefined"),
    VEGETABLES("Vegetables");

    private final String categoryName;

    ProductCategory(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getCategoryName() {
        return categoryName;
    }
}
