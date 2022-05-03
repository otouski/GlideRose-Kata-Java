package com.gildedrose;

import org.junit.jupiter.api.Test;

import static com.gildedrose.Utils.checkItemEqual;

public class ConjuredTest {


    @Test
    void should_DecreaseQuality_By_Two_If_SellIn_Is_In_Range(){

        GildedRose gildedRose=new GildedRose(new Item[] {new Conjured(5,6)});
        gildedRose.updateQuality();
        checkItemEqual(new Conjured( 4, 4),gildedRose.items[0]);
    }


    @Test
    void should_DecreaseQuality_By_Four_If_SellIn_Is_Less_Then_Zero(){

        GildedRose gildedRose=new GildedRose(new Item[] {new Conjured(0,6)});
        gildedRose.updateQuality();
        checkItemEqual(new Conjured( -1, 2),gildedRose.items[0]);
    }

    @Test
    void should_Set_Quality_To_Zero_If_Quality_Is_Less_Then_0(){
        GildedRose gildedRose=new GildedRose(new Item[] {new Conjured(3, 0) });
        gildedRose.updateQuality();
        checkItemEqual(new Conjured( 2, 0),gildedRose.items[0]);
    }


}
