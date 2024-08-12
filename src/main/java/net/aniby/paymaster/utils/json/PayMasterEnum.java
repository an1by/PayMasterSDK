package net.aniby.paymaster.utils.json;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public interface PayMasterEnum {
    String name();


    default ArrayList<String> variants() {
        return defaultVariants();
    }

    private ArrayList<String> defaultVariants() {
        String defaultVariant = name();
        String lowerCased = name().toLowerCase();
        String capitalized = Arrays.stream(name().toLowerCase().split("_"))
                .map((s) -> s.substring(0, 1).toUpperCase() + s.substring(1))
                .collect(Collectors.joining(""));
        String together = capitalized.toLowerCase();
        return new ArrayList<>(List.of(
                defaultVariant,
                lowerCased,
                capitalized,
                together
        ));
    }
}
