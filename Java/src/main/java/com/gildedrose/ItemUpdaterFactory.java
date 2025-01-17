package com.gildedrose;

public class ItemUpdaterFactory {
    public ItemUpdater createItemUpdater(Item item) {
        ItemWrapper wrapped = new ItemWrapper(item);

        if (wrapped.isNormalItem()) {
            return new NormalItemUpdater();
        } else if (wrapped.isAgedBrie()) {
            return new AgedBrieItemUpdater();
        } else if (wrapped.isBackstagePass()) {
            return new BackstagePassItemUpdater();
        } else if (wrapped.isSulfuras()) {
            return new SulfurasItemUpdater();
        } else if (wrapped.isConjuredItem()) {
            return new ConjuredItemUpdater();
        }
        return null;
    }
}
