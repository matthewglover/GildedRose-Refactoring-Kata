package com.gildedrose;

class AgedBrieItemUpdater extends ItemUpdater {
    private static final int QUALITY_VALUE_ONE = 1;

    public AgedBrieItemUpdater(Item item) {
        super(item);
    }

    @Override
    void setQualityForValidItem() {
        if (isQualityLessThanMaxValue()) {
            increaseQualityByValue(QUALITY_VALUE_ONE);
        }
    }

    @Override
    void setQualityForExpiredItem() {
        if (hasItemExpired() && isQualityLessThanMaxValue()) {
            increaseQualityByValue(QUALITY_VALUE_ONE);
        }
    }
}
