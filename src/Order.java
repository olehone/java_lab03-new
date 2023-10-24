import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Order {
    private final Long id;
    private List<Product> products;
    private LocalDateTime paymentTime;
    private boolean isPaid;

    public Order(List<Product> products) {
        this.id = IdService.createId();
        this.products = products;
        this.isPaid = false;
    }

    public Order() {
        this.id = IdService.createId();
        this.products = new ArrayList<>();
        this.isPaid = false;
    }

    public void pay() {
        isPaid = true;
        this.paymentTime = LocalDateTime.now();
    }

    public LocalDateTime getPaymentTime() {
        return paymentTime;
    }

    public boolean isPaid() {
        return isPaid;
    }

    public Long getId() {
        return id;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        if (products == null)
            return;
        this.products = products;
    }

    public void addProduct(Product product) {
        if (product == null)
            return;
        products.add(product);
    }


    public void removeProduct(Product product) {
        if (product == null)
            return;
        products.remove(product);
    }

    public BigDecimal getTotalPrice() {
        return products.stream()
                .map(Product::getFullPrice)
                .reduce(BigDecimal.ZERO, BigDecimal::add)
                .setScale(2, RoundingMode.HALF_UP);
    }
    public String breakString(String input, int maxWidth) {

        return Arrays.stream(input.split("\\s+"))
                .collect(Collectors.groupingBy(word -> word.length() > maxWidth))
                .values()
                .stream()
                .map(words -> String.join(" ", words))
                .collect(Collectors.joining("\n"));
    }
    //Good work when width > 30
    //  ● Якщо у списку товарів є м’ясо або риба, необхідно згенерувати
    //  коментар до чека у форматі “Не забудьте зберігати товари {товар_1},
    //  {товар_2}...{}... у холодильнику”. (Коментар повинен бути
    //  англійською мовою)
    public String makeCheck(int width,final String divider,final String addingCommentary) {
        final String idString = "Order id:" + id;
        final int spaces = (width - idString.length()) / 2;
        final String formattedIdString = String.format("%" + spaces + "s%-" + spaces + "s", "", idString);

        String time = "";
        if (paymentTime != null)
            time = String.format("%-" + (width / 2) + "s%" + (width / 2 + width % 2) + "s\n",
                    paymentTime.format(DateTimeFormatter.ofPattern("yyyy/MM/dd")),
                    paymentTime.format(DateTimeFormatter.ofPattern("HH:mm:ss")));

        final String productPriceFormat = "%-" + (width / 2) + "s%" + (width / 2 + width % 2) + "s\n";
        final String productsString = products.stream().map(product ->
                        product.getName() + "\n" +
                                String.format(
                                        productPriceFormat, product.getQuantity() +
                                                " X "
                                                + product.getPricePerUnit(),
                                        product.getFullPrice()))
                .collect(Collectors.joining("\n"));


        final String totalPriceFormat = "%-3s" + "%" + (width - 3) + "s";

        final List<Product> productsToBeCooled = products.stream()
                .filter(product -> product.getProductCategory() == ProductCategory.MEAT ||
                        product.getProductCategory() == ProductCategory.FISH)
                .toList();

        String commentaryFormat = "%-" + width + "s";
        String comentary = "";
        if(!productsToBeCooled.isEmpty())
            comentary = "Don`t forget to save " +
                    productsToBeCooled.stream().map(Product::getName).collect(Collectors.joining(", ")) +
                    " in the fridge";
        return formattedIdString +
                "\n" + divider.repeat(width) +
                "\n" + productsString +
                "\n\n" + String.format(totalPriceFormat, "Sum", getTotalPrice().toString()) +
                "\n" + divider.repeat(width) +
                "\n" + String.format(commentaryFormat, comentary)+
                "\n" + divider.repeat(width) +
                "\n" + time;


    }

    @Override
    public String toString() {
        return " Order id: " + id +
                "\n Time: " + paymentTime +
                "\n Products: \n" + products.stream().map(Product::toString).collect(Collectors.joining("\n\n")) +
                "\n Is paid " + isPaid;
    }
}
