package com.gildedrose;

import org.junit.Test;

import static org.junit.Assert.*;

public class ItemUpdaterFactoryTest {

    private final ItemUpdaterFactory itemUpdaterFactory = new ItemUpdaterFactory();

    @Test
    public void returnsAnInstanceOfAgedBrieItemUpdater() {
        Item agedBrie = new Item("Aged Brie", 5, 49);

        UpdateableItem updatedableItem = itemUpdaterFactory.createItemUpdater(agedBrie);

        assertTrue(updatedableItem instanceof AgedBrieItemUpdater);
    }

    @Test
    public void returnsAnInstanceOfBackstagePassItemUpdater() {
        Item backstagePass = new Item("Backstage passes to a TAFKAL80ETC concert", 11, 40);

        UpdateableItem updateableItem = itemUpdaterFactory.createItemUpdater(backstagePass);

        assertTrue(updateableItem instanceof BackstagePassItemUpdater);
    }

    @Test
    public void returnsAnInstanceOfSulfurasItemUpdater() {
        Item sulfuras = new Item("Sulfuras, Hand of Ragnaros", 5, 40);

        UpdateableItem updateableItem = itemUpdaterFactory.createItemUpdater(sulfuras);

        assertTrue(updateableItem instanceof SulfurasItemUpdater);
    }

    @Test
    public void returnsAnInstanceOfNormalItemUpdater() {
        Item normalItem = new Item("Normal Item", 1, 10);

        UpdateableItem updateableItem = itemUpdaterFactory.createItemUpdater(normalItem);

        assertTrue(updateableItem instanceof NormalItemUpdater);
    }

    @Test
    public void returnsAnInstanceOfConjuredItemUpdater() {
        Item conjuredItem = new Item("Conjured", 1, 10);

        UpdateableItem updateableItem = itemUpdaterFactory.createItemUpdater(conjuredItem);

        assertTrue(updateableItem instanceof ConjuredItemUpdater);
    }
}