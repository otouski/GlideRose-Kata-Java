package com.gildedrose;

public class ItemCategory extends Item {

    public ItemCategory(String name,int sellIn, int quality) {
        super(name, sellIn, quality);
    }


    public static ItemCategory categorize(Item item) {
        if (item instanceof AgedBrie) {
            return new AgedBrie(item.sellIn,item.quality);
        }
        return  new RegularItem(item.name,item.sellIn,item.quality);
    }

    protected boolean isExpired(Item item) {
        return item.sellIn < 1;
    }

    protected void updateSellIn(Item item) {
        item.sellIn = item.sellIn - 1;
    }

    protected void updateAnItemQuality(Item item) {
    }

}
