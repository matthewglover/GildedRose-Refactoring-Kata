package com.gildedrose;

import org.junit.Test;

import static org.junit.Assert.*;

public class AgedBrieItemUpdaterTest {
    @Test
    public void agedBrieIncreaseInQuality() {
        Item agedBrie = new Item("Aged Brie", 5, 49);

        new AgedBrieItemUpdater().updateItem(agedBrie);

        assertEquals(50, agedBrie.quality);
    }

    @Test
    public void qualityNeverMoreThanFifty() {
        Item agedBrie = new Item("Aged Brie", 5, 50);

        new AgedBrieItemUpdater().updateItem(agedBrie);

        assertEquals(50, agedBrie.quality);
    }
}