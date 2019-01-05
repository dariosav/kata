package com.gildedrose;
import static com.gildedrose.helpers.ItemHelper.*;

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
			decreaseSellInDay(currentItem);
			updateQuality(currentItem);
		}
	}

	private void updateQuality(Item currentItem) {
		switch (currentItem.name) {
		case SULFURAS_HAND_OF_RAGNAROS:
			break;
		case AGED_BRIE:
			updateAgedItemQuality(currentItem);
			break;
		case BACKSTAGE_PASSES_TO_A_TAFKAL80_ETC_CONCERT:
			updateBackStagePassItemQuality(currentItem);
			break;
		case CONJURED_MANA_CAKE:
			updateConjuredItemQauality(currentItem);
			break;
		default:
			updateGenericItem(currentItem);
		}
	}

	private void decreaseSellInDay(Item currentItem) {
		switch (currentItem.name) {
		case SULFURAS_HAND_OF_RAGNAROS:
			break;
		case AGED_BRIE:
		case BACKSTAGE_PASSES_TO_A_TAFKAL80_ETC_CONCERT:
		case CONJURED_MANA_CAKE:
		default:
			decreaseSellIn(currentItem);
		}
	}




}