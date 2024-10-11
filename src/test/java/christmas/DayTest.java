package christmas;

import christmas.model.visitDay.Day;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class DayTest {
    @ParameterizedTest
    @ValueSource(strings = {"32", "0", "aa", "a1", "1,2"})
    @DisplayName("정상적인_입력이_아닐때_예외처리")
    void Throw_When_Fail_Day(String days) {
        Assertions.assertThatThrownBy(() -> new Day(days))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"3", "25"})
    @DisplayName("정상적인_입력_처리_테스트")
    void Not_Throw_When_isValid_Day(String names) {
        Assertions.assertThatCode(() -> new Day(names)).doesNotThrowAnyException();
    }

    @ParameterizedTest
    @ValueSource(strings = {"3", "10", "25"})
    @DisplayName("별이_표시된_날")
    void True_Return_When_Special_Day(String names) {
        Day day = new Day(names);
        assertTrue(day.getSpecial());
    }

    @ParameterizedTest
    @ValueSource(strings = {"4", "5", "6"})
    @DisplayName("평일")
    void True_Return_When_Week_Day(String names) {
        Day day = new Day(names);
        assertFalse(day.getWeekend());
    }

    @ParameterizedTest
    @ValueSource(strings = {"8", "9", "15"})
    @DisplayName("주말")
    void True_Return_When_Week_End(String names) {
        Day day = new Day(names);
        assertTrue(day.getWeekend());
    }
}
