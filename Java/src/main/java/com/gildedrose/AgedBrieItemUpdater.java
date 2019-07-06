package com.gildedrose;

class AgedBrieItemUpdater extends BaseItem {
    private static final int QUALITY_VALUE_ONE = 1;

    public AgedBrieItemUpdater(Item item) {
        super(item);
    }

    @Override
    void updateQuality() {
        if (isExpired()) {
            increaseQualityBy(QUALITY_VALUE_ONE);
        } else {
            increaseQualityBy(QUALITY_VALUE_ONE);
        }
    }
}
