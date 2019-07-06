package com.gildedrose;

class BackstagePass extends BaseItem {

    public BackstagePass(Item item) {
        super(item);
    }

    @Override
    void updateQuality() {
        if (isExpired()) {
            setQuality(0);
        } else {
            setQualityForValidItem();
        }
    }

    private void setQualityForValidItem() {
        if (sellIn() <= 5) {
            increaseQualityBy(3);
        } else if (sellIn() <= 10) {
            increaseQualityBy(2);
        } else {
            increaseQualityBy(1);
        }
    }
}
