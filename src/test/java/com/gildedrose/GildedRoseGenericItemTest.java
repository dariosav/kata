package com.gildedrose;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/*
* Test class for geneirc Items
*        assertThat(itemName, not(anyOf(
*            containsString(AGED),
*            containsString(BACKSTAGE_PASSES),
*            containsString(SULFURAS),
*            containsString(CONJURED)
*        )));
* */
public class GildedRoseGenericItemTest extends AbstractGildedRoseBaseTest {

    public static final String GENERIC_ITEM_NAME = "Iron gauntlets";
    public static final int QUALITY_20 = 20;
    public static final int GENERIC_ITEM_SELL_IN = 35;

    @Test
    public void updateQualityOnGenericItemTest() {

        Item genericItem = new Item(GENERIC_ITEM_NAME, GENERIC_ITEM_SELL_IN, QUALITY_20);
        assertThatItemHasExpectedValues(genericItem,34,19);
    }

    @Test
    public void updateQualityWhenSellInIsPassedTest() {
        Item genericItem = new Item(GENERIC_ITEM_NAME, SELL_IN_LAST_DAY, QUALITY_20);
        assertThatItemHasExpectedValues(genericItem,-1,18);
    }


}


