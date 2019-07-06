package com.gildedrose;

public class UpdateableItemFactory {
    public UpdateableItem createItemUpdater(Item item) {
        switch (ItemType.from(item)) {
            case AGED_BRIE: return new AgedBrie(item);
            case CONJURED: return new Conjured(item);
            case BACKSTAGE_PASS: return new BackstagePass(item);
            case SULFURAS: return new Sulfuras(item);
            default: return new Normal(item);
        }
    }
}
