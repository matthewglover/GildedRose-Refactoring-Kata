package com.gildedrose;

import org.junit.Test;

import static org.junit.Assert.*;

public class BackstagePassItemUpdaterTest {
    @Test
    public void backstagePassQualityIncreasesByOneWhenSellInMoreThanTen() {
        Item backstagePass = new Item("Backstage passes to a TAFKAL80ETC concert", 11, 40);

        new BackstagePassItemUpdater(backstagePass).update();

        assertEquals(41, backstagePass.quality);
    }

    @Test
    public void backstagePassQualityIncreasesByTwoWhenSellInDecreasesToLessThanTen() {
        Item backstagePass = new Item("Backstage passes to a TAFKAL80ETC concert", 10, 40);

        new BackstagePassItemUpdater(backstagePass).update();

        assertEquals(42, backstagePass.quality);
    }

    @Test
    public void backstagePassQualityIncreasesByTwoWhenSellInDecreasesToFive() {
        Item backstagePass = new Item("Backstage passes to a TAFKAL80ETC concert", 6, 40);

        new BackstagePassItemUpdater(backstagePass).update();

        assertEquals(42, backstagePass.quality);
    }

    @Test
    public void backstagePassQualityIncreasesByThreeWhenSellInIsDecreasesToLessThanFive() {
        Item backstagePass = new Item("Backstage passes to a TAFKAL80ETC concert", 5, 40);

        new BackstagePassItemUpdater(backstagePass).update();

        assertEquals(43, backstagePass.quality);
    }

    @Test
    public void backstagePassQualityIsZeroWhenSellInIsLessThanZero() {
        Item backstagePass = new Item("Backstage passes to a TAFKAL80ETC concert", 0, 40);

        new BackstagePassItemUpdater(backstagePass).update();

        assertEquals(0, backstagePass.quality);
    }
}