package com.gildedrose.run;

import java.io.IOException;
import java.text.MessageFormat;
import java.util.Set;

import com.gildedrose.GildedRose;
import com.gildedrose.Item;

public class App {

	public static void main(String[] args) throws IOException {
		System.out.println("Welcome to the GildedRose inn!\n");

		final String itemList = args.length > 0 ? args[0] : ("items.txt");

		System.out.println(MessageFormat.format("The item list is: {0}\n", itemList));
		Set<Item> itemSet = PropertiyLoader.load(itemList);

		System.out.println("Items loaded:");
		itemSet.forEach(System.out::println);

		GildedRose app = new GildedRose(itemSet.toArray((new Item[itemSet.size()])));

		app.updateQuality();

		System.out.println("\nItems updated:");
		itemSet.forEach(System.out::println);
	}

}
