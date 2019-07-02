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

    private boolean isQualityMoreThanZero(Item item) {
        return item.quality > 0;
    }

    private void decreaseQualityByTwo(Item item) {
        item.quality -= 2;
    }

    private boolean hasItemExpired(Item item) {
        return item.sellIn <= 0;
    }
}
