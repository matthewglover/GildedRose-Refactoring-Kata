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
        }
    }

    private void increaseQualityByOne(Item item) {
        item.quality += 1;
    }

    private void increaseQualityByTwo(Item item) {
        item.quality += 2;
    }

    private void increaseQualityByThree(Item item) {
        item.quality += 3;
    }

    private void decreaseQualityByOne(Item item) {
        item.quality -= 1;
    }

    private void setQualityToZero(Item item) {
        item.quality = 0;
    }

    private boolean hasItemExpired(Item item) {
        return item.sellIn <= 0;
    }

    private boolean isQualityMoreThanZero(Item item) {
        return item.quality > 0;
    }

    private boolean isQualityLessThanFifty(Item item) {
        return item.quality < 50;
    }

    private boolean isSellInLessThanFive(Item item) {
        return item.sellIn <= 5;
    }

    private boolean isSellInLessThanTen(Item item) {
        return item.sellIn <= 10;
    }
}