package com.gildedrose;

abstract class ItemUpdater {
    private static final int SELL_IN_VALUE_ZERO = 0;
    private static final int SELL_IN_VALUE_ONE = 1;
    private static final int QUALITY_VALUE_MIN = 0;
    private static final int QUALITY_VALUE_MAX = 50;
    protected final Item item;

    public ItemUpdater(Item item) {
        this.item = item;
    }

    abstract void setQualityForValidItem();

    abstract void setQualityForExpiredItem();

    final void updateItem() {
        setQualityForValidItem();
        setQualityForExpiredItem();
        decreaseSellIn();
    }

    void decreaseSellIn() {
        item.sellIn -= SELL_IN_VALUE_ONE;
    }

    final void increaseQualityByValue(int value) {
        item.quality += value;
    }

    final void decreaseQualityByValue(int value) {
        item.quality -= value;
    }

    final boolean hasItemExpired() {
        return item.sellIn <= SELL_IN_VALUE_ZERO;
    }

    final boolean isQualityMoreThanMinValue() {
        return item.quality > QUALITY_VALUE_MIN;
    }

    final boolean isQualityLessThanMaxValue() {
        return item.quality < QUALITY_VALUE_MAX;
    }

    final void setQualityToValue(int value) {
        item.quality = value;
    }

    final boolean isSellInLessThanOrEqualToValue(int value) {
        return item.sellIn <= value;
    }

    final boolean isSellInBetweenMinAndMaxValues(int minValue, int maxValue) {
        return !isSellInLessThanOrEqualToValue(minValue)
                && isSellInLessThanOrEqualToValue(maxValue);
    }
}
