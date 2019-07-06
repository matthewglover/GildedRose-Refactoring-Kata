package com.gildedrose;

import org.junit.Test;

import static org.junit.Assert.*;

public class ItemWrapperTest {
    @Test
    public void isAgedBrieIfItemNameIsAgedBrie() {
        Item item = new Item("Aged Brie", 1, 1);
        ItemWrapper wrapped = new ItemWrapper(item);

        assertEquals(ItemType.AGED_BRIE, wrapped.type());
    }

    @Test
    public void isSulfurasIfItemNameIsSulfuras() {
        Item item = new Item("Sulfuras, Hand of Ragnaros", 1, 1);
        ItemWrapper wrapped = new ItemWrapper(item);

        assertEquals(ItemType.SULFURAS, wrapped.type());
    }

    @Test
    public void isBackstagePassIfBackstagePass() {
        Item item = new Item("Backstage passes to a TAFKAL80ETC concert", 1, 1);
        ItemWrapper wrapped = new ItemWrapper(item);

        assertEquals(ItemType.BACKSTAGE_PASS, wrapped.type());
    }

    @Test
    public void isNormalItemIfNotASpecialItem() {
        Item item = new Item("Normal Item", 1, 1);
        ItemWrapper wrapped = new ItemWrapper(item);

        assertEquals(ItemType.NORMAL, wrapped.type());
    }

    @Test
    public void isConjuredItemIfConjured() {
        Item item = new Item("Conjured", 1, 1);
        ItemWrapper wrapped = new ItemWrapper(item);

        assertEquals(ItemType.CONJURED, wrapped.type());
    }
}