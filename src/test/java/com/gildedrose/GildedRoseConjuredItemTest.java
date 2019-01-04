package com.gildedrose;

import org.junit.Test;

/*   Pretty simple, right? Well this is where it gets interesting:

    - Once the sell by date has passed, Quality degrades twice as fast
    - The Quality of an item is never negative
    - The Quality of an item is never more than 50
    We have recently signed a supplier of conjured items. This requires an update to our system:

   - "Conjured" items degrade in Quality twice as fast as normal items
   */
public class GildedRoseConjuredItemTest extends AbstractGildedRoseBaseTest {

    public static final String CONJURED_ITEM_NAME = "Conjured Mana Cake";

    @Test
    public void updateQualityItemTest() {
        Item genericItem = new Item(CONJURED_ITEM_NAME, VALID_SELL_IN, VALID_QUALITY);
        assertThatItemHasExpectedValues(genericItem, VALID_SELL_IN - 1, VALID_QUALITY - 2);
    }

    @Test
    public void updateQualityWhenSellInIsPassedTest() {
        Item genericItem = new Item(CONJURED_ITEM_NAME, SELL_IN_EXPIRED, VALID_QUALITY);
        assertThatItemHasExpectedValues(genericItem, SELL_IN_EXPIRED - 1, VALID_QUALITY - 4);
    }

    @Test
    public void updateQualityNeverNegativeTest() {
        Item genericItem = new Item(CONJURED_ITEM_NAME, SELL_IN_EXPIRED, QUALITY_MIN_LIMIT);
        assertThatItemHasExpectedValues(genericItem, SELL_IN_EXPIRED - 1, QUALITY_MIN_LIMIT);
    }



}


