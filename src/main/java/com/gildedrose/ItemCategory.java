package com.gildedrose;

public class ItemCategory extends Item {

    public ItemCategory(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    protected void incrementQuality(Item item) {
        item.quality = item.quality + 1;
    }

    protected void decrementQuality(Item item) {
        item.quality = item.quality - 1;
    }

    protected void updateAnItemQuality(Item item) {

    }

    protected void updateSellIn(Item item) {

    }

    protected void updateExpiring(Item item) {

    }

}
