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

    @Override
    void decreaseSellIn(Item item) {
        item.sellIn -= 1;
    }

    private boolean isQualityMoreThanZero(Item item) {
        return item.quality > 0;
    }

    private void decreaseQualityByOne(Item item) {
        item.quality -= 1;
    }

    private boolean hasItemExpired(Item item) {
        return item.sellIn <= 0;
    }
}