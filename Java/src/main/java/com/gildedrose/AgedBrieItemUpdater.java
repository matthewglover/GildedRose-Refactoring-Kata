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

    private boolean isQualityLessThanFifty(Item item) {
        return item.quality < 50;
    }

    private void increaseQualityByOne(Item item) {
        item.quality += 1;
    }

    private boolean hasItemExpired(Item item) {
        return item.sellIn <= 0;
    }
}
