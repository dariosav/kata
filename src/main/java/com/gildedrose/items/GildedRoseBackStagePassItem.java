package com.gildedrose.items;

import com.gildedrose.Item;

public class GildedRoseBackStagePassItem extends AbstractGildedRoseItem {

	public GildedRoseBackStagePassItem(final Item item) {
		super(item);
	}

	@Override
	public void updateItemQuality() {
		if (this.getItem().sellIn >= 10) {
			this.updateQualityBy(+1);
		}
		if (this.getItem().sellIn >= 5 && this.getItem().sellIn < 10) {
			this.updateQualityBy(+2);
		}
		if (this.getItem().sellIn >= 0 && this.getItem().sellIn < 5) {
			this.updateQualityBy(+3);
		}
		if (this.getItem().sellIn < 0) {
			this.updateQualityBy(-this.getItem().quality);
		}
	}

}
