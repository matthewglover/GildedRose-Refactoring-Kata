package com.gildedrose;

public class ItemUpdaterFactory {
    public ItemUpdater createItemUpdater(Item item) {
        ItemWrapper wrapped = new ItemWrapper(item);

        switch (wrapped.type()) {
            case AGED_BRIE: return new AgedBrieItemUpdater(item);
            case CONJURED: return new ConjuredItemUpdater(item);
            case BACKSTAGE_PASS: return new BackstagePassItemUpdater(item);
            case SULFURAS: return new SulfurasItemUpdater(item);
            default: return new NormalItemUpdater(item);
        }
    }
}
