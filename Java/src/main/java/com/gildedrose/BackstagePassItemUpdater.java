package com.gildedrose;

public class BackstagePassItemUpdater extends ItemUpdater {
    final int EXPIRED_QUALITY_VALUE = 0;

    @Override
    void setQualityForValidItem(Item item) {
        if (isSellInLessThanTenAndMoreThanFive(item) && isQualityLessThanFifty(item)) {
            increaseQualityByTwo(item);
        } else if (isSellInLessThanFive(item) && isQualityLessThanFifty(item)) {
            increaseQualityByThree(item);
        } else {
            increaseQualityByOne(item);
        }
    }

    @Override
    void setQualityForExpiredItem(Item item) {
        if (hasItemExpired(item)) {
            setQualityToValue(item, EXPIRED_QUALITY_VALUE);
        }
    }
}
