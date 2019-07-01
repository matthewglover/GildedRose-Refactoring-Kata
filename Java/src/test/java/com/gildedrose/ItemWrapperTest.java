package com.gildedrose;

import org.junit.Test;

import static org.junit.Assert.*;

public class ItemWrapperTest {
    @Test
    public void isAgedBrieIfItemNameIsAgedBrie() {
        Item item = new Item("Aged Brie", 1, 1);
        ItemWrapper wrapped = new ItemWrapper(item);

        assertTrue(wrapped.isAgedBrie());
        assertFalse(wrapped.isSulfuras());
        assertFalse(wrapped.isBackstagePass());
    }

    @Test
    public void isSulfurasIfItemNameIsSulfuras() {
        Item item = new Item("Sulfuras, Hand of Ragnaros", 1, 1);
        ItemWrapper wrapped = new ItemWrapper(item);

        assertTrue(wrapped.isSulfuras());
        assertFalse(wrapped.isAgedBrie());
        assertFalse(wrapped.isBackstagePass());
    }

    @Test
    public void isBackstagePassIfBackstagePass() {
        Item item = new Item("Backstage passes to a TAFKAL80ETC concert", 1, 1);
        ItemWrapper wrapped = new ItemWrapper(item);

        assertTrue(wrapped.isBackstagePass());
        assertFalse(wrapped.isSulfuras());
        assertFalse(wrapped.isAgedBrie());
    }

    @Test
    public void isNormalItemIfNotASpecialItem() {
        Item item = new Item("Normal Item", 1, 1);
        ItemWrapper wrapped = new ItemWrapper(item);

        assertTrue(wrapped.isNormalItem());
        assertFalse(wrapped.isBackstagePass());
        assertFalse(wrapped.isSulfuras());
        assertFalse(wrapped.isAgedBrie());
    }

    @Test
    public void isConjuredItemIfConjured() {
        Item item = new Item("Conjured", 1, 1);
        ItemWrapper wrapped = new ItemWrapper(item);

        assertTrue(wrapped.isConjuredItem());
        assertFalse(wrapped.isBackstagePass());
        assertFalse(wrapped.isSulfuras());
        assertFalse(wrapped.isAgedBrie());
        assertFalse(wrapped.isNormalItem());
    }
}