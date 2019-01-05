package com.gildedrose;

import com.gildedrose.items.GildedRoseItem;
import com.gildedrose.items.GildedRoseItemFactory;

class GildedRose {
	public static final String AGED_BRIE = "Aged Brie";
	public static final String BACKSTAGE_PASSES_TO_A_TAFKAL80_ETC_CONCERT = "Backstage passes to a TAFKAL80ETC concert";
	public static final String SULFURAS_HAND_OF_RAGNAROS = "Sulfuras, Hand of Ragnaros";
	public static final String CONJURED_MANA_CAKE = "Conjured Mana Cake";
	Item[] items;

	public GildedRose(Item[] items) {
		this.items = items;
	}

	public void updateQuality() {

		for (int i = 0; i < items.length; i++) {
			Item currentItem = items[i];
			GildedRoseItem gildedRoseItem = GildedRoseItemFactory.crateGildedRoseItem(currentItem);
			gildedRoseItem.updateQuality();
		}
	}

}