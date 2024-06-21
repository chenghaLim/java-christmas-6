package christmas.model;

import christmas.model.price.Price;

public enum GiftEvent {
    GIFT("샴페인 1개", 120_000),
    NOTTHING("없음", 0);

    private final String gift;
    private final int amount;

    GiftEvent(String gift, int amount) {
        this.gift = gift;
        this.amount = amount;
    }

    public String getGift() {
        return gift;
    }

    public static GiftEvent overPrice(Price price) {
        if (GIFT.amount <= price.getBeforePrice()) {
            return GIFT;
        }
        return NOTTHING;
    }
}
