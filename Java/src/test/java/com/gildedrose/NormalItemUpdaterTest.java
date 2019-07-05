package com.gildedrose;

import org.junit.Test;

import static org.junit.Assert.*;

public class NormalItemUpdaterTest {

    @Test
    public void qualityOfANormalItemDecreasesByOne() {
        Item normalItem = new Item("Normal Item", 1, 10);

        new NormalItemUpdater(normalItem).update();

        assertEquals(0, normalItem.sellIn);
        assertEquals(9, normalItem.quality);
    }

    @Test
    public void whenTheSellByDateHasPassedTheQualityDecreasesByTwo() {
        Item normalItem = new Item("Normal Item", 0, 10);

        new NormalItemUpdater(normalItem).update();

        assertEquals(-1, normalItem.sellIn);
        assertEquals(8, normalItem.quality);
    }
}