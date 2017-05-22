package ua.com.codespace.entities;

import java.util.HashMap;
import java.util.Map;

public enum InformationType {
    AREA("area"),
    POPULATION("population"),
    AVG_LIFE_DURATION("average-life-duration"),
    LIFE_QUALITY_INDEX("life-quality-index");

    private final String name;
    InformationType(String name) {
        this.name = name;
    }

    private static final Map<String, InformationType> lookup = new HashMap<>();

    static {
        for (InformationType d : InformationType.values()) {
            lookup.put(d.getName(), d);
        }
    }

    public String getName() {
        return name;
    }

    public static InformationType get(String name) {
        return lookup.get(name);
    }
}
