package com.gildedrose;

class ItemWrapper {
    private final Item item;

    public ItemWrapper(Item item) {
        this.item = item;
    }

    public boolean isAgedBrie() {
       return item.name.equals("Aged Brie");
    }

    public boolean isSulfuras() {
        return item.name.equals("Sulfuras, Hand of Ragnaros");
    }

    public boolean isBackstagePass() {
        return item.name.equals("Backstage passes to a TAFKAL80ETC concert");
    }

    public boolean isConjuredItem() {
        return item.name.equals("Conjured");
    }

    public boolean isNormalItem() {
        return !isAgedBrie() && !isBackstagePass() && !isSulfuras() && !isConjuredItem();
    }
}
