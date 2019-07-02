package com.gildedrose;

public class NormalItemUpdater extends ItemUpdater {
    private final int QUALITY_VALUE_ONE = 1;

    @Override
    void setQualityForValidItem(Item item) {
        if (isQualityMoreThanZero(item)) {
            decreaseQualityByValue(item, QUALITY_VALUE_ONE);
        }
    }

    @Override
    void setQualityForExpiredItem(Item item) {
        if (hasItemExpired(item) && isQualityMoreThanZero(item)) {
            decreaseQualityByValue(item, QUALITY_VALUE_ONE);
        }
    }
}