package com.gildedrose;

import org.junit.Test;

import static org.junit.Assert.*;

public class SulfurasTest {
    @Test
    public void sulfurasSellInAndQualityNeverChange() {
        Item sulfuras = new Item("Sulfuras, Hand of Ragnaros", 5, 40);

        new Sulfuras(sulfuras).update();

        assertEquals(5, sulfuras.sellIn);
        assertEquals(40, sulfuras.quality);
    }
}