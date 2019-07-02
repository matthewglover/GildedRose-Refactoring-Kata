package com.gildedrose;

public abstract class ItemUpdater {
    public final void updateItem(Item item) {
        setQualityForValidItem(item);
        setQualityForExpiredItem(item);
        decreaseSellIn(item);
    }

    void setQualityForValidItem(Item item) {}
    void setQualityForExpiredItem(Item item) {}
    void decreaseSellIn(Item item) {
        item.sellIn -= 1;
    }
}
