package com.gildedrose;

import org.junit.Test;

import static org.junit.Assert.*;

public class ItemUpdaterFactoryTest {

    @Test
    public void returnsAnInstanceOfAgedBrieItemUpdater() {
        ItemUpdaterFactory itemUpdaterFactory = new ItemUpdaterFactory();
        Item agedBrie = new Item("Aged Brie", 5, 49);

        ItemUpdater itemUpdater = itemUpdaterFactory.createItemUpdater(agedBrie);

        assertTrue(itemUpdater instanceof AgedBrieItemUpdater);
    }

    @Test
    public void returnsAnInstanceOfBackstagePassItemUpdater() {
        ItemUpdaterFactory itemUpdaterFactory = new ItemUpdaterFactory();
        Item backstagePass = new Item("Backstage passes to a TAFKAL80ETC concert", 11, 40);

        ItemUpdater itemUpdater = itemUpdaterFactory.createItemUpdater(backstagePass);

        assertTrue(itemUpdater instanceof BackstagePassItemUpdater);
    }

    @Test
    public void returnsAnInstanceOfSulfurasItemUpdater() {
        ItemUpdaterFactory itemUpdaterFactory = new ItemUpdaterFactory();
        Item sulfuras = new Item("Sulfuras, Hand of Ragnaros", 5, 40);

        ItemUpdater itemUpdater = itemUpdaterFactory.createItemUpdater(sulfuras);

        assertTrue(itemUpdater instanceof SulfurasItemUpdater);
    }

    @Test
    public void returnsAnInstanceOfNormalItemUpdater() {
        ItemUpdaterFactory itemUpdaterFactory = new ItemUpdaterFactory();
        Item normalItem = new Item("Normal Item", 1, 10);

        ItemUpdater itemUpdater = itemUpdaterFactory.createItemUpdater(normalItem);

        assertTrue(itemUpdater instanceof NormalItemUpdater);
    }

    @Test
    public void returnsAnInstanceOfConjuredItemUpdater() {
        Item conjuredItem = new Item("Conjured", 1, 10);
        ItemUpdaterFactory itemUpdaterFactory = new ItemUpdaterFactory();

        ItemUpdater itemUpdater = itemUpdaterFactory.createItemUpdater(conjuredItem);

        assertTrue(itemUpdater instanceof ConjuredItemUpdater);
    }
}