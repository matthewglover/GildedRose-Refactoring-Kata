package com.gildedrose;

public class SulfurasItemUpdater extends ItemUpdater {

    public SulfurasItemUpdater(Item item) {
        super(item);
    }

    @Override
    void setQualityForValidItem() {
    }

    @Override
    void setQualityForExpiredItem() {

    }

    @Override
    void decreaseSellIn() {
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
