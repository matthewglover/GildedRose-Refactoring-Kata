package com.gildedrose;

class AgedBrie extends BaseItem {
    private static final int QUALITY_VALUE_ONE = 1;

    public AgedBrie(Item item) {
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
