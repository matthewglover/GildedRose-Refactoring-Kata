package com.gildedrose;

public class BackstagePassItemUpdater extends ItemUpdater {
    private static final int EXPIRED_QUALITY_VALUE = 0;
    private static final int SELL_IN_VALUE_FIVE = 5;
    private static final int SELL_IN_VALUE_TEN = 10;
    private static final int QUALITY_VALUE_ONE = 1;
    private static final int QUALITY_VALUE_TWO = 2;
    private static final int QUALITY_VALUE_THREE = 3;


    @Override
    void setQualityForValidItem(Item item) {
        if (isSellInBetweenMinAndMaxValues(item, SELL_IN_VALUE_FIVE, SELL_IN_VALUE_TEN)
                && isQualityLessThanFifty(item)) {
            increaseQualityByValue(item, QUALITY_VALUE_TWO);
        } else if
        (isSellInLessThanOrEqualToValue(item, SELL_IN_VALUE_FIVE) && isQualityLessThanFifty(item)) {
            increaseQualityByValue(item, QUALITY_VALUE_THREE);
        } else {
            increaseQualityByValue(item, QUALITY_VALUE_ONE);
        }
    }

    @Override
    void setQualityForExpiredItem(Item item) {
        if (hasItemExpired(item)) {
            setQualityToValue(item, EXPIRED_QUALITY_VALUE);
        }
    }
}
