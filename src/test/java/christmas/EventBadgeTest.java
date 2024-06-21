package christmas;

import christmas.model.EventBadge;
import christmas.model.menu.Order;
import christmas.model.price.Discount;
import christmas.model.price.Price;
import christmas.model.visitDay.Day;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class EventBadgeTest {
    @Test
    @DisplayName("산타가_나와야_함")
    void Retrun_Santa() {
        Order order = new Order("티본스테이크-1,바비큐립-1,초코케이크-2,제로콜라-1");
        Price price = new Price(order);
        Discount discount = new Discount(new Day("3"),order,price);
        assertEquals(EventBadge.SANTA,EventBadge.findBadge(discount));
    }

    @Test
    @DisplayName("뱃지_없음")
    void Retrun_Nottihing() {
        Order order = new Order("티본스테이크-1,제로콜라-1");
        Price price = new Price(order);
        Discount discount = new Discount(new Day("26"),order,price);
        assertEquals(EventBadge.NOTTHING,EventBadge.findBadge(discount));
    }

    @Test
    @DisplayName("트리가_나와야_함")
    void Retrun_Tree() {
        Order order = new Order("바비큐립-1,초코케이크-1,제로콜라-1");
        Price price = new Price(order);
        Discount discount = new Discount(new Day("26"),order,price);
        assertEquals(EventBadge.TREE,EventBadge.findBadge(discount));
    }
}
