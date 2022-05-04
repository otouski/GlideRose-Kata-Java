package com.gildedrose.items;

import com.gildedrose.Item;
import com.gildedrose.ItemCategory;

public class RegularItem extends ItemCategory {
    public RegularItem(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    protected void updateAnItemQuality(Item item) {

        // decrement quality
        decrement(item);

        // decrement quality once again if item is expired
        if(isExpired(item)){
            decrement(item);
        }

        // update sellIn days
        updateSellIn(item);
    }
}
