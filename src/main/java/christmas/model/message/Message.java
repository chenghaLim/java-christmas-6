package christmas.model.message;

public enum Message {
    START("안녕하세요! 우테코 식당 12월 이벤트 플래너입니다."),
    INPUT_DATE("12월 중 식당 예상 방문 날짜는 언제인가요? (숫자만 입력해 주세요!)"),
    INPUT_MENU("주문하실 메뉴를 메뉴와 개수를 알려 주세요. (e.g. 해산물파스타-2,레드와인-1,초코케이크-1)"),
    EVENT("에 우테코 식당에서 받을 이벤트 혜택 미리 보기!"),
    STATMENT("<주문 메뉴>"),
    TOTAL_PRICE("<할인 전 총주문 금액>"),
    Giveaway_menu("<증정 메뉴>"),
    Benefit_details("<혜택 내역>"),
    Total_benefit_amount("<총혜택 금액>"),
    Estimated_payment_amount("<할인 후 예상 결제 금액>"),
    December_event_badge("<12월 이벤트 배지>");

    private String message;

    Message(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
