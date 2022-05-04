package com.gildedrose;

public class Elixir extends ItemCategory {

    public Elixir( int sellIn, int quality) {
        super(GildedRose.ELIXIR, sellIn, quality);
    }

    protected void updateAnItemQuality(Item item) {

    }
}
