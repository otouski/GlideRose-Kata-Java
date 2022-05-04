package com.gildedrose;

public class ItemCategory extends Item {

    public ItemCategory(String name,int sellIn, int quality) {
        super(name, sellIn, quality);
    }


    public static ItemCategory categorize(Item item) {
        if (item instanceof AgedBrie ) {
            return new AgedBrie(item.sellIn,item.quality);
        } else if(item instanceof BackStagePasses){
            return new BackStagePasses(item.sellIn,item.quality);
        } else if(item instanceof Sulfuras){
            return new Sulfuras(item.sellIn,item.quality);
        } else if(item instanceof Conjured){
            return new Conjured(item.sellIn,item.quality);
        }
        return  new RegularItem(item.name,item.sellIn,item.quality);
    }

    protected boolean isExpired(Item item) {
        return item.sellIn < 1;
    }

    protected void updateSellIn(Item item) {
        item.sellIn = item.sellIn - 1;
    }

    protected void increment(Item item) {
        if(item.quality < 50){
            item.quality = item.quality + 1;
        }
    }

    protected void decrement(Item item) {
        if(item.quality > 0){
            item.quality = item.quality - 1;
        }
    }

    protected void updateAnItemQuality(Item item) {
        // Method implemented by sub classes
    }

}
