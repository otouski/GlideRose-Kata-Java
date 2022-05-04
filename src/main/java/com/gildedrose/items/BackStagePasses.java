package com.gildedrose.items;

import com.gildedrose.GildedRose;
import com.gildedrose.Item;
import com.gildedrose.ItemCategory;

public class BackStagePasses extends ItemCategory {
    public BackStagePasses(int sellIn, int quantity) {
        super(GildedRose.BACKSTAGE_PASSES,sellIn,quantity);
    }

    @Override
    protected void updateAnItemQuality(Item item) {
        updateQuality(item);

        // update sellIn day
        updateSellIn(item);
    }

    private void updateQuality(Item item) {

        // increment quality
        increment(item);
        if (item.sellIn < 11) {
            // increment quality once again if sellIn is less than 11 days
            increment(item);
        }
        if (item.sellIn < 6) {
            // increment quality once again if sellIn is less than 6 days
            increment(item);
        }

        // quality drop to 0 if item is expired
        if (isExpired(item)) {
            item.quality = 0;
        }
    }

}
