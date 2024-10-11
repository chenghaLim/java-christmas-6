package christmas.view;

import camp.nextstep.edu.missionutils.Console;
import christmas.model.menu.Order;
import christmas.model.message.ErrorMessage;
import christmas.model.message.Message;
import christmas.model.visitDay.Day;

import java.util.List;

public class Input {

    public Day readDate() {
        System.out.println(Message.INPUT_DATE.getMessage());
        Day day = null;
        try {
            String input = Console.readLine();
            day = new Day(input);
        } catch (IllegalArgumentException e) {
            System.out.println(ErrorMessage.DATE.getMessage());
            readDate();
        }
        return day;
    }

    public Order readOrder() {
        Order order = null;
        System.out.println(Message.INPUT_MENU.getMessage());
        try {
            String orderMenu = Console.readLine();
            notNumFirst(orderMenu);
            validateInput(orderMenu);
            order = new Order(orderMenu);
        } catch (IllegalArgumentException e) {
            System.out.println(ErrorMessage.MENU.getMessage());
            readOrder();
        }
        return order;
    }

    private static void validateInput(String orderMenu) {
        if (orderMenu.contains(",,")) {
            throw new IllegalArgumentException();
        }

        if (orderMenu.contains("--")) {
            throw new IllegalArgumentException();
        }
    }

    private void notNumFirst(String inputOrder) {
        List<String> menuList = List.of(inputOrder.split(","));
        for (int i = 0; i < menuList.size(); i++) {
            if (i % 2 != 0 && isNumber(menuList.get(i))) {
                throw new IllegalArgumentException();
            }
        }
    }

    private boolean isNumber(String index) {
        return index.chars().allMatch(Character::isDigit);
    }
}
