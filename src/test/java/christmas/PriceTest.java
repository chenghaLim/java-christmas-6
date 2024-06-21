package christmas;

import christmas.model.menu.Order;
import christmas.model.price.Discount;
import christmas.model.price.Price;
import christmas.model.visitDay.Day;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PriceTest {
    @ParameterizedTest
    @ValueSource(strings = {"티본스테이크-2,제로콜라-1,바비큐립-1"})
    @DisplayName("주문_메뉴_총_가격")
    void Total_Price_By_Order(String names) {
        Order order = new Order(names);
        Price price = new Price(order);
        assertEquals(167_000, price.getBeforePrice());
    }

    @Test
    @DisplayName("총_할인_가격")
    void Total_Discount_Price_By_Order() {
        Order order = new Order("티본스테이크-1,바비큐립-1,초코케이크-2,제로콜라-1");
        Price price = new Price(order);
        Discount discount = new Discount(new Day("3"), order, price);
        assertEquals(31_246, discount.getTotalDiscount());
    }

    @Test
    @DisplayName("최종_음식_가격")
    void Total_Price() {
        Order order = new Order("티본스테이크-1,바비큐립-1,초코케이크-2,제로콜라-1");
        Price price = new Price(order);
        Discount discount = new Discount(new Day("3"), order, price);
        int total = price.getBeforePrice() - discount.getRealDiscount();
        assertEquals(135_754, total);
    }
}

