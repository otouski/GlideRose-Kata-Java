package com.gildedrose;

import org.junit.jupiter.api.Test;

import static com.gildedrose.Utils.checkItemEqual;

public class AgedBrieTest {

    final static String itemName=GildedRose.AGED_BRIE;

    @Test
    void should_IncreaseQuality_By_One_If_SellIn_Is_In_Range(){
        GildedRose gildedRose=new GildedRose(new Item[] {new Item(itemName, 2, 0) });
        gildedRose.updateQuality();
        checkItemEqual(new Item(itemName, 1, 1),gildedRose.items[0]);
    }

    @Test
    void should_IncreaseQuality_By_Two_If_SellIn_Is_Passed(){
        GildedRose gildedRose=new GildedRose(new Item[] {new Item(itemName, 0, 0) });
        gildedRose.updateQuality();
        checkItemEqual(new Item(itemName, -1, 2),gildedRose.items[0]);
    }

    @Test
    void should_Not_IncreaseQuality_If_Quality_Is_50(){
        GildedRose gildedRose=new GildedRose(new Item[] {new Item(itemName, 3, 50) });
        gildedRose.updateQuality();
        checkItemEqual(new Item(itemName, 2, 50),gildedRose.items[0]);
    }

    @Test
    void should_Set_Quality_To_Zero_If_Quality_Is_Less_Then_0(){
        GildedRose gildedRose=new GildedRose(new Item[] {new Item(itemName, 3, -1) });
        gildedRose.updateQuality();
        checkItemEqual(new Item(itemName, 2, 0),gildedRose.items[0]);
    }

    @Test
    void should_Not_IncreaseQuality_If_Quality_Is_50_And_SellIn_Is_0(){
        GildedRose gildedRose=new GildedRose(new Item[] {new Item(itemName, 0, 50) });
        gildedRose.updateQuality();
        checkItemEqual(new Item(itemName, -1, 50),gildedRose.items[0]);
    }


}
