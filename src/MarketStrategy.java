import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

//Написати програму “Магазин”, яка повинна містити відомості та
//        операції для роботи продуктового магазину.
//        Вимоги до функціонала програми:
//        ● Отримання товарів
//        ● Продаж товарів
//        ● Редагування товарів
//        ● Збереження історії покупок користувачів
//        ● Замовлення товарів
//        ● Генерація чека замовлення у .txt форматі.
//        ● Оплачений чек неможливо редагувати.
//        ● Для роботи із файлами створити клас FileService.
//        ● Дані про кількість товарів та ціни потрібно завантажувати із файлу
//        на початку роботи програми.
//        ● Якщо у списку покупок є овочі або фрукти, для кожної позиції
//        товару необхідно додавати пакет.
//        ● Якщо у списку товарів є м’ясо або риба, необхідно згенерувати
//        коментар до чека у форматі “Не забудьте зберігати товари {товар_1},
//        {товар_2}...{}... у холодильнику”. (Коментар повинен бути
//        англійською мовою)
//        ● Написати метод для фільтрування та сортування усіх продуктів на
//        складі за ціною;
//        ● Написати метод для визначення середньої ціни всіх продуктів;
//        ● Написати метод для визначення всіх витрат заданого користувача за
//        заданий період часу;
//
//        ● Написати метод для отримання даних про сумарну кількість кожного
//        купленого продукту заданого користувача;
//        ● Написати метод для знаходження найпопулярнішого продукту;
//        ● Написати метод для знаходження найбільшого доходу за день.
public interface MarketStrategy {
    //  ● Збереження історії покупок користувачів

    //  ● Для роботи із файлами створити клас FileService.



    //  ● Отримання товарів
    Order productToStorage(Product product);
    Order productsToStorage(List<Product> products);
    Product productFromStorage();
    List<Product> productsFromStorage();
    //  ● Продаж товарів
    //  ● Оплачений чек неможливо редагувати.
    //  ● Якщо у списку товарів є м’ясо або риба, необхідно згенерувати
    //  коментар до чека у форматі “Не забудьте зберігати товари {товар_1},
    //  {товар_2}...{}... у холодильнику”. (Коментар повинен бути
    //  англійською мовою)
    void pay(Order order);
    void pay(Order order, Customer customer);
    void returnProductByOrder(Product product, Order order);

    //  ● Редагування товарів
    void changeProduct(Product oldProduct, Product newProduct);
    void changeProduct(Product product, String name, BigDecimal quantity, BigDecimal pricePerUnit, StorageType storageType, ProductCategory productCategory);

    //  ● Замовлення товарів
    //  ● Якщо у списку покупок є овочі або фрукти, для кожної позиції
    //  товару необхідно додавати пакет.
    Order makeUnpaidOrder(List<Product> products);
    Order makeUnpaidOrder(Product products);
    Order addProductToUnpaidOrder(Product product, Order order);
    Order removeProductFromUnpaidOrder(Product product, Order order);
    //  ● Генерація чека замовлення у .txt форматі.
    String getOrderString(Order order);
    void saveOrderToTxtFile(Order order);
    //  ● Дані про кількість товарів та ціни потрібно завантажувати із файлу
    //  на початку роботи програми.
    void getProductsFromFile(String fileName, String path);
    void getFullInfoFromFile(String fileName, String path);
    //  ● Написати метод для фільтрування та сортування усіх продуктів на
    //  складі за ціною;
    void getProductsByPrice(BigDecimal lowestPrice, BigDecimal highestPrice);
    void getDescendingProductsByPrice(BigDecimal lowestPrice, BigDecimal highestPrice);
    void getAscendingByPrice(BigDecimal lowestPrice, BigDecimal highestPrice);
    //  ● Написати метод для визначення середньої ціни всіх продуктів;
    BigDecimal averagePriceOfProducts();
    BigDecimal averagePriceOfProducts(List<Product> products);
    //  ● Написати метод для визначення всіх витрат заданого користувача за
    //  заданий період часу;
    List<Order> ordersByCustomerAndTime(Customer customer, LocalDateTime earliestTime, LocalDateTime latestTime);
    BigDecimal totalCostsByCustomerAndTime(Customer customer, LocalDateTime earliestTime, LocalDateTime latestTime);
    //  ● Написати метод для отримання даних про сумарну кількість кожного
    //  купленого продукту заданого користувача;
    Order totalProductCountByUser(Customer customer);
    //  ● Написати метод для знаходження найпопулярнішого продукту
    Product mostPopularProduct();
    //  ● Написати метод для знаходження найбільшого доходу за день.
    Map<LocalDate, BigDecimal> dailyProfits();
    Map<LocalDate, BigDecimal> dailyProfitsSortByDay();
    Map<LocalDate, BigDecimal> dailyProfitsSortByProfit();
    BigDecimal biggestProfit();

}
