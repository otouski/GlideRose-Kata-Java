package com.gildedrose;

public class AgedBrie extends ItemCategory {
    public AgedBrie(int sellIn, int quality) {
        super(GildedRose.AGED_BRIE,sellIn,quality);
    }

    @Override
    protected void updateAnItemQuality(Item item) {
        increment(item);
        if(isExpired(item)){
            increment(item);
        }
        updateSellIn(item);
    }
}
