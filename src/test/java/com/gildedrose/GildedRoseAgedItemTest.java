package com.gildedrose;

import org.junit.Test;

/*
    - "Aged Brie" actually increases in Quality the older it gets
    - The Quality of an item is never more than 50
   */
public class GildedRoseAgedItemTest extends AbstractGildedRoseBaseTest {

    public static final String AGED_ITEM_NAME = "Aged Brie";

    @Test
    public void updateQualityTest() {

        Item genericItem = new Item(AGED_ITEM_NAME, VALID_SELL_IN, VALID_QUALITY);
        assertThatItemHasExpectedValues(genericItem,VALID_SELL_IN - 1, VALID_QUALITY + 1);
    }

    @Test
    public void updateQualityWhenSellInIsPassedTest() {
        //TO BE FIXED: not working before refactoring
        Item genericItem = new Item(AGED_ITEM_NAME, SELL_IN_EXPIRED, VALID_QUALITY);
        assertThatItemHasExpectedValues(genericItem, SELL_IN_EXPIRED - 1, VALID_QUALITY + 1);
    }

    @Test
    public void updateQualityWhenMaxQualityReachedTest() {
        Item genericItem = new Item(AGED_ITEM_NAME, VALID_SELL_IN, QUALITY_MAX_LIMIT);
        assertThatItemHasExpectedValues(genericItem,VALID_SELL_IN - 1, QUALITY_MAX_LIMIT);
    }

}


