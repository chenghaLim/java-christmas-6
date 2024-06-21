package christmas.model.price;

import christmas.model.GiftEvent;
import christmas.model.menu.MenuGroup;
import christmas.model.menu.Order;
import christmas.model.visitDay.Date;
import christmas.model.visitDay.Day;

import java.util.LinkedHashMap;
import java.util.Map;

public class Discount {

    private final int UP_D_DATY = 100;

    private int totalDiscount;
    private int realDiscount;
    private LinkedHashMap<Event, Integer> discount;

    public Discount(Day day, Order order, Price price) {
        this.discount = setDiscount(day, order, price);
        this.realDiscount = discount.get(Event.D_DAY) + discount.get(Event.WEEKDAY) + discount.get(Event.WEEKEND) + discount.get(Event.SPECIAL);
        this.totalDiscount = realDiscount + discount.get(Event.GIFT);
    }

    public int getTotalDiscount() {
        return totalDiscount;
    }

    public int getRealDiscount() {
        return realDiscount;
    }

    public Map<Event, Integer> getDiscount() {
        return discount;
    }

    private LinkedHashMap<Event, Integer> setDiscount(Day day, Order order, Price price) {
        discount = Event.setList();

        setX_Max(day);

        setWeekday(day, order);

        setWeekend(day, order);

        setSpecial(day);

        setGift(price);

        return discount;
    }

    private void setX_Max(Day day) {
        if (day.getDay() <= Date.X_MAS.getDate()) {
            discount.put(Event.D_DAY, Event.D_DAY.getDiscount() + UP_D_DATY * (day.getDay() - 1));
        }
    }

    private void setWeekday(Day day, Order order) {
        if (!(day.getWeekend()) && order.getOrderGroup().get(MenuGroup.DESSERT) != 0) {
            discount.put(Event.WEEKDAY, Event.WEEKDAY.getDiscount() * order.getOrderGroup().get(MenuGroup.DESSERT));
        }
    }

    private void setWeekend(Day day, Order order) {
        if (day.getWeekend() && order.getOrderGroup().get(MenuGroup.MAIN) != 0) {
            discount.put(Event.WEEKEND, Event.WEEKEND.getDiscount() * order.getOrderGroup().get(MenuGroup.MAIN));
        }
    }

    private void setSpecial(Day day) {
        if (day.getSpecial()) {
            discount.put(Event.SPECIAL, Event.SPECIAL.getDiscount());
        }
    }

    private void setGift(Price price) {
        if (GiftEvent.overPrice(price) == GiftEvent.GIFT) {
            discount.put(Event.GIFT, Event.GIFT.getDiscount());
        }
    }
}
