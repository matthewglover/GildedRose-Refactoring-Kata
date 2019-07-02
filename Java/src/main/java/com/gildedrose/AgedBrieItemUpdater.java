package com.gildedrose;

public class AgedBrieItemUpdater extends ItemUpdater{
    @Override
    void setQualityForValidItem(Item item) {
        if (isQualityLessThanFifty(item)) {
            increaseQualityByOne(item);
        }
    }

    @Override
    void setQualityForExpiredItem(Item item) {
        if (hasItemExpired(item) && isQualityLessThanFifty(item)) {
            increaseQualityByOne(item);
        }
    }
}
