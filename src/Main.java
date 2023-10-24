import java.math.BigDecimal;

public class Main {
    public static void main(String [] args){
        Product petFood = new Product("Premium Cat Food", BigDecimal.valueOf(1.41124),
                BigDecimal.valueOf(12.1241), StorageType.KILOGRAM, ProductCategory.PET);

        Product baguette = new Product("French Baguette", BigDecimal.valueOf(2.345),
                BigDecimal.valueOf(8.765), StorageType.PIECE, ProductCategory.BAKERY);

        Product orangeJuice = new Product("Fresh Orange Juice", BigDecimal.valueOf(3.123),
                BigDecimal.valueOf(5.678), StorageType.KILOGRAM, ProductCategory.BEVERAGES);

        Product redApple = new Product("Red Apple", BigDecimal.valueOf(4.567),
                BigDecimal.valueOf(18.432), StorageType.PIECE, ProductCategory.FRUITS);

        Product potatoChips = new Product("Potato Chips", BigDecimal.valueOf(5.678),
                BigDecimal.valueOf(15.432), StorageType.PIECE, ProductCategory.SNACKS);

        Product sirloinSteak = new Product("Sirloin Steak", BigDecimal.valueOf(6.789),
                BigDecimal.valueOf(22.123), StorageType.KILOGRAM, ProductCategory.MEAT);

        Product tomatoes = new Product("Fresh Tomatoes", BigDecimal.valueOf(7.890),
                BigDecimal.valueOf(9.876), StorageType.PIECE, ProductCategory.VEGETABLES);

        Product soySauce = new Product("Soy Sauce", BigDecimal.valueOf(8.901),
                BigDecimal.valueOf(14.567), StorageType.KILOGRAM, ProductCategory.SAUCES_AND_SPICES);

        Product miscellaneousItem = new Product("Miscellaneous Item", BigDecimal.valueOf(9.012),
                BigDecimal.valueOf(11.234), StorageType.PIECE, ProductCategory.UNDEFINED);

        Product chocolateBar = new Product("Dark Chocolate Bar", BigDecimal.valueOf(10.123),
                BigDecimal.valueOf(17.345), StorageType.PIECE, ProductCategory.CONFECTIONERY);

        Product groundCoffee = new Product("Ground Coffee", BigDecimal.valueOf(11.234),
                BigDecimal.valueOf(20.123), StorageType.KILOGRAM, ProductCategory.COFFEE_TEA);

        Product toothpaste = new Product("Toothpaste", BigDecimal.valueOf(12.345),
                BigDecimal.valueOf(7.890), StorageType.PIECE, ProductCategory.HYGIENE);

        Product yogurt = new Product("Natural Yogurt", BigDecimal.valueOf(13.456),
                BigDecimal.valueOf(16.789), StorageType.KILOGRAM, ProductCategory.DAIRY);

        Product laundryDetergent = new Product("Laundry Detergent", BigDecimal.valueOf(14.567),
                BigDecimal.valueOf(13.456), StorageType.PIECE, ProductCategory.HOUSEHOLD);

        Product salmonFillet = new Product("Salmon Fillet", BigDecimal.valueOf(15.678),
                BigDecimal.valueOf(19.567), StorageType.KILOGRAM, ProductCategory.SEAFOOD);
        Product cucumber = new Product("Fresh Cucumber", BigDecimal.valueOf(0.5),
                BigDecimal.valueOf(2.99), StorageType.KILOGRAM, ProductCategory.VEGETABLES);

        Product banana = new Product("Banana", BigDecimal.valueOf(1.2),
                BigDecimal.valueOf(1.49), StorageType.PIECE, ProductCategory.FRUITS);

        Product chickenBreast = new Product("Chicken Breast", BigDecimal.valueOf(0.8),
                BigDecimal.valueOf(7.99), StorageType.KILOGRAM, ProductCategory.MEAT);

        Product salmonSteak = new Product("Salmon Steak", BigDecimal.valueOf(0.6),
                BigDecimal.valueOf(12.99), StorageType.KILOGRAM, ProductCategory.SEAFOOD);

        Product carrot = new Product("Carrot", BigDecimal.valueOf(0.7),
                BigDecimal.valueOf(1.79), StorageType.KILOGRAM, ProductCategory.VEGETABLES);

        Product apple = new Product("Red Apple", BigDecimal.valueOf(1.0),
                BigDecimal.valueOf(2.49), StorageType.PIECE, ProductCategory.FRUITS);

        Product beefSirloin = new Product("Beef Sirloin", BigDecimal.valueOf(0.9),
                BigDecimal.valueOf(9.99), StorageType.KILOGRAM, ProductCategory.MEAT);

        Product codFillet = new Product("Cod Fillet", BigDecimal.valueOf(0.5),
                BigDecimal.valueOf(10.99), StorageType.KILOGRAM, ProductCategory.SEAFOOD);

        Product broccoli = new Product("Fresh Broccoli", BigDecimal.valueOf(0.6),
                BigDecimal.valueOf(3.99), StorageType.KILOGRAM, ProductCategory.VEGETABLES);

        Product orange = new Product("Orange", BigDecimal.valueOf(1.3),
                BigDecimal.valueOf(1.99), StorageType.PIECE, ProductCategory.FRUITS);

        Product porkChops = new Product("Pork Chops", BigDecimal.valueOf(0.8),
                BigDecimal.valueOf(6.99), StorageType.KILOGRAM, ProductCategory.MEAT);

        Product troutFillet = new Product("Trout Fillet", BigDecimal.valueOf(0.4),
                BigDecimal.valueOf(14.99), StorageType.KILOGRAM, ProductCategory.SEAFOOD);

        Product cauliflower = new Product("Fresh Cauliflower", BigDecimal.valueOf(0.7),
                BigDecimal.valueOf(4.99), StorageType.KILOGRAM, ProductCategory.VEGETABLES);

        Product grapefruit = new Product("Grapefruit", BigDecimal.valueOf(1.0),
                BigDecimal.valueOf(2.79), StorageType.PIECE, ProductCategory.FRUITS);

        Product lambLeg = new Product("Lamb Leg", BigDecimal.valueOf(1.2),
                BigDecimal.valueOf(11.99), StorageType.KILOGRAM, ProductCategory.MEAT);
        Order order1 = new Order();
        order1.addProduct(petFood);
        order1.addProduct(baguette);
        order1.addProduct(orangeJuice);
        order1.addProduct(lambLeg);
        order1.addProduct(grapefruit);
        order1.addProduct(porkChops);
        order1.addProduct(orange);
        order1.addProduct(codFillet);
        System.out.println(order1.toString());
        order1.pay();
        System.out.println(order1.toString());
        System.out.println(order1.makeCheck(30, "=", "hello"));
        System.out.println(order1.breakString("In1234567890-24234 the serene twilight, a gentle breeze rustled the leaves, whispering secrets to the ancient trees. Birds, their melodious songs echoing through the air, gracefully danced in the fading light. The tranquil lake shimmered with reflections, mirroring the beauty of the surrounding nature", 12));
    }
}
