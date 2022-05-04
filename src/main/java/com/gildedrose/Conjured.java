package com.gildedrose;

public class Conjured extends ItemCategory {
    public Conjured(int sellIn, int quality) {
        super(GildedRose.CONJURED,sellIn,quality);
    }

    @Override
    protected void updateAnItemQuality(Item item) {

        if(isExpired(item)){
            decrement(item);
            decrement(item);
        }
        decrement(item);
        decrement(item);

        updateSellIn(item);
    }

}
