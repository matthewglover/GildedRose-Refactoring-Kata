package com.gildedrose;

class Conjured extends BaseItem {

    public Conjured(Item item) {
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
