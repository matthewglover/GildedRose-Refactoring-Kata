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
        decreaseQualityBy(4);
    }

    @Override
    void updateQuality() {
        if (isExpired()) {
            setQualityForExpiredItem();
        } else {
            setQualityForValidItem();
        }
    }
}
