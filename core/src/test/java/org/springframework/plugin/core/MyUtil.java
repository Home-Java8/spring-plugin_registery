package org.springframework.plugin.core;

import java.util.ArrayList;
import java.util.List;

public class MyUtil {

    public static final String COMPONENT_1 = "component-1",
            COMPONENT_2 = "component-2",
            COMPONENT_3 = "component-3";

    public static final List<String> components = new ArrayList<>();

    static {
        components.add(COMPONENT_1);
        components.add(COMPONENT_2);
        components.add(COMPONENT_3);
    }
}
