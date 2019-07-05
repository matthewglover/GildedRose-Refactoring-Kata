package com.gildedrose;

class AgedBrieItemUpdater extends ItemUpdater {
    private static final int QUALITY_VALUE_ONE = 1;

    public AgedBrieItemUpdater(Item item) {
        super(item);
    }

    @Override
    void setQualityForValidItem() {
            increaseQualityBy(QUALITY_VALUE_ONE);
    }

    @Override
    void setQualityForExpiredItem() {
            increaseQualityBy(QUALITY_VALUE_ONE);
    }
}
