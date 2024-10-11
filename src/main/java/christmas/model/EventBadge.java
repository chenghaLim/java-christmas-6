package christmas.model;

import christmas.model.price.Discount;

public enum EventBadge {
    STAR("별", 5_000),
    TREE("트리", 1_000),
    SANTA("산타", 20_000),
    NOTTHING("없음", 0);

    private String name;
    private int goalAmount;

    EventBadge(String name, int goalAmount) {
        this.name = name;
        this.goalAmount = goalAmount;
    }

    public static EventBadge findBadge(Discount discount) {
        if (discount.getTotalDiscount() >= SANTA.goalAmount) {
            return SANTA;
        }
        if (discount.getTotalDiscount() >= TREE.goalAmount) {
            return TREE;
        }
        if (discount.getTotalDiscount() >= STAR.goalAmount) {
            return STAR;
        }
        return NOTTHING;
    }

    public String getName() {
        return name;
    }
}
