package com.gildedrose;

public class RegularItem extends ItemCategory{
    public RegularItem(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    protected void updateAnItemQuality(Item item) {

        if(isExpired(item)){
            decrement(item);
        }
        decrement(item);
        updateSellIn(item);
    }
}
