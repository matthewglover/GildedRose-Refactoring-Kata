package com.gildedrose;

class ConjuredItemUpdater extends ItemUpdater {
    private static final int QUALITY_VALUE_TWO = 2;

    @Override
    void setQualityForValidItem(Item item) {
        if (isQualityMoreThanMinValue(item)) {
            decreaseQualityByValue(item, QUALITY_VALUE_TWO);
        }
    }

    @Override
    void setQualityForExpiredItem(Item item) {
        if (hasItemExpired(item) && isQualityMoreThanMinValue(item)) {
           decreaseQualityByValue(item, QUALITY_VALUE_TWO);
        }
    }
}
