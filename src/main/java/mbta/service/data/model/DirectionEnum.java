package mbta.service.data.model;

public enum DirectionEnum {
    INBOUND("0"),
    OUTBOUND("1"),
    BOTH("");

    private String value;

    DirectionEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
