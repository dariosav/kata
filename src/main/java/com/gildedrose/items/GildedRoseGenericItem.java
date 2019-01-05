package com.gildedrose.items;

import com.gildedrose.Item;

public class GildedRoseGenericItem extends AbstractGildedRoseItem {

	public GildedRoseGenericItem(final Item item) {
		super(item);
	}

	@Override
	public void updateItemQuality() {
		this.updateQualityBy(-1);
	}

}
