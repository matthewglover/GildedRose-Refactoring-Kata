package com.gildedrose;

public class BackstagePassItemUpdater extends ItemUpdater {
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
            setQualityToZero(item);
        }
    }
}
