package com.gildedrose.items;

import com.gildedrose.GildedRose;
import com.gildedrose.Item;
import com.gildedrose.ItemCategory;

public class Sulfuras extends ItemCategory {
    public Sulfuras(int sellIn, int quality) {
        super(GildedRose.SULFURAS,sellIn,quality);
    }

    @Override
    protected void updateAnItemQuality(Item item) {
        // It is never sold and quality does not degrade
    }
}
