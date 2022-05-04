package com.gildedrose;

import com.gildedrose.items.BackStagePasses;
import org.junit.jupiter.api.Test;

import static com.gildedrose.Utils.checkItemEqual;

public class BackStagePassesTest {


    @Test
    void should_IncreaseQuality_By_Two_If_SellIn_Is_In_Range_6_And_10(){
        GildedRose gildedRose=new GildedRose(new Item[] {new BackStagePasses( 6, 0) });
        gildedRose.updateQuality();
        checkItemEqual(new BackStagePasses( 5, 2),gildedRose.items[0]);
    }

    @Test
    void should_IncreaseQuality_By_Three_If_SellIn_Is_In_Range_1_And_5(){
        GildedRose gildedRose=new GildedRose(new Item[] {new BackStagePasses( 5, 0) });
        gildedRose.updateQuality();
        checkItemEqual(new BackStagePasses( 4, 3),gildedRose.items[0]);
    }

    @Test
    void should_Set_Quality_To_Zero_If_SellIn_Is_Passed(){
        GildedRose gildedRose=new GildedRose(new Item[] {new BackStagePasses( 0, 0) });
        gildedRose.updateQuality();
        checkItemEqual(new BackStagePasses( -1, 0),gildedRose.items[0]);
    }

    @Test
    void should_Not_IncreaseQuality_If_Quality_Is_50(){
        GildedRose gildedRose=new GildedRose(new Item[] {new BackStagePasses( 3, 50) });
        gildedRose.updateQuality();
        checkItemEqual(new BackStagePasses( 2, 50),gildedRose.items[0]);
    }

    @Test
    void should_IncreaseQuality_By_Three_If_Quality_Is_Less_Then_0(){
        GildedRose gildedRose=new GildedRose(new Item[] {new BackStagePasses( 3, -1) });
        gildedRose.updateQuality();
        checkItemEqual(new BackStagePasses( 2, 2),gildedRose.items[0]);
    }

    @Test
    void should_Set_Quality_To_Zero_If_Quality_Is_50_And_SellIn_Is_0(){
        GildedRose gildedRose=new GildedRose(new Item[] {new BackStagePasses( 0, 50) });
        gildedRose.updateQuality();
        checkItemEqual(new BackStagePasses( -1, 0),gildedRose.items[0]);
    }
}
