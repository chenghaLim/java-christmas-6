package christmas.model.menu;

import java.util.*;

public enum MenuGroup {
    APPETIZER("에피타이저", Arrays.asList(MenuList.BUTTON_MUSHROOM_SOUP, MenuList.TAPAS, MenuList.CAESAR_SALAD)),
    MAIN("메인", Arrays.asList(MenuList.T_BONE_STEAK, MenuList.BARBECUE_RIBS, MenuList.SEAFOOD_PASTA,
            MenuList.CHRISTMAS_PASTA)),
    DESSERT("디저트", Arrays.asList(MenuList.CHOCOLATE_CAKE, MenuList.ICE_CREAM)),
    BEVERAGE("음료", Arrays.asList(MenuList.ZERO_COLA, MenuList.RED_WINE, MenuList.CHAMPAGNE)),
    EMPTY("없음", Collections.EMPTY_LIST);

    private final String name;
    private final List<MenuList> menuList;

    MenuGroup(String name, List<MenuList> menuList) {
        this.name = name;
        this.menuList = menuList;
    }

    public static MenuGroup findByMenuList(MenuList MenuList) {
        return Arrays.stream(MenuGroup.values())
                .filter(menuGroup -> menuGroup.hasMenuName(MenuList))
                .findAny()
                .orElse(EMPTY);
    }

    private boolean hasMenuName(MenuList MenuList) {
        return menuList.stream()
                .anyMatch(menu -> menu == MenuList);
    }

    public List<MenuList> getMenuList() {
        return menuList;
    }

    public static Map<MenuGroup, Integer> setList() {
        Map<MenuGroup, Integer> list = new HashMap<>();
        list.put(MAIN, 0);
        list.put(DESSERT, 0);
        return list;
    }
}
