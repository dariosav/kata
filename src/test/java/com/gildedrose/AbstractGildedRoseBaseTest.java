package com.gildedrose;

import static org.hamcrest.CoreMatchers.*;
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
   
    Just for clarification, an item can never have its Quality increase above 50, however "Sulfuras" is a
    legendary item and as such its Quality is 80 and it never alters.
   */
public abstract class AbstractGildedRoseBaseTest {

    public static final String AGED = "Aged";
    public static final String BACKSTAGE_PASSES = "Backstage passes";
    public static final String SULFURAS = "Sulfuras";
    public static final String CONJURED = "Conjured";

    public static final int FIRST_ITEM = 0;
    public static final int VALID_SELL_IN = 25;
    public static final int SELL_IN_EXPIRED = 0;
    public static final int SELL_IN_5_DAYS_MISSING = 5;
    public static final int SELL_IN_10_DAYS_MISSING = 10;
    public static final int VALID_QUALITY = 35;
    public static final int QUALITY_MIN_LIMIT = 0;
    public static final int QUALITY_MAX_LIMIT = 50;

    protected void assertThatItemHasExpectedValues(Item testItem ,int expectedSellIn, int expectedQuality) {

        GildedRose app = createGildeRoseWith(testItem);
        app.updateQuality();
        int itemSellIn = app.items[FIRST_ITEM].sellIn;
        int itemQuality = app.items[FIRST_ITEM].quality;
        assertThat("SellIn differ from expected", itemSellIn, is(expectedSellIn));
        assertThat("Quality differ from expected",itemQuality, is(expectedQuality));
    }

    protected GildedRose createGildeRoseWith(Item item) {
        return new GildedRose(new Item[]{item});
    }
}


