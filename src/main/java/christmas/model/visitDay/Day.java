package christmas.model.visitDay;

import christmas.model.message.ErrorMessage;

import java.time.DayOfWeek;
import java.time.LocalDate;

public class Day {
    private int day;
    private boolean weekday;
    private boolean special;

    public Day(String inputVisitDay) {
        this.day = valueDateNum(inputVisitDay);
        this.weekday = isWeekend();
        this.special = isSpecial();
    }

    private static void validateRange(int day) {
        if (day < Date.MIN.getDate() || day > Date.MAX.getDate()) {
            throw new IllegalArgumentException(ErrorMessage.DATE.getMessage());
        }
    }

    private static int valueDateNum(String input) {
        try {
            int date = Integer.parseInt(input);
            validateRange(date);
            return date;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.DATE.getMessage());
        }
    }

    private boolean isWeekend() {
        LocalDate visitDay = createDateTimeFormat();
        DayOfWeek dayOfWeek = visitDay.getDayOfWeek();
        return dayOfWeek == DayOfWeek.FRIDAY || dayOfWeek == DayOfWeek.SATURDAY;
    }

    private boolean isSpecial() {
        LocalDate visitDay = createDateTimeFormat();
        DayOfWeek dayOfWeek = visitDay.getDayOfWeek();
        return dayOfWeek == DayOfWeek.SUNDAY || visitDay.getDayOfMonth() == Date.X_MAS.getDate();
    }

    private LocalDate createDateTimeFormat() {
        return LocalDate.of(Date.YEAR.getDate(), Date.MONTH.getDate(), day);
    }

    public boolean getWeekend() {
        return weekday;
    }

    public boolean getSpecial() {
        return special;
    }

    public int getDay() {
        return day;
    }
}
