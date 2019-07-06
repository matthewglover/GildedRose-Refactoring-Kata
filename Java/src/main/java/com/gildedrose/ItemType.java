package com.gildedrose;

public enum ItemType {
    AGED_BRIE,
    BACKSTAGE_PASS,
    CONJURED,
    NORMAL,
    SULFURAS;

    public static ItemType from(Item item) {
        if (isAgedBrie(item)) {
            return AGED_BRIE;
        } else if (isSulfuras(item)) {
            return SULFURAS;
        } else if (isBackstagePass(item)) {
            return BACKSTAGE_PASS;
        } else if (isConjuredItem(item)) {
            return CONJURED;
        } else {
            return NORMAL;
        }
    }

    private static boolean isAgedBrie(Item item) {
        return item.name.equals("Aged Brie");
    }

    private static boolean isSulfuras(Item item) {
        return item.name.equals("Sulfuras, Hand of Ragnaros");
    }

    private static boolean isBackstagePass(Item item) {
        return item.name.equals("Backstage passes to a TAFKAL80ETC concert");
    }

    private static boolean isConjuredItem(Item item) {
        return item.name.equals("Conjured");
    }
}
