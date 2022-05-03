package com.gildedrose;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static com.gildedrose.Utils.checkItemEqual;

public class SulfurasTest {

    @Test
    void should_Return_SellIn_One_If_SellIn_Is_One_And_Return_Quality_One_If_Quality_Is_One(){
        GildedRose gildedRose=new GildedRose(new Item[] {new Sulfuras( 1, 1) });
        gildedRose.updateQuality();
        checkItemEqual(new Sulfuras( 1, 1),gildedRose.items[0]);
    }

    @Test
    void should_Return_false_If_SellIn_After_Update_Has_Changed(){
        GildedRose gildedRose=new GildedRose(new Item[] {new Sulfuras( 0, 0) });
        gildedRose.updateQuality();
        Assertions.assertNotEquals(new Sulfuras( 1, 2).sellIn, gildedRose.items[0].sellIn);
    }

    @Test
    void should_Return_false_If_Quality_After_Update_Has_Changed(){
        GildedRose gildedRose=new GildedRose(new Item[] {new Sulfuras( 0, 0) });
        gildedRose.updateQuality();
        Assertions.assertNotEquals(new Sulfuras( 0, 2).quality, gildedRose.items[0].quality);
    }

    @Test
    void should_Not_IncreaseQuality_If_Quality_Is_50(){
        GildedRose gildedRose=new GildedRose(new Item[] {new Sulfuras( 3, 50) });
        gildedRose.updateQuality();
        checkItemEqual(new Sulfuras( 3, 50),gildedRose.items[0]);
    }

    @Test
    void should_Return_True_If_Quality_Is_Above_50(){
        GildedRose gildedRose=new GildedRose(new Item[] {new Sulfuras( 3, 60) });
        gildedRose.updateQuality();
        checkItemEqual(new Sulfuras( 3, 60),gildedRose.items[0]);
    }

    @Test
    void should_Not_DecreaseQuality(){
        GildedRose gildedRose=new GildedRose(new Item[] {new Sulfuras( 0, 50) });
        gildedRose.updateQuality();
        checkItemEqual(new Sulfuras( 0, 50),gildedRose.items[0]);
    }

}
