package com.gildedrose;

class ConjuredItemUpdater extends ItemUpdater {
    private static final int QUALITY_VALUE_TWO = 2;

    public ConjuredItemUpdater(Item item) {
        super(item);
    }

    @Override
    void setQualityForValidItem() {
        if (isQualityMoreThanMinValue()) {
            decreaseQualityByValue(QUALITY_VALUE_TWO);
        }
    }

    @Override
    void setQualityForExpiredItem() {
        if (isQualityMoreThanMinValue()) {
           decreaseQualityByValue(QUALITY_VALUE_TWO);
        }
    }
}
