package com.gildedrose;


import com.gildedrose.items.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TextTestFixture {
    public static void main(String[] args) {

        Item[] items = new Item[] {
                new RegularItem(GildedRose.DEXTERITY, 10, 20), //
                new AgedBrie( 2, 0), //
                new RegularItem(GildedRose.ELIXIR,  5, 7), //
                new Sulfuras( 0, 80), //
                new Sulfuras(-1, 80),
                new BackStagePasses(15, 20),
                new BackStagePasses( 10, 49),
                new BackStagePasses( 5, 49),
                // this conjured item does not work properly yet
                new Conjured( 3, 6) };

        GildedRose app = new GildedRose(items);

        int days = 2;
        for (int i = 0; i < days; i++) {
            System.out.println("-------- day " + i + " --------");
            System.out.println("name, sellIn, quality");
            for (Item item : items) {
                System.out.println(item);
            }
            System.out.println();
            app.updateQuality();
        }

    }

}
