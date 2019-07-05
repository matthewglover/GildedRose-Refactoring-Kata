package com.gildedrose;

class BackstagePassItemUpdater extends ItemUpdater {

    public BackstagePassItemUpdater(Item item) {
        super(item);
    }

    @Override
    void setQualityForValidItem() {
        if (isSellInLessThanOrEqualTo(5)) {
            increaseQualityBy(3);
        } else if (isSellInLessThanOrEqualTo(10)) {
            increaseQualityBy(2);
        } else {
            increaseQualityBy(1);
        }
    }

    @Override
    void setQualityForExpiredItem() {
        setQuality(0);
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
