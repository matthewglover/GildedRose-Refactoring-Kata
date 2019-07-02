package com.gildedrose;

public abstract class ItemUpdater {
    public final int SELL_IN_VALUE_ZER0 = 0;

    public final void updateItem(Item item) {
        setQualityForValidItem(item);
        setQualityForExpiredItem(item);
        decreaseSellIn(item);
    }

    void setQualityForValidItem(Item item) {}
    void setQualityForExpiredItem(Item item) {}
    void decreaseSellIn(Item item) {
        item.sellIn -= 1;
    }

    final void increaseQualityByValue(Item item, int value) {
        item.quality += value;
    }

    final void decreaseQualityByOne(Item item) {
        item.quality -= 1;
    }

    final void decreaseQualityByTwo(Item item) {
        item.quality -= 2;
    }

    final boolean hasItemExpired(Item item) {
        return item.sellIn <= SELL_IN_VALUE_ZER0;
    }

    final boolean isQualityMoreThanZero(Item item) {
        return item.quality > 0;
    }

    final boolean isQualityLessThanFifty(Item item) {
        return item.quality < 50;
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
