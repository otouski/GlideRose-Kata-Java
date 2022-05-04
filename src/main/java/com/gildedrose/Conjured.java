package com.gildedrose;

public class Conjured extends ItemCategory {
    public Conjured(int sellIn, int quality) {
        super(GildedRose.CONJURED,sellIn,quality);
    }

    protected void updateAnItemQuality(Item item) {

        boolean isItemExpired = isExpired(item);

        int decrement=-2;
        decrement= isItemExpired ? (decrement*2): decrement;

        computeItemQualityChange(item, decrement);

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
