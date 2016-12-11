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

    public static DirectionEnum lookup(String direction) {
        for (DirectionEnum directionEnum: DirectionEnum.values()) {

            if (directionEnum.name().equals(direction)) {
                return directionEnum;
            }
        }

        return DirectionEnum.BOTH;
    }
}
