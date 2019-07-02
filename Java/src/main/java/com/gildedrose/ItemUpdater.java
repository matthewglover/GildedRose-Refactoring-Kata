package com.gildedrose;

abstract class ItemUpdater {
    private static final int SELL_IN_VALUE_ZERO = 0;
    private static final int SELL_IN_VALUE_ONE = 1;
    private static final int QUALITY_VALUE_MIN = 0;
    private static final int QUALITY_VALUE_MAX = 50;

    final void updateItem(Item item) {
        setQualityForValidItem(item);
        setQualityForExpiredItem(item);
        decreaseSellIn(item);
    }

    void setQualityForValidItem(Item item) {}
    void setQualityForExpiredItem(Item item) {}
    void decreaseSellIn(Item item) {
        item.sellIn -= SELL_IN_VALUE_ONE;
    }

    final void increaseQualityByValue(Item item, int value) {
        item.quality += value;
    }

    final void decreaseQualityByValue(Item item, int value) {
        item.quality -= value;
    }

    final boolean hasItemExpired(Item item) {
        return item.sellIn <= SELL_IN_VALUE_ZERO;
    }

    final boolean isQualityMoreThanMinValue(Item item) {
        return item.quality > QUALITY_VALUE_MIN;
    }

    final boolean isQualityLessThanMaxValue(Item item) {
        return item.quality < QUALITY_VALUE_MAX;
    }

    final void setQualityToValue(Item item, int value) {
        item.quality = value;
    }

    final boolean isSellInLessThanOrEqualToValue(Item item, int value) {
        return item.sellIn <= value;
    }

    final boolean isSellInBetweenMinAndMaxValues(Item item, int minValue, int maxValue) {
        return !isSellInLessThanOrEqualToValue(item, minValue)
                && isSellInLessThanOrEqualToValue(item, maxValue);
    }
}
