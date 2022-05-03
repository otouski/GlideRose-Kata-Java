package com.gildedrose;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TexttestFixture {
    public static void main(String[] args) {
        System.out.println("OMGHAI!");

        Item[] items = new Item[] {
                new Item("+5 Dexterity Vest", 10, 20), //
                new AgedBrie( 2, 0), //
                new Item("Elixir of the Mongoose", 5, 7), //
                new Sulfuras( 0, 80), //
                new Sulfuras(-1, 80),
                new BackStagePasses(15, 20),
                new BackStagePasses( 10, 49),
                new BackStagePasses( 5, 49),
                // this conjured item does not work properly yet
                new Conjured( 3, 6) };

        GildedRose app = new GildedRose(items);

        int days = 2;
        if (args.length > 0) {
            days = Integer.parseInt(args[0]) + 1;
        }

//        for (int i = 0; i < days; i++) {
//            System.out.println("-------- day " + i + " --------");
//            System.out.println("name, sellIn, quality");
//            for (Item item : items) {
//                System.out.println(item);
//            }
//            System.out.println();
//            app.updateQuality();
//        }


        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < days; i++) {
            for (Item item : items) {
                //System.out.println(item);
                builder.append(item).append(System.getProperty("line.separator"));
            }
            //System.out.println();
            app.updateQuality();
        }

        System.out.println(builder);
        System.out.println("------------------");

        String expected= """
            +5 Dexterity Vest, 10, 20
            Aged Brie, 2, 0
            Elixir of the Mongoose, 5, 7
            Sulfuras, Hand of Ragnaros, 0, 80
            Sulfuras, Hand of Ragnaros, -1, 80
            Backstage passes to a TAFKAL80ETC concert, 15, 20
            Backstage passes to a TAFKAL80ETC concert, 10, 49
            Backstage passes to a TAFKAL80ETC concert, 5, 49
            Conjured Mana Cake, 3, 6
            +5 Dexterity Vest, 9, 19
            Aged Brie, 1, 1
            Elixir of the Mongoose, 4, 6
            Sulfuras, Hand of Ragnaros, 0, 80
            Sulfuras, Hand of Ragnaros, -1, 80
            Backstage passes to a TAFKAL80ETC concert, 14, 21
            Backstage passes to a TAFKAL80ETC concert, 9, 50
            Backstage passes to a TAFKAL80ETC concert, 4, 50
            Conjured Mana Cake, 2, 4
            """;

        System.out.println(expected);
        System.out.println("------------------");
        System.out.println("------------------");

        assertEquals(builder.toString(),expected);
    }

}
