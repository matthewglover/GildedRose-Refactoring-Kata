package com.gildedrose;

class NormalItemUpdater extends ItemUpdater {

    public NormalItemUpdater(Item item) {
        super(item);
    }

    @Override
    void setQualityForValidItem() {
        decreaseQualityBy(1);
    }

    @Override
    void setQualityForExpiredItem() {
        decreaseQualityBy(2);
    }
}