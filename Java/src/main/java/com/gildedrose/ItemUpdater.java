package com.gildedrose;

abstract class ItemUpdater {
    private static final int MIN_QUALITY = 0;
    private static final int MAX_QUALITY = 50;
    private final Item item;

    public ItemUpdater(Item item) {
        this.item = item;
    }

    abstract void setQualityForValidItem();

    abstract void setQualityForExpiredItem();

    final void update() {
        setQualityForValidItem();
        if (isExpired()) {
            setQualityForExpiredItem();
        }
        decreaseSellIn();
    }

    void decreaseSellIn() {
        item.sellIn -= 1;
    }

    final void increaseQualityBy(int n) {
        if (item.quality < MAX_QUALITY) {
            item.quality += n;
        }
    }

    final void decreaseQualityBy(int n) {
        if (item.quality > MIN_QUALITY) {
            item.quality -= n;
        }
    }

    final void setQuality(int quality) {
        item.quality = quality;
    }

    final boolean isSellInLessThanOrEqualTo(int n) {
        return item.sellIn <= n;
    }

    private boolean isExpired() {
        return item.sellIn <= 0;
    }
}
