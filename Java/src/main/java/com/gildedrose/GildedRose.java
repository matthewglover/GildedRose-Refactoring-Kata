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
           new NormalItemUpdater().updateQuality(currentItem);
        } else if (wrapped.isAgedBrie()) {
            setQualityForAgedBrie(currentItem);
        } else if (wrapped.isBackstagePass()) {
            setQualityForBackStagePass(currentItem);
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

    void setQualityForNormalItem(Item item) {
        if (isQualityMoreThanZero(item)) {
            decreaseQualityByOne(item);
        }

        if (hasItemExpired(item) && isQualityMoreThanZero(item)) {
            decreaseQualityByOne(item);
        }

        item.sellIn -= 1;
    }

    void setQualityForAgedBrie(Item item) {
        if (isQualityLessThanFifty(item)) {
            increaseQualityByOne(item);
        }

        if (hasItemExpired(item) && isQualityLessThanFifty(item)) {
            increaseQualityByOne(item);
        }

        item.sellIn -= 1;
    }

    void setQualityForBackStagePass(Item item) {
        if (isSellInLessThanTen(item) && !isSellInLessThanFive(item) && isQualityLessThanFifty(item)) {
            increaseQualityByTwo(item);
        } else if (isSellInLessThanFive(item) && isQualityLessThanFifty(item)) {
            increaseQualityByThree(item);
        } else {
            increaseQualityByOne(item);
        }

        if (hasItemExpired(item)) {
            setQualityToZero(item);
        }

        item.sellIn -= 1;
    }
}