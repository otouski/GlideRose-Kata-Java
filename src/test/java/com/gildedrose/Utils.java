package com.gildedrose;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Utils {

    public static void checkItemEqual(Item expected, Item actual){
        assertEquals(expected.name, actual.name);
        assertEquals(expected.quality, actual.quality);
        assertEquals(expected.sellIn, actual.sellIn);
    }
}
