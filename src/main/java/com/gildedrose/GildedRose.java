package com.gildedrose;

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

			switch (currentItem.name) {
			case SULFURAS_HAND_OF_RAGNAROS:
				break;
			case AGED_BRIE:
			case BACKSTAGE_PASSES_TO_A_TAFKAL80_ETC_CONCERT:
			case CONJURED_MANA_CAKE:
			default:
				decreaseSellIn(currentItem);
			}

			switch (currentItem.name) {
			case SULFURAS_HAND_OF_RAGNAROS:
				break;
			case AGED_BRIE:
				updateQualityBy(currentItem, 1);
				break;
			case BACKSTAGE_PASSES_TO_A_TAFKAL80_ETC_CONCERT:
				if (currentItem.sellIn >= 10) {
					updateQualityBy(currentItem, +1);
				}
				if (currentItem.sellIn >= 5 && currentItem.sellIn < 10) {
					updateQualityBy(currentItem, +2);
				}
				if (currentItem.sellIn >= 0 && currentItem.sellIn < 5) {
					updateQualityBy(currentItem, +3);
				}
				if (currentItem.sellIn < 0) {
					updateQualityBy(currentItem, -currentItem.quality);
				}
				break;
			case CONJURED_MANA_CAKE:

				break;
			default:
				updateQualityBy(currentItem, -1);
			}

		}
	}

	private void updateQualityBy(Item currentItem, int updateValue) {
		updateValue = adjustQualityValueIdSellInIsPassed(currentItem, updateValue);
		setNewQualityValue(currentItem, updateValue);
		checkMinQaulityValue(currentItem);
		checkMaxQualityValue(currentItem);
	}

	private void setNewQualityValue(Item currentItem, int updateValue) {
		currentItem.quality = currentItem.quality + updateValue;
	}

	/*  The Quality of an item is never more than 50 */
	private void checkMaxQualityValue(Item currentItem) {
		if (currentItem.quality > 50) {
			currentItem.quality = 50;
		}
	}

	/* The Quality of an item is never negative */
	private void checkMinQaulityValue(Item currentItem) {
		if (currentItem.quality < 0) {
			currentItem.quality = 0;
		}
	}

    /* Once the sell by date has passed, Quality degrades twice as fast */
	private int adjustQualityValueIdSellInIsPassed(Item currentItem, int updateValue) {
		if (currentItem.sellIn < 0 && updateValue < 0) {
			updateValue = updateValue * 2;
		}
		return updateValue;
	}

	private void decreaseSellIn(Item currentItem) {
		currentItem.sellIn = currentItem.sellIn - 1;
	}
}