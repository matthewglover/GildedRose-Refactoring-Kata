package com.gildedrose;

import org.junit.Test;

import static org.junit.Assert.*;

public class AgedBrieTest {
    @Test
    public void agedBrieIncreaseInQuality() {
        Item agedBrie = new Item("Aged Brie", 5, 49);

        new AgedBrie(agedBrie).update();

        assertEquals(50, agedBrie.quality);
    }

    @Test
    public void qualityNeverMoreThanFifty() {
        Item agedBrie = new Item("Aged Brie", 5, 50);

        new AgedBrie(agedBrie).update();

        assertEquals(50, agedBrie.quality);
    }
}