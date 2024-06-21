package christmas.model.price;

import java.util.LinkedHashMap;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum Event {
    D_DAY(1_000, "크리스마스 디데이 할인: "),
    WEEKDAY(2_023, "평일 할인: "),
    WEEKEND(2_023, "주말 할인: "),
    SPECIAL(1_000, "특별 할인: "),
    GIFT(25_000, "증정 이벤트: ");

    private int discount;
    private String message;

    Event(int discount, String message) {
        this.discount = discount;
        this.message = message;
    }

    public int getDiscount() {
        return discount;
    }

    public static LinkedHashMap<Event, Integer> setList() {
        return Stream.of(Event.values())
                .collect(Collectors.toMap(
                        key -> key,
                        key -> 0,
                        (oldValue, newValue) -> oldValue,
                        LinkedHashMap::new
                ));
    }

    public static String findMessage(Event event) {
        return event.message;
    }
}
