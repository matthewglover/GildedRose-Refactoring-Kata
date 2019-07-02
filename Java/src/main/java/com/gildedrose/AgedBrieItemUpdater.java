package com.gildedrose;

class AgedBrieItemUpdater extends ItemUpdater {
    private static final int QUALITY_VALUE_ONE = 1;

    @Override
    void setQualityForValidItem(Item item) {
        if (isQualityLessThanMaxValue(item)) {
            increaseQualityByValue(item, QUALITY_VALUE_ONE);
        }
    }

    @Override
    void setQualityForExpiredItem(Item item) {
        if (hasItemExpired(item) && isQualityLessThanMaxValue(item)) {
            increaseQualityByValue(item, QUALITY_VALUE_ONE);
        }
    }
}
