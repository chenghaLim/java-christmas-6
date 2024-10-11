package christmas.model.visitDay;

public enum Date {
    MAX(31),
    MIN(1),
    YEAR(2023),
    MONTH(12),
    X_MAS(25);

    private int date;

    Date(int date) {
        this.date = date;
    }

    public int getDate() {
        return date;
    }
}
