package com.gildedrose.helpers;

import com.gildedrose.Item;

public class ItemHelper {
	public static void updateGenericItem(Item currentItem) {
		updateQualityBy(currentItem, -1);
	}

	public static void updateConjuredItemQauality(Item currentItem) {
		updateQualityBy(currentItem, -2);
	}

	public static void updateBackStagePassItemQuality(Item currentItem) {
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
	}
	
	public static void updateAgedItemQuality(Item currentItem) {
		updateQualityBy(currentItem, 1);
	}
	
	public static void decreaseSellIn(Item currentItem) {
		currentItem.sellIn = currentItem.sellIn - 1;
	}
	
	/********************************************** PRIVATE METHODS ****************************************/
	
	private static void updateQualityBy(Item currentItem, int updateValue) {
		updateValue = adjustQualityValueIfSellInIsPassed(currentItem, updateValue);
		setNewQualityValue(currentItem, updateValue);
		checkMinQaulityValue(currentItem);
		checkMaxQualityValue(currentItem);
	}

	private static void setNewQualityValue(Item currentItem, int updateValue) {
		currentItem.quality = currentItem.quality + updateValue;
	}

	/*  The Quality of an item is never more than 50 */
	private static void checkMaxQualityValue(Item currentItem) {
		if (currentItem.quality > 50) {
			currentItem.quality = 50;
		}
	}

	/* The Quality of an item is never negative */
	private static void checkMinQaulityValue(Item currentItem) {
		if (currentItem.quality < 0) {
			currentItem.quality = 0;
		}
	}

    /* Once the sell by date has passed, Quality degrades twice as fast */
	private static int adjustQualityValueIfSellInIsPassed(Item currentItem, int updateValue) {
		if (currentItem.sellIn < 0 && updateValue < 0) {
			updateValue = updateValue * 2;
		}
		return updateValue;
	}


}
