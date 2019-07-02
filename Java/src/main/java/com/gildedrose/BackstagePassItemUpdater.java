package com.gildedrose;

public class BackstagePassItemUpdater extends ItemUpdater {
    private static final int EXPIRED_QUALITY_VALUE = 0;
    private static final int SELL_IN_VALUE_FIVE = 5;
    private static final int SELL_IN_VALUE_TEN = 10;

    @Override
    void setQualityForValidItem(Item item) {
        if (isSellInBetweenMinAndMaxValues(item, SELL_IN_VALUE_FIVE, SELL_IN_VALUE_TEN)
                && isQualityLessThanFifty(item)) {
            increaseQualityByTwo(item);
        } else if
        (isSellInLessThanOrEqualToValue(item, SELL_IN_VALUE_FIVE) && isQualityLessThanFifty(item)) {
            increaseQualityByThree(item);
        } else {
            increaseQualityByOne(item);
        }
    }

    @Override
    void setQualityForExpiredItem(Item item) {
        if (hasItemExpired(item)) {
            setQualityToValue(item, EXPIRED_QUALITY_VALUE);
        }
    }
}
