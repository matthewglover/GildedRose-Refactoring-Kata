package com.gildedrose;

import org.junit.Test;

import static org.junit.Assert.*;

public class UpdateableItemFactoryTest {

    private final UpdateableItemFactory updateableItemFactory = new UpdateableItemFactory();

    @Test
    public void returnsAnInstanceOfAgedBrieItemUpdater() {
        Item agedBrie = new Item("Aged Brie", 5, 49);

        UpdateableItem updatedableItem = updateableItemFactory.createItemUpdater(agedBrie);

        assertTrue(updatedableItem instanceof AgedBrie);
    }

    @Test
    public void returnsAnInstanceOfBackstagePassItemUpdater() {
        Item backstagePass = new Item("Backstage passes to a TAFKAL80ETC concert", 11, 40);

        UpdateableItem updateableItem = updateableItemFactory.createItemUpdater(backstagePass);

        assertTrue(updateableItem instanceof BackstagePass);
    }

    @Test
    public void returnsAnInstanceOfSulfurasItemUpdater() {
        Item sulfuras = new Item("Sulfuras, Hand of Ragnaros", 5, 40);

        UpdateableItem updateableItem = updateableItemFactory.createItemUpdater(sulfuras);

        assertTrue(updateableItem instanceof Sulfuras);
    }

    @Test
    public void returnsAnInstanceOfNormalItemUpdater() {
        Item normalItem = new Item("Normal Item", 1, 10);

        UpdateableItem updateableItem = updateableItemFactory.createItemUpdater(normalItem);

        assertTrue(updateableItem instanceof Normal);
    }

    @Test
    public void returnsAnInstanceOfConjuredItemUpdater() {
        Item conjuredItem = new Item("Conjured", 1, 10);

        UpdateableItem updateableItem = updateableItemFactory.createItemUpdater(conjuredItem);

        assertTrue(updateableItem instanceof Conjured);
    }
}