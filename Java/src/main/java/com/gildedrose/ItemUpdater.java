package com.gildedrose;

abstract class ItemUpdater {
    private static final int MIN_QUALITY = 0;
    private static final int MAX_QUALITY = 50;
    private final Item item;

    public ItemUpdater(Item item) {
        this.item = item;
    }

    abstract void setQualityForValidItem();

    abstract void setQualityForExpiredItem();

    final void updateItem() {
        setQualityForValidItem();
        if (hasItemExpired()) {
            setQualityForExpiredItem();
        }
        decreaseSellIn();
    }

    void decreaseSellIn() {
        item.sellIn -= 1;
    }

    final void increaseQualityByValue(int n) {
        if (isQualityLessThanMaxValue()) {
            item.quality += n;
        }
    }

    final void decreaseQualityByValue(int n) {
        if (isQualityMoreThanMinValue()) {
            item.quality -= n;
        }
    }

    final boolean isQualityLessThanMaxValue() {
        return item.quality < MAX_QUALITY;
    }

    final void setQualityToValue(int newQuality) {
        item.quality = newQuality;
    }

    final boolean isSellInLessThanOrEqualToValue(int value) {
        return item.sellIn <= value;
    }

    final boolean isSellInBetweenMinAndMaxValues(int min, int max) {
        return !isSellInLessThanOrEqualToValue(min)
                && isSellInLessThanOrEqualToValue(max);
    }

    private boolean hasItemExpired() {
        return item.sellIn <= 0;
    }

    private boolean isQualityMoreThanMinValue() {
        return item.quality > MIN_QUALITY;
    }
}
