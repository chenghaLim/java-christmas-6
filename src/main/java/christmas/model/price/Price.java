package christmas.model.price;

import christmas.model.menu.MenuList;
import christmas.model.menu.Order;

import java.util.Map;

public class Price {
    private int beforePrice;

    public Price(Order order) {
        this.beforePrice = beforePrice(order.getOrder());
    }

    private int beforePrice(Map<MenuList, Integer> orderList) {
        return orderList.entrySet().stream()
                .mapToInt(entry -> entry.getKey().getPrice() * entry.getValue())
                .sum();
    }

    public int getBeforePrice() {
        return beforePrice;
    }

}
