package com.gildedrose;

class NormalItemUpdater extends ItemUpdater {
    private static final int QUALITY_VALUE_ONE = 1;

    @Override
    void setQualityForValidItem(Item item) {
        if (isQualityMoreThanMinValue(item)) {
            decreaseQualityByValue(item, QUALITY_VALUE_ONE);
        }
    }

    @Override
    void setQualityForExpiredItem(Item item) {
        if (hasItemExpired(item) && isQualityMoreThanMinValue(item)) {
            decreaseQualityByValue(item, QUALITY_VALUE_ONE);
        }
    }
}