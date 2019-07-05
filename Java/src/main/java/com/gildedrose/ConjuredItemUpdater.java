package com.gildedrose;

class ConjuredItemUpdater extends ItemUpdater {

    public ConjuredItemUpdater(Item item) {
        super(item);
    }

    @Override
    void updateQuality() {
        if (isExpired()) {
            decreaseQualityBy(4);
        } else {
            decreaseQualityBy(2);
        }
    }
}
