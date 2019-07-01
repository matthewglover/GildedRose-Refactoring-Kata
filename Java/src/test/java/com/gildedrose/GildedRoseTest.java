package com.gildedrose;

import static org.junit.Assert.*;

import org.junit.Test;

public class GildedRoseTest {

    @Test
    public void qualityOfANormalItemDecreasesByOne() {
        Item normalItem = new Item("Normal Item", 1, 10);
        Item[] items = new Item[] {normalItem};
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertEquals(0, normalItem.sellIn);
        assertEquals(9, normalItem.quality);
    }

    @Test
    public void whenTheSellByDateHasPassedTheQualityDecreasesByTwo() {
        Item normalItem = new Item("Normal Item", 0, 10);
        Item[] items = new Item[] {normalItem};
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertEquals(-1, normalItem.sellIn);
        assertEquals(8, normalItem.quality);
    }

    @Test
    public void qualityOfAnItemNeverLessThanZero() {
        Item normalItem = new Item("Normal Item", 0, 0);
        Item[] items = new Item[] {normalItem};
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertEquals(0, normalItem.quality);
    }

    @Test
    public void agedBrieIncreaseInQuality() {
        Item agedBrie = new Item("Aged Brie", 5, 49);
        Item[] items = new Item[] {agedBrie};
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertEquals(50, agedBrie.quality);
    }

    @Test
    public void qualityNeverMoreThanFifty() {
        Item agedBrie = new Item("Aged Brie", 5, 50);
        Item[] items = new Item[] {agedBrie};
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertEquals(50, agedBrie.quality);
    }

    @Test
    public void sulfurasSellInAndQualityNeverChange() {
        Item sulfuras = new Item("Sulfuras, Hand of Ragnaros", 5, 40);
        Item[] items = new Item[] {sulfuras};
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertEquals(5, sulfuras.sellIn);
        assertEquals(40, sulfuras.quality);
    }

    @Test
    public void backstagePassQualityIncreasesByOneWhenSellInMoreThanTen() {
        Item backstagePass = new Item("Backstage passes to a TAFKAL80ETC concert", 11, 40);
        Item[] items = new Item[] {backstagePass};
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertEquals(41, backstagePass.quality);
    }

    @Test
    public void backstagePassQualityIncreasesByTwoWhenSellInDecreasesToLessThanTen() {
        Item backstagePass = new Item("Backstage passes to a TAFKAL80ETC concert", 10, 40);
        Item[] items = new Item[] {backstagePass};
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertEquals(42, backstagePass.quality);
    }

    @Test
    public void backstagePassQualityIncreasesByTwoWhenSellInDecreasesToFive() {
        Item backstagePass = new Item("Backstage passes to a TAFKAL80ETC concert", 6, 40);
        Item[] items = new Item[] {backstagePass};
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertEquals(42, backstagePass.quality);
    }

    @Test
    public void backstagePassQualityIncreasesByThreeWhenSellInIsDecreasesToLessThanFive() {
        Item backstagePass = new Item("Backstage passes to a TAFKAL80ETC concert", 5, 40);
        Item[] items = new Item[] {backstagePass};
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertEquals(43, backstagePass.quality);
    }

    @Test
    public void backstagePassQualityIsZeroWhenSellInIsLessThanZero() {
        Item backstagePass = new Item("Backstage passes to a TAFKAL80ETC concert", 0, 40);
        Item[] items = new Item[] {backstagePass};
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertEquals(0, backstagePass.quality);
    }
}
