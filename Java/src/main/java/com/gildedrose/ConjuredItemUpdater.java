package com.gildedrose;

public class ConjuredItemUpdater extends ItemUpdater {
    private final int QUALITY_VALUE_TWO = 2;
    @Override
    void setQualityForValidItem(Item item) {
        if (isQualityMoreThanZero(item)) {
            decreaseQualityByValue(item, QUALITY_VALUE_TWO);
        }
    }

    @Override
    void setQualityForExpiredItem(Item item) {
        if (hasItemExpired(item) && isQualityMoreThanZero(item)) {
           decreaseQualityByValue(item, QUALITY_VALUE_TWO);
        }
    }
}
