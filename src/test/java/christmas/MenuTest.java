package christmas;

import christmas.model.menu.MenuGroup;
import christmas.model.menu.Order;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MenuTest {
    @ParameterizedTest
    @ValueSource(strings = {"2-티본스테이크", "레드와인-1", "콜라-1,티본스테이크-2", "티본스테이크-10,아이스크림-11"})
    @DisplayName("정상적인_입력이_아닐때_예외처리")
    void Throw_When_Fail_Order(String names) {
        Assertions.assertThatThrownBy(() -> new Order(names))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"티본스테이크-1,바비큐립-1,초코케이크-2,제로콜라-1", "타파스-1,제로콜라-1"})
    @DisplayName("정상적인_입력_처리_테스트")
    void Not_Throw_When_isValid_Order(String names) {
        Assertions.assertThatCode(() -> new Order(names)).doesNotThrowAnyException();
    }

    @ParameterizedTest
    @ValueSource(strings = {"티본스테이크-2,제로콜라-1,바비큐립-1"})
    @DisplayName("메뉴별로_주문한_그룹 찾기")
    void Make_Group_List_When_isValid_Order(String names) {
        Order order = new Order(names);
        assertEquals(3, order.getOrderGroup().get(MenuGroup.MAIN));
        assertEquals(1, order.getOrderGroup().get(MenuGroup.BEVERAGE));
    }
}

