package com.gildedrose.items;

import com.gildedrose.Item;

public abstract class AbstractGildedRoseItem implements GildedRoseItem {

	private Item item;

	public AbstractGildedRoseItem(final Item item) {
		this.setItem(item);
	}

	public Item getItem() {
		return this.item;
	}

	public void setItem(final Item item) {
		this.item = item;
	}

	@Override
	public void updateQuality() {
		decreaseSellIn();
		updateItemQuality();
	}

	public abstract void updateItemQuality();

	protected void decreaseSellIn() {
		this.getItem().sellIn = this.getItem().sellIn - 1;
	}

	protected void updateQualityBy(int updateValue) {
		updateValue = adjustQualityValueIfSellInIsPassed(this.getItem(), updateValue);
		setNewQualityValue(this.getItem(), updateValue);
		checkMinQaulityValue(this.getItem());
		checkMaxQualityValue(this.getItem());
	}

	/**********************************************
	 * PRIVATE METHODS
	 ****************************************/

	private static void setNewQualityValue(final Item item, final int updateValue) {
		item.quality = item.quality + updateValue;
	}

	/* The Quality of an item is never more than 50 */
	private static void checkMaxQualityValue(final Item item) {
		if (item.quality > 50) {
			item.quality = 50;
		}
	}

	/* The Quality of an item is never negative */
	private static void checkMinQaulityValue(final Item item) {
		if (item.quality < 0) {
			item.quality = 0;
		}
	}

	/* Once the sell by date has passed, Quality degrades twice as fast */
	private static int adjustQualityValueIfSellInIsPassed(final Item item, int updateValue) {
		if (item.sellIn < 0 && updateValue < 0) {
			updateValue = updateValue * 2;
		}
		return updateValue;
	}

}