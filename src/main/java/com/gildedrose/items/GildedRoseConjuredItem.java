package com.gildedrose.items;

import com.gildedrose.Item;

public class GildedRoseConjuredItem extends AbstractGildedRoseItem {

	public GildedRoseConjuredItem(final Item item) {
		super(item);
	}

	@Override
	public void updateItemQuality() {
		this.updateQualityBy(-2);
	}

}
