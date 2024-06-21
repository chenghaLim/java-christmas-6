package christmas.view;

import christmas.model.price.Discount;
import christmas.model.price.Price;
import christmas.model.menu.Order;
import christmas.model.visitDay.Day;

public class Result {
    private Output output = new Output();
    private Input input = new Input();

    public void start() {
        Day day = input.readDate();
        Order order = input.readOrder();
        Price price = new Price(order);
        Discount discount = new Discount(day, order, price);
        output.printEvent(day);
        output.printOder(order);
        output.printTotalPrice(price);
        output.printGivingMenu(price);
        output.printDiscount(discount);
        output.printTotalDiscount(discount);
        output.printResultPrice(price, discount);
        output.printGiftBadge(discount);
    }
}
