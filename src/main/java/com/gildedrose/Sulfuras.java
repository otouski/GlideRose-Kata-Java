package com.gildedrose;

public class Sulfuras extends ItemCategory {
    public Sulfuras(int sellIn, int quality) {
        super(GildedRose.SULFURAS,sellIn,quality);
    }

    @Override
    protected void updateAnItemQuality(Item item) {
    }
}
