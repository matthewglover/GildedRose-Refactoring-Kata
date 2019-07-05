package com.gildedrose;

class BackstagePassItemUpdater extends ItemUpdater {
    private static final int EXPIRED_QUALITY_VALUE = 0;
    private static final int SELL_IN_VALUE_FIVE = 5;
    private static final int SELL_IN_VALUE_TEN = 10;
    private static final int QUALITY_VALUE_ONE = 1;
    private static final int QUALITY_VALUE_TWO = 2;
    private static final int QUALITY_VALUE_THREE = 3;

    public BackstagePassItemUpdater(Item item) {
        super(item);
    }

    @Override
    void setQualityForValidItem() {
        if (ifSellInIsLessThanOrEqualToTen()) {
            increaseQualityByValue(QUALITY_VALUE_TWO);
        } else if
        (ifSellInIsLessThanOrEqualToFive()) {
            increaseQualityByValue(QUALITY_VALUE_THREE);
        } else {
            increaseQualityByValue(QUALITY_VALUE_ONE);
        }
    }

    @Override
    void setQualityForExpiredItem() {
        setQualityToValue(EXPIRED_QUALITY_VALUE);
    }

    private boolean ifSellInIsLessThanOrEqualToTen() {
        return isSellInBetweenMinAndMaxValues(SELL_IN_VALUE_FIVE, SELL_IN_VALUE_TEN) && isQualityLessThanMaxValue();
    }

    private boolean ifSellInIsLessThanOrEqualToFive() {
        return isSellInLessThanOrEqualToValue(SELL_IN_VALUE_FIVE) && isQualityLessThanMaxValue();
    }
}
