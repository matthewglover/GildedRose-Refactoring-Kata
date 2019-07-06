package com.gildedrose;

class ItemWrapper {
    private final Item item;

    public ItemWrapper(Item item) {
        this.item = item;
    }

    public ItemType type() {
        if (isAgedBrie()) {
            return ItemType.AGED_BRIE;
        } else if (isSulfuras()) {
            return ItemType.SULFURAS;
        } else if (isBackstagePass()) {
            return ItemType.BACKSTAGE_PASS;
        } else if (isConjuredItem()) {
            return ItemType.CONJURED;
        } else {
            return ItemType.NORMAL;
        }
    }

    private boolean isAgedBrie() {
       return item.name.equals("Aged Brie");
    }

    private boolean isSulfuras() {
        return item.name.equals("Sulfuras, Hand of Ragnaros");
    }

    private boolean isBackstagePass() {
        return item.name.equals("Backstage passes to a TAFKAL80ETC concert");
    }

    private boolean isConjuredItem() {
        return item.name.equals("Conjured");
    }
}
