package com.gildedrose;

class GildedRose {
    public static final String AGED_BRIE = "Aged Brie";
    public static final String BACKSTAGE_PASSES = "Backstage passes to a TAFKAL80ETC concert";
    public static final String SULFURAS = "Sulfuras, Hand of Ragnaros";
    public static final String CONJURED = "Conjured Mana Cake";
    public static final String DEXTERITY = "+5 Dexterity Vest";
    public static final String ELIXIR = "Elixir of the Mongoose";
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {
            ItemCategory.categorize(item).updateAnItemQuality(item);
//            if(item instanceof AgedBrie || item instanceof BackStagePasses || item instanceof Sulfuras || item instanceof Conjured){
//
//            }else{
//                updateAnItemQuality(item);
//            }
        }
    }


}
