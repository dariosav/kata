package com.gildedrose;

import org.junit.Test;


/*
    - Once the sell by date has passed, Quality degrades twice as fast
    - The Quality of an item is never negative
    - The Quality of an item is never more than 50

* Test class for generic Items
*        assertThat(itemName, not(anyOf(
*            containsString(AGED),
*            containsString(BACKSTAGE_PASSES),
*            containsString(SULFURAS),
*            containsString(CONJURED)
*        )));
* */
public class GildedRoseGenericItemTest extends AbstractGildedRoseBaseTest {

    public static final String GENERIC_ITEM_NAME = "Iron gauntlets";

    @Test
    public void updateQualityItemTest() {
        Item genericItem = new Item(GENERIC_ITEM_NAME, VALID_SELL_IN, VALID_QUALITY);
        assertThatItemHasExpectedValues(genericItem, VALID_SELL_IN - 1, VALID_QUALITY - 1);
    }

    @Test
    public void updateQualityWhenSellInIsPassedTest() {
        Item genericItem = new Item(GENERIC_ITEM_NAME, SELL_IN_EXPIRED, VALID_QUALITY);
        assertThatItemHasExpectedValues(genericItem, SELL_IN_EXPIRED - 1, VALID_QUALITY - 2);
    }

    @Test
    public void updateQualityNeverNegativeTest() {
        Item genericItem = new Item(GENERIC_ITEM_NAME, SELL_IN_EXPIRED, QUALITY_MIN_LIMIT);
        assertThatItemHasExpectedValues(genericItem, SELL_IN_EXPIRED - 1, QUALITY_MIN_LIMIT);
    }

}


