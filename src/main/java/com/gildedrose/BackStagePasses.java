package com.gildedrose;

public class BackStagePasses extends ItemCategory {
    public BackStagePasses(int sellIn, int quantity) {
        super(GildedRose.BACKSTAGE_PASSES,sellIn,quantity);
    }

    @Override
    protected void updateAnItemQuality(Item item) {
        boolean isItemExpired = isExpired(item);
        updateQuality(item, isItemExpired);
        updateSellIn(item);
    }

    private void updateQuality(Item item, boolean isItemExpired) {
        increment(item);
        if (item.sellIn < 11) {
            increment(item);
        }
        if (item.sellIn < 6) {
            increment(item);
        }
        if (isItemExpired) {
            item.quality = 0;
        }
    }

}
