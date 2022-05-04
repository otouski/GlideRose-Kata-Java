package com.gildedrose;

public class AgedBrie extends ItemCategory {
    public AgedBrie(int sellIn, int quality) {
        super(GildedRose.AGED_BRIE,sellIn,quality);
    }

    @Override
    protected void updateAnItemQuality(Item item) {

        boolean isItemExpired = isExpired(item);

        int increment=isItemExpired? 2: 1;
        computeItemQualityChange(item, increment);

        updateSellIn(item);
    }

    private void computeItemQualityChange(Item item, int increment) {
        int newItemQuality = item.quality + increment;

        boolean isInRange = newItemQuality <= 50 && newItemQuality >= 0;
        if (isInRange) {
            item.quality = newItemQuality;
        }
    }
}
