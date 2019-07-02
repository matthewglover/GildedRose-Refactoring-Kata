package com.gildedrose;

public class ConjuredItemUpdater extends ItemUpdater {
    @Override
    void setQualityForValidItem(Item item) {
        if (isQualityMoreThanZero(item)) {
            decreaseQualityByTwo(item);
        }
    }

    @Override
    void setQualityForExpiredItem(Item item) {
        if (hasItemExpired(item) && isQualityMoreThanZero(item)) {
            decreaseQualityByTwo(item);
        }
    }
}
