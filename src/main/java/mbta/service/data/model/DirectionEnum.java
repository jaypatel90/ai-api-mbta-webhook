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

            if (directionEnum.name().compareToIgnoreCase(direction) == 0) {
                return directionEnum;
            }
        }

        return DirectionEnum.BOTH;
    }

    public static DirectionEnum lookupFromDirectionNumber(String directionNumber) {
        for (DirectionEnum directionEnum: DirectionEnum.values()) {

            if (directionEnum.getValue().equals(directionNumber)) {
                return directionEnum;
            }
        }

        return null;
    }
}
