package com.gildedrose.items;

import com.gildedrose.Item;

public class GildedRoseSulfurasItem extends AbstractGildedRoseItem {

	public GildedRoseSulfurasItem(final Item currentItem) {
		super(currentItem);
	}

	@Override
	public void updateQuality() {
		// Do nothing: "Sulfuras", being a legendary item, never has to be sold or decreases in Quality
	}

	@Override
	public void updateItemQuality() {
		// Do nothing: "Sulfuras", being a legendary item, never has to be sold or decreases in Quality
	}

}