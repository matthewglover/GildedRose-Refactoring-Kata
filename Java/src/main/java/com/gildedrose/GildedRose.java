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

        if (wrapped.isNormalItem() && isQualityMoreThanZero(currentItem)) {
            decreaseQualityByOne(currentItem);
        } else if (wrapped.isSulfuras()) {
            // Do nothing if it's sulfuras
        } else {
            if (wrapped.isAgedBrie()) {
                setQualityForAgedBrie(currentItem);
            } else if (wrapped.isBackstagePass()) {
                setQualityForBackStagePass(currentItem);
            }
        }

        setQualityForExpiredItem(wrapped, currentItem);

        decreaseSellInByOne(wrapped, currentItem);

    }

    private void increaseQualityByOne(Item item) {
        item.quality += 1;
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

    void setQualityForAgedBrie(Item item) {
        if (isQualityLessThanFifty(item)) {
            increaseQualityByOne(item);
        }
    }

    void setQualityForBackStagePass(Item item) {
        if (isSellInLessThanTen(item) && !isSellInLessThanFive(item) && isQualityLessThanFifty(item)) {
            increaseQualityByOne(item);
            increaseQualityByOne(item);

        } else if (isSellInLessThanFive(item) && isQualityLessThanFifty(item)) {
            increaseQualityByOne(item);
            increaseQualityByOne(item);
            increaseQualityByOne(item);
        }
        else {
            increaseQualityByOne(item);
        }
    }

    private void setQualityForExpiredItem(ItemWrapper wrapped, Item item) {
        if (hasItemExpired(item)) {
            if (wrapped.isNormalItem() && isQualityMoreThanZero(item)) {
                decreaseQualityByOne(item);
            } else if (wrapped.isAgedBrie() && isQualityLessThanFifty(item)) {
                increaseQualityByOne(item);
            } else {
                setQualityToZero(item);
            }
        }
    }

    private void decreaseSellInByOne(ItemWrapper wrapped, Item item) {
        if (!wrapped.isSulfuras()) {
            item.sellIn -= 1;
        }
    }
}