package com.gildedrose.run;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashSet;
import java.util.Properties;
import java.util.Set;

import com.gildedrose.Item;

public class PropertiyLoader {

	public static Set<Item> load(String itemList) throws IOException {
		final Properties properties = new Properties();
		properties.load(new FileInputStream(itemList));

		Set<Item> items = new HashSet<>();

		for (final String key : properties.stringPropertyNames()) {
			final String value = properties.getProperty(key);
			final String[] valueParts = value.split("\\/");
			final String itemName = valueParts[0];
			final int itemSellIn = Integer.valueOf(valueParts[1]);
			final int itemQaulity = Integer.valueOf(valueParts[2]);

			items.add(new Item(itemName, itemSellIn, itemQaulity));
		}

		return items;
	}

}
