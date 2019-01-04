package com.gildedrose;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.Matchers.greaterThanOrEqualTo;
import static org.hamcrest.Matchers.lessThanOrEqualTo;
import static org.junit.Assert.*;


/*   Pretty simple, right? Well this is where it gets interesting:

    - Once the sell by date has passed, Quality degrades twice as fast
    - The Quality of an item is never negative
    - "Aged Brie" actually increases in Quality the older it gets
    - The Quality of an item is never more than 50
    - "Sulfuras", being a legendary item, never has to be sold or decreases in Quality
    - "Backstage passes", like aged brie, increases in Quality as its SellIn value approaches;
    Quality increases by 2 when there are 10 days or less and by 3 when there are 5 days or less but
    Quality drops to 0 after the concert

    We have recently signed a supplier of conjured items. This requires an update to our system:

   - "Conjured" items degrade in Quality twice as fast as normal items
   */
public abstract class AbstractGildedRoseBaseTest {

    public static final String AGED = "Aged";
    public static final String BACKSTAGE_PASSES = "Backstage passes";
    public static final String SULFURAS = "Sulfuras";
    public static final String CONJURED = "Conjured";

    public static final int SELL_IN_LAST_DAY = 0;
    public static final int FIRST_ITEM = 0;
    public static final int QUALITY_MIN_LIMIT = 0;
    public static final int QUALITY_MAX_LIMIT = 50;

    protected void assertThatItemHasExpectedValues(Item testItem ,int expectedSellIn, int expectedQuality) {

        GildedRose app = createGildeRoseWith(testItem);
        app.updateQuality();
        int itemSellIn = app.items[FIRST_ITEM].sellIn;
        int itemQuality = app.items[FIRST_ITEM].quality;
        assertThat(itemSellIn, is(expectedSellIn));
        assertThat(itemQuality, is(expectedQuality));
    }

    protected GildedRose createGildeRoseWith(Item item) {
        return new GildedRose(new Item[]{item});
    }

    protected void assertThatQualityIsNotNegative(int itemQuality) {
        assertThat(itemQuality, is(greaterThanOrEqualTo(QUALITY_MIN_LIMIT)));
    }

    protected void assertThatQualityIsNotMoreThan50(int itemQuality) {
        assertThat(itemQuality, is(lessThanOrEqualTo(QUALITY_MAX_LIMIT)));
    }
}


