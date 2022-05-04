package com.gildedrose.items;

import com.gildedrose.GildedRose;
import com.gildedrose.Item;
import com.gildedrose.ItemCategory;

public class AgedBrie extends ItemCategory {
    public AgedBrie(int sellIn, int quality) {
        super(GildedRose.AGED_BRIE,sellIn,quality);
    }

    @Override
    protected void updateAnItemQuality(Item item) {
        // increment quality
        increment(item);

        // increment quality once again if item is expired
        if(isExpired(item)){
            increment(item);
        }

        // update sellIn day
        updateSellIn(item);
    }
}
