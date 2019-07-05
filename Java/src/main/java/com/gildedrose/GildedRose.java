package com.gildedrose;

class GildedRose {
    private final Item[] items;

    GildedRose(Item[] items) {
        this.items = items;
    }

    void updateQuality() {
        ItemUpdaterFactory itemUpdaterFactory = new ItemUpdaterFactory();

        for (Item item : items) {
            updateItem(item, itemUpdaterFactory);
        }
    }

    private void updateItem(Item item, ItemUpdaterFactory itemUpdaterFactory) {
      itemUpdaterFactory.createItemUpdater(item).updateItem();
    }
}