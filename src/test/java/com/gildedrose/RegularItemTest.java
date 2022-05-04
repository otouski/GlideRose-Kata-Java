package com.gildedrose;

import com.gildedrose.items.RegularItem;
import org.junit.jupiter.api.Test;

import static com.gildedrose.Utils.checkItemEqual;

public class RegularItemTest {


    @Test
    void should_DecreaseQuality_By_One_If_SellIn_Is_In_Range(){

        GildedRose gildedRose=new GildedRose(new Item[] {new RegularItem(GildedRose.ELIXIR,5,6)});
        gildedRose.updateQuality();
        checkItemEqual(new RegularItem(GildedRose.ELIXIR, 4, 5),gildedRose.items[0]);
    }


    @Test
    void should_DecreaseQuality_By_Two_If_SellIn_Is_Less_Then_Zero(){

        GildedRose gildedRose=new GildedRose(new Item[] {new RegularItem(GildedRose.ELIXIR,0,6)});
        gildedRose.updateQuality();
        checkItemEqual(new RegularItem(GildedRose.ELIXIR, -1, 4),gildedRose.items[0]);
    }

    @Test
    void should_Set_Quality_To_Zero_If_Quality_Is_Less_Then_0(){
        GildedRose gildedRose=new GildedRose(new Item[] {new RegularItem(GildedRose.ELIXIR,3, 0) });
        gildedRose.updateQuality();
        checkItemEqual(new RegularItem(GildedRose.ELIXIR, 2, 0),gildedRose.items[0]);
    }


}
