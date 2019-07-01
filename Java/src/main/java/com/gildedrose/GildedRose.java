package com.gildedrose;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (int i = 0; i < items.length; i++) {
            updateItem(items[i]);
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