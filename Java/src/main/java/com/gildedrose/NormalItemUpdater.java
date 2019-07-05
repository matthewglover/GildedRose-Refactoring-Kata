package com.gildedrose;

class NormalItemUpdater extends ItemUpdater {
    private static final int QUALITY_VALUE_ONE = 1;

    public NormalItemUpdater(Item item) {
        super(item);
    }

    @Override
    void setQualityForValidItem() {
        if (isQualityMoreThanMinValue(item)) {
            decreaseQualityByValue(item, QUALITY_VALUE_ONE);
        }
    }

    @Override
    void setQualityForExpiredItem(Item item) {
        if (hasItemExpired(item) && isQualityMoreThanMinValue(item)) {
            decreaseQualityByValue(item, QUALITY_VALUE_ONE);
        }
    }
}