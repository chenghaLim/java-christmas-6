package christmas.view;

import christmas.model.*;
import christmas.model.price.Event;
import christmas.model.price.Price;
import christmas.model.menu.Order;
import christmas.model.message.Message;
import christmas.model.visitDay.Date;
import christmas.model.visitDay.Day;
import christmas.model.price.Discount;

import java.text.DecimalFormat;
import java.util.Map;

public class Output {

    public void printEvent(Day day) {
        System.out.println(Date.MONTH.getDate() + "월 " + day.getDay() + "일 " + Message.EVENT.getMessage());
        System.out.println();
    }

    public void printOder(Order order) {
        System.out.println(Message.STATMENT.getMessage());
        order.getOrder().entrySet().stream()
                .forEach(entry -> System.out.println(entry.getKey() + " " + entry.getValue() + "개"));
        System.out.println();
    }

    public void printTotalPrice(Price price) {
        System.out.println(Message.TOTAL_PRICE.getMessage());
        System.out.println(formAmount(price.getBeforePrice()));
        System.out.println();
    }

    public void printGivingMenu(Price price) {
        System.out.println(Message.Giveaway_menu.getMessage());
        System.out.println(GiftEvent.overPrice(price).getGift());
        System.out.println();
    }

    public void printDiscount(Discount discount) {
        System.out.println(Message.Benefit_details.getMessage());
        if (noDiscount(discount)) {
            System.out.println("없음");
        }
        resultDiscount(discount);
        System.out.println();
    }

    private boolean noDiscount(Discount discount) {
        Map<Event, Integer> list = discount.getDiscount();
        return list.values().stream()
                .allMatch(value -> value == 0);
    }

    private void resultDiscount(Discount discount) {
        Map<Event, Integer> list = discount.getDiscount();
        for (Map.Entry<Event, Integer> entry : list.entrySet()) {
            if (entry.getValue() != 0) {
                System.out.println(Event.findMessage(entry.getKey()) + "-" + formAmount(entry.getValue()));
            }
        }
    }

    public void printTotalDiscount(Discount discount) {
        System.out.println(Message.Total_benefit_amount.getMessage());
        System.out.println(formAmount(discount.getTotalDiscount()));
        System.out.println();
    }

    private String formAmount(int amount) {
        DecimalFormat decimalFormat = new DecimalFormat("###,###");
        if (amount == 0) {
            return amount + "원";
        }
        return decimalFormat.format(amount) + "원";
    }

    public void printResultPrice(Price price, Discount discount) {
        System.out.println(Message.Estimated_payment_amount.getMessage());
        int result = price.getBeforePrice() - discount.getRealDiscount();
        System.out.println(formAmount(result));
        System.out.println();
    }

    public void printGiftBadge(Discount discount) {
        System.out.println(Message.December_event_badge.getMessage());
        System.out.println(EventBadge.findBadge(discount).getName());
    }
}
