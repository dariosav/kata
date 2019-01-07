package com.gildedrose;

import java.util.Arrays;

import com.gildedrose.items.GildedRoseItem;
import com.gildedrose.items.GildedRoseItemFactory;

class GildedRose {

	Item[] items;

	public GildedRose(Item[] items) {
		this.items = items;
	}

	public void updateQuality() {
		Arrays
			.stream(this.items)
			.map(GildedRoseItemFactory::crateGildedRoseItem)
			.forEach(GildedRoseItem::updateQuality);
	}

}
