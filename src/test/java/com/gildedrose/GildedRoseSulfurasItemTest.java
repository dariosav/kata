package com.gildedrose;

import org.junit.Test;


/*   Pretty simple, right? Well this is where it gets interesting:

    - Once the sell by date has passed, Quality degrades twice as fast
    - The Quality of an item is never negative
    - The Quality of an item is never more than 50
    - "Sulfuras", being a legendary item, never has to be sold or decreases in Quality
      Just for clarification, an item can never have its Quality increase above 50, however "Sulfuras" is a
      legendary item and as such its Quality is 80 and it never alters.
   */
public class GildedRoseSulfurasItemTest extends AbstractGildedRoseBaseTest {

    public static final String LEGENDARY_ITEM_NAME = "Sulfuras, Hand of Ragnaros";
    public static final int QUALITY_OF_SULFURAS = 80;


    @Test
    public void updateQualityItemTest() {
        Item genericItem = new Item(LEGENDARY_ITEM_NAME, VALID_SELL_IN, QUALITY_OF_SULFURAS);
        assertThatItemHasExpectedValues(genericItem, VALID_SELL_IN, QUALITY_OF_SULFURAS);
    }

    @Test
    public void updateQualityWhenSellInIsPassedTest() {
        Item genericItem = new Item(LEGENDARY_ITEM_NAME, SELL_IN_EXPIRED, QUALITY_OF_SULFURAS);
        assertThatItemHasExpectedValues(genericItem, SELL_IN_EXPIRED, QUALITY_OF_SULFURAS);
    }


}


