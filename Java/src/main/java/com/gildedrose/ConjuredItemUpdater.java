package com.gildedrose;

class ConjuredItemUpdater extends ItemUpdater {
    private static final int QUALITY_VALUE_TWO = 2;

    public ConjuredItemUpdater(Item item) {
        super(item);
    }

    @Override
    void setQualityForValidItem() {
        decreaseQualityBy(QUALITY_VALUE_TWO);
    }

    @Override
    void setQualityForExpiredItem() {
        decreaseQualityBy(QUALITY_VALUE_TWO);
    }
}
