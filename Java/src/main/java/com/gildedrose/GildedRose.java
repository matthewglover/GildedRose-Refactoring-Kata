package com.gildedrose;

class GildedRose {
    private final Item[] items;

    GildedRose(Item[] items) {
        this.items = items;
    }

    void updateQuality() {
        for (Item item : items) {
            updateItem(item);
        }
    }

    private void updateItem(Item item) {
        ItemWrapper wrapped = new ItemWrapper(item);

        if (wrapped.isNormalItem()) {
           new NormalItemUpdater().updateItem(item);
        } else if (wrapped.isAgedBrie()) {
            new AgedBrieItemUpdater().updateItem(item);
        } else if (wrapped.isBackstagePass()) {
            new BackstagePassItemUpdater().updateItem(item);
        } else if (wrapped.isSulfuras()) {
            new SulfurasItemUpdater().updateItem(item);
        } else if (wrapped.isConjuredItem()) {
            new ConjuredItemUpdater().updateItem(item);
        }
    }
}