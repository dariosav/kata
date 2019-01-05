package com.gildedrose.items;

import com.gildedrose.Item;

public class GildedRoseAgedItem extends AbstractGildedRoseItem {

	public GildedRoseAgedItem(final Item currentItem) {
		super(currentItem);
	}

	@Override
	public void updateItemQuality() {
		updateQualityBy(1);
	}

}
