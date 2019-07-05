package com.gildedrose;

class ConjuredItemUpdater extends ItemUpdater {

    public ConjuredItemUpdater(Item item) {
        super(item);
    }

    @Override
    void setQualityForValidItem() {
        decreaseQualityBy(2);
    }

    @Override
    void setQualityForExpiredItem() {
        decreaseQualityBy(2);
    }
}
