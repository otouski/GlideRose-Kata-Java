package com.gildedrose;

class GildedRose {
    public static final String AGED_BRIE = "Aged Brie";
    public static final String BACKSTAGE_PASSES = "Backstage passes to a TAFKAL80ETC concert";
    public static final String SULFURAS = "Sulfuras, Hand of Ragnaros";
    public static final String CONJURED = "Conjured Mana Cake";
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

        int decrement=item.name.equals(CONJURED)? -2: -1;
        boolean isItemDecremental=!item.name.equals(AGED_BRIE) && !item.name.equals(BACKSTAGE_PASSES) && !item.name.equals(SULFURAS);
        boolean isItemExpired = item.sellIn < 1;

        if (isItemDecremental) {
            computeItemQualityChange(item, decrement);

            if (isItemExpired) {
                computeItemQualityChange(item, decrement);
            }
        }

        if (item.name.equals(AGED_BRIE) ) {
            computeItemQualityChange(item, 1);
            if (isItemExpired) {
                computeItemQualityChange(item, 1);
            }
        }

        if (item.name.equals(BACKSTAGE_PASSES)) {
            computeItemQualityChange(item, 1);
            if (item.sellIn < 11) {
                computeItemQualityChange(item, 1);
            }
            if (item.sellIn < 6) {
                computeItemQualityChange(item, 1);
            }
            if (isItemExpired) {
                item.quality = item.quality - item.quality;
            }
        }

        if (!item.name.equals(SULFURAS)) {
            item.sellIn = item.sellIn - 1;
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
