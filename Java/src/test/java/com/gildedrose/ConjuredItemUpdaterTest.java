package com.gildedrose;

import org.junit.Test;

import static org.junit.Assert.*;

public class ConjuredItemUpdaterTest {

    @Test
    public void qualityOfAConjuredItemDecreasesByTwo() {
        Item conjuredItem = new Item("Conjured", 1, 10);

        new ConjuredItemUpdater().updateItem(conjuredItem);

        assertEquals(0, conjuredItem.sellIn);
        assertEquals(8, conjuredItem.quality);
    }

    @Test
    public void whenTheSellByDateHasPassedTheQualityOfAConjuredItemDecreasesByFour() {
        Item conjuredItem = new Item("Conjured", 0, 10);

        new ConjuredItemUpdater().updateItem(conjuredItem);

        assertEquals(-1, conjuredItem.sellIn);
        assertEquals(6, conjuredItem.quality);
    }
}