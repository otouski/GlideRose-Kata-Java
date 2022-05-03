package com.gildedrose;

class GildedRose {
    public static final String AGED_BRIE = "Aged Brie";
    public static final String BACKSTAGE_PASSES = "Backstage passes to a TAFKAL80ETC concert";
    public static final String SULFURAS = "Sulfuras, Hand of Ragnaros";
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {
            updateAnItemQuality(item);
        }
    }

    private void updateAnItemQuality(Item item) {
        boolean isItemDecrementable=!item.name.equals(AGED_BRIE) && !item.name.equals(BACKSTAGE_PASSES) && !item.name.equals(SULFURAS);

        if (isItemDecrementable) {
            computeItemQualityChange(item, -1);
        }

        if (item.name.equals(AGED_BRIE) || item.name.equals(BACKSTAGE_PASSES)) {
            computeItemQualityChange(item, 1);
        }

        if (item.name.equals(BACKSTAGE_PASSES)) {
            if (item.sellIn < 11) {
                computeItemQualityChange(item, 1);
            }
            if (item.sellIn < 6) {
                computeItemQualityChange(item, 1);
            }
        }

        if (!item.name.equals(SULFURAS)) {
            item.sellIn = item.sellIn - 1;
        }

        if (item.sellIn < 0) {

            if (isItemDecrementable) {
                computeItemQualityChange(item, -1);
            }

            if (!item.name.equals(AGED_BRIE)) {
                if (item.name.equals(BACKSTAGE_PASSES)) {
                    item.quality = item.quality - item.quality;
                }
            } else {
                computeItemQualityChange(item, 1);
            }
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
