package christmas.model.menu;

import java.util.Arrays;

public enum MenuList {
    BUTTON_MUSHROOM_SOUP("양송이수프", 6_000),
    TAPAS("타파스", 5_500),
    CAESAR_SALAD("시저샐러드", 8_000),
    T_BONE_STEAK("티본스테이크", 55_000),
    BARBECUE_RIBS("바비큐립", 54_000),
    SEAFOOD_PASTA("해산물파스타", 35_000),
    CHRISTMAS_PASTA("크리스마스파스타", 25_000),
    CHOCOLATE_CAKE("초코케이크", 15_000),
    ICE_CREAM("아이스크림", 5_000),
    ZERO_COLA("제로콜라", 3_000),
    RED_WINE("레드와인", 60_000),
    CHAMPAGNE("샴페인", 25_000),
    EMPTY("없음", 0);

    private final String name;
    private final int price;

    MenuList(String name, int price) {
        this.name = name;
        this.price = price;
    }


    public int getPrice() {
        return price;
    }

    public static MenuList findByMenuName(String menuName) {
        return Arrays.stream(MenuList.values())
                .filter(menulist -> menulist.hasMenuName(menuName))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException());
    }

    private boolean hasMenuName(String menuName) {
        return name.equals(menuName);
    }
}