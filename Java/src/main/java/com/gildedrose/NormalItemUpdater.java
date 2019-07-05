package com.gildedrose;

class NormalItemUpdater extends ItemUpdater {
    private static final int QUALITY_VALUE_ONE = 1;

    public NormalItemUpdater(Item item) {
        super(item);
    }

    @Override
    void setQualityForValidItem() {
        decreaseQualityByValue(QUALITY_VALUE_ONE);
    }

    @Override
    void setQualityForExpiredItem() {
        decreaseQualityByValue(QUALITY_VALUE_ONE);
    }
}