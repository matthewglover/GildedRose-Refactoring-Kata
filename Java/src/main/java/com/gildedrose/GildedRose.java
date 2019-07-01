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

    private void updateItem(Item currentItem) {
        ItemWrapper wrapped = new ItemWrapper(currentItem);

        if (wrapped.isNormalItem()) {
           new NormalItemUpdater().updateItem(currentItem);
        } else if (wrapped.isAgedBrie()) {
            new AgedBrieItemUpdater().updateItem(currentItem);
        } else if (wrapped.isBackstagePass()) {
            new BackstagePassItemUpdater().updateItem(currentItem);
        } else if (wrapped.isSulfuras()) {
            new SulfurasItemUpdater().updateItem(currentItem);
        } else if (wrapped.isConjuredItem()) {
            new ConjuredItemUpdater().updateItem(currentItem);
        }
    }
}