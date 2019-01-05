package com.gildedrose.items;

import com.gildedrose.Item;

public class GildedRoseItemFactory {

	public static final String AGED_BRIE = "Aged Brie";
	public static final String BACKSTAGE_PASSES_TO_A_TAFKAL80_ETC_CONCERT = "Backstage passes to a TAFKAL80ETC concert";
	public static final String SULFURAS_HAND_OF_RAGNAROS = "Sulfuras, Hand of Ragnaros";
	public static final String CONJURED_MANA_CAKE = "Conjured Mana Cake";
	protected Item currentItem;

	private GildedRoseItemFactory() {

	}

	public static GildedRoseItem crateGildedRoseItem(final Item currentItem) {
		switch (currentItem.name) {
		case SULFURAS_HAND_OF_RAGNAROS:
			return new GildedRoseSulfurasItem(currentItem);
		case AGED_BRIE:
			return new GildedRoseAgedItem(currentItem);
		case BACKSTAGE_PASSES_TO_A_TAFKAL80_ETC_CONCERT:
			return new GildedRoseBackStagePassItem(currentItem);
		case CONJURED_MANA_CAKE:
			return new GildedRoseConjuredItem(currentItem);
		default:
			return new GildedRoseGenericItem(currentItem);
		}
	}

}