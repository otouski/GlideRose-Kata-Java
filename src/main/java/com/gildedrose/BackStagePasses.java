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
        computeItemQualityChange(item, 1);
        if (item.sellIn < 11) {
            computeItemQualityChange(item, 1);
        }
        if (item.sellIn < 6) {
            computeItemQualityChange(item, 1);
        }
        if (isItemExpired) {
            item.quality = 0;
        }
    }

    private void computeItemQualityChange(Item item, int increment) {
        int newItemQuality = item.quality + increment;

        boolean isInRange = newItemQuality <= 50 && newItemQuality >= 0;
        if (isInRange) {
            item.quality = newItemQuality;
        }
    }
}
