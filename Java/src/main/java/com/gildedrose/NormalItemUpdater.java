package com.gildedrose;

public class NormalItemUpdater extends ItemUpdater {

    @Override
    void setQualityForValidItem(Item item) {
        if (isQualityMoreThanZero(item)) {
            decreaseQualityByOne(item);
        }
    }

    @Override
    void setQualityForExpiredItem(Item item) {
        if (hasItemExpired(item) && isQualityMoreThanZero(item)) {
            decreaseQualityByOne(item);
        }
    }
}