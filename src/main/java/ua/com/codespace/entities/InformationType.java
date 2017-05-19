package ua.com.codespace.entities;

public enum InformationType {
    AREA("Area"),
    POPULATION("Population"),
    AVG_LIFE_DURATION("Average Life Duration"),
    LIFE_QUALITY_INDEX("Life Quality Index");

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private String name;
    InformationType(String name) {
        this.name = name;
    }
}
