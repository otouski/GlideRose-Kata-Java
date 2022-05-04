package com.gildedrose.items;

import com.gildedrose.GildedRose;
import com.gildedrose.Item;
import com.gildedrose.ItemCategory;

public class Conjured extends ItemCategory {
    public Conjured(int sellIn, int quality) {
        super(GildedRose.CONJURED,sellIn,quality);
    }

    @Override
    protected void updateAnItemQuality(Item item) {

        // decrement quality twice
        decrement(item);
        decrement(item);

        // decrement quality twice again if item is expired
        if(isExpired(item)){
            decrement(item);
            decrement(item);
        }

        // update sellIn day
        updateSellIn(item);
    }

}
