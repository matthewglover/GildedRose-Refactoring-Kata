package com.gildedrose;

class NormalItemUpdater extends ItemUpdater {
    private static final int QUALITY_VALUE_ONE = 1;

    public NormalItemUpdater(Item item) {
        super(item);
    }

    @Override
    void setQualityForValidItem() {
        if (isQualityMoreThanMinValue()) {
            decreaseQualityByValue(QUALITY_VALUE_ONE);
        }
    }

    @Override
    void setQualityForExpiredItem() {
        if (hasItemExpired() && isQualityMoreThanMinValue()) {
            decreaseQualityByValue(QUALITY_VALUE_ONE);
        }
    }
}