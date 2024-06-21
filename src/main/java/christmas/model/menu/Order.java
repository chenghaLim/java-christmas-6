package christmas.model.menu;

import java.util.*;


public class Order {
    private Map<MenuList, Integer> order;
    private Map<MenuGroup, Integer> orderGroup;
    private final int MIN_ORDER = 1;
    private final int MAX_ORDER = 20;

    public Order(String inputOrder) {
        duplicateOrder(inputOrder);
        Map<MenuList, Integer> temp = validateSetList(inputOrder);
        rangeQuntity(temp);
        NotOnlyOrderDrink(temp);
        this.orderGroup = orderGroup();
        this.order = temp;
    }

    public Map<MenuList, Integer> getOrder() {
        return order;
    }

    public Map<MenuGroup, Integer> getOrderGroup() {
        return orderGroup;
    }

    private Map<MenuList, Integer> validateSetList(String inputOrder) {
        order = new HashMap<>();
        try {
            Arrays.stream(inputOrder.split(","))
                    .map(menu -> menu.split("-"))
                    .forEach(arr -> order.put(MenuList.findByMenuName(arr[0]), validateQuntity(Integer.parseInt(arr[1]))));
            ;
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException();
        }
        return order;
    }

    private void rangeQuntity(Map<MenuList, Integer> orderList) {
        int sum = 0;
        for (MenuList menu : orderList.keySet()) {
            sum += orderList.get(menu);
        }

        if (!(MIN_ORDER <= sum && sum <= MAX_ORDER)) {
            throw new IllegalArgumentException();
        }
    }


    private int validateQuntity(int quntity) {
        if (quntity < MIN_ORDER) {
            throw new IllegalArgumentException();
        }
        return quntity;
    }

    private void duplicateOrder(String inputOrder) {
        List<String> menuList = List.of(inputOrder.split(","));
        for (String menu : menuList) {
            menu = menu.replace("\\d", "");
        }
        Set<String> temp = new HashSet<>(menuList);

        if (menuList.size() != temp.size()) {
            throw new IllegalArgumentException();
        }
    }

    private void NotOnlyOrderDrink(Map<MenuList, Integer> orderList) {
        Set<MenuGroup> list = new HashSet<>();
        for (int i = 0; i < 4; i++) {
            if (MenuGroup.values()[i].getMenuList().stream().anyMatch(orderList::containsKey)) {
                list.add(MenuGroup.values()[i]);
            }
        }

        if (list.size() == 1 && list.contains(MenuGroup.BEVERAGE)) {
            throw new IllegalArgumentException();
        }
    }

    private Map<MenuGroup, Integer> orderGroup() {
        Map<MenuGroup, Integer> list = MenuGroup.setList();

        for (MenuList menu : order.keySet()) {
            MenuGroup menuGroup = MenuGroup.findByMenuList(menu);
            if (menuGroup == MenuGroup.MAIN) {
                list.put(MenuGroup.MAIN, list.get(MenuGroup.MAIN) + order.get(menu));
            }
            if (menuGroup == MenuGroup.DESSERT) {
                list.put(MenuGroup.DESSERT, list.get(MenuGroup.DESSERT) + order.get(menu));
            }
        }

        return list;
    }
}
