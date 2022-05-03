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
        boolean isItemExpired = item.sellIn < 1;
        final int decrement = getDecrement(item, isItemExpired);
        boolean isItemDecremental=!item.name.equals(AGED_BRIE) && !item.name.equals(BACKSTAGE_PASSES) && !item.name.equals(SULFURAS);

        if (isItemDecremental) {
            computeItemQualityChange(item, decrement);
        }

        if (item.name.equals(AGED_BRIE) ) {
            int increment=isItemExpired? 2: 1;
            computeItemQualityChange(item, increment);
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
                item.quality = 0;
            }
        }

        if (!item.name.equals(SULFURAS)) {
            item.sellIn = item.sellIn - 1;
        }
    }

    private int getDecrement(Item item, boolean isItemExpired) {
        int decrement= item.name.equals(CONJURED)? -2: -1;
        decrement= isItemExpired ? (decrement*2): decrement;
        return decrement;
    }

    private void computeItemQualityChange(Item item, int increment) {
        int newItemQuality = item.quality + increment;

        boolean isInRange = newItemQuality <= 50 && newItemQuality >= 0;
        if (isInRange) {
            item.quality = newItemQuality;
        }

    }
}
