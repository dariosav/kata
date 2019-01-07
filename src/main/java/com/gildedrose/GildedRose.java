package com.gildedrose;

import com.gildedrose.items.GildedRoseItem;
import com.gildedrose.items.GildedRoseItemFactory;

class GildedRose {

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
