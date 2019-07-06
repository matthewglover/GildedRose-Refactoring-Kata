package com.gildedrose;

class NormalItemUpdater extends BaseItem {

    public NormalItemUpdater(Item item) {
        super(item);
    }

    @Override
    void updateQuality() {
        if (isExpired()) {
            decreaseQualityBy(2);
        } else {
            decreaseQualityBy(1);
        }
    }
}