package com.gildedrose;

import org.junit.Test;

import static org.junit.Assert.*;

public class ItemTypeTest {
    @Test
    public void isAgedBrieIfItemNameIsAgedBrie() {
        Item item = new Item("Aged Brie", 1, 1);

        assertEquals(ItemType.AGED_BRIE, ItemType.from(item));
    }

    @Test
    public void isSulfurasIfItemNameIsSulfuras() {
        Item item = new Item("Sulfuras, Hand of Ragnaros", 1, 1);

        assertEquals(ItemType.SULFURAS, ItemType.from(item));
    }

    @Test
    public void isBackstagePassIfBackstagePass() {
        Item item = new Item("Backstage passes to a TAFKAL80ETC concert", 1, 1);

        assertEquals(ItemType.BACKSTAGE_PASS, ItemType.from(item));
    }

    @Test
    public void isNormalItemIfNotASpecialItem() {
        Item item = new Item("Normal Item", 1, 1);

        assertEquals(ItemType.NORMAL, ItemType.from(item));
    }

    @Test
    public void isConjuredItemIfConjured() {
        Item item = new Item("Conjured", 1, 1);

        assertEquals(ItemType.CONJURED, ItemType.from(item));
    }
}