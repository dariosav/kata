package com.gildedrose;

import org.junit.Test;

/*
    - The Quality of an item is never negative
    - The Quality of an item is never more than 50
    - "Backstage passes", like aged brie, increases in Quality as its SellIn value approaches;
    Quality increases by 2 when there are 10 days or less and by 3 when there are 5 days or less but
    Quality drops to 0 after the concert

   */
public class GildedRoseBackStagePassItemTest extends AbstractGildedRoseBaseTest {

    public static final String BACKSTAGE_PASS_ITEM_NAME = "Backstage passes to a TAFKAL80ETC concert";

    @Test
    public void updateQualityItemTest() {
        Item genericItem = new Item(BACKSTAGE_PASS_ITEM_NAME, VALID_SELL_IN, VALID_QUALITY);
        assertThatItemHasExpectedValues(genericItem, VALID_SELL_IN - 1, VALID_QUALITY + 1);
    }

    @Test
    public void updateQualityWhenSellInIsPassedTest() {
        Item genericItem = new Item(BACKSTAGE_PASS_ITEM_NAME, SELL_IN_EXPIRED, VALID_QUALITY);
        assertThatItemHasExpectedValues(genericItem, SELL_IN_EXPIRED - 1, QUALITY_MIN_LIMIT);
    }

    @Test
    public void updateQualityWhen10DaysAreMissingTest() {
        Item genericItem = new Item(BACKSTAGE_PASS_ITEM_NAME, SELL_IN_10_DAYS_MISSING, VALID_QUALITY);
        assertThatItemHasExpectedValues(genericItem, SELL_IN_10_DAYS_MISSING - 1, VALID_QUALITY + 2);
    }

    @Test
    public void updateQualityWhen5DaysAreMissingTest() {
        Item genericItem = new Item(BACKSTAGE_PASS_ITEM_NAME, SELL_IN_5_DAYS_MISSING, VALID_QUALITY);
        assertThatItemHasExpectedValues(genericItem, SELL_IN_5_DAYS_MISSING - 1, VALID_QUALITY + 3);
    }

    @Test
    public void updateQualityWhenMaxQualityReachedTest() {
        Item genericItem = new Item(BACKSTAGE_PASS_ITEM_NAME, VALID_SELL_IN, QUALITY_MAX_LIMIT);
        assertThatItemHasExpectedValues(genericItem, VALID_SELL_IN - 1, QUALITY_MAX_LIMIT);
    }

    @Test
    public void updateQualityWhen5DaysAreMissingAndMaxQualityReachedTest() {
        Item genericItem = new Item(BACKSTAGE_PASS_ITEM_NAME, SELL_IN_5_DAYS_MISSING, QUALITY_MAX_LIMIT);
        assertThatItemHasExpectedValues(genericItem, SELL_IN_5_DAYS_MISSING - 1, QUALITY_MAX_LIMIT);
    }
}


