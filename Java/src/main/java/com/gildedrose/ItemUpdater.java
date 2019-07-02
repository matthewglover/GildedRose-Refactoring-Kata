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

    final boolean isQualityLessThanFifty(Item item) {
        return item.quality < 50;
    }

    final void increaseQualityByOne(Item item) {
        item.quality += 1;
    }

    final void increaseQualityByTwo(Item item) {
        item.quality += 2;
    }

    final void increaseQualityByThree(Item item) {
        item.quality += 3;
    }

    final void decreaseQualityByOne(Item item) {
        item.quality -= 1;
    }

    final void decreaseQualityByTwo(Item item) {
        item.quality -= 2;
    }

    final boolean hasItemExpired(Item item) {
        return item.sellIn <= 0;
    }

    final boolean isQualityMoreThanZero(Item item) {
        return item.quality > 0;
    }

    final void setQualityToZero(Item item) {
        item.quality = 0;
    }

    final boolean isSellInLessThanFive(Item item) {
        return item.sellIn <= 5;
    }

    final boolean isSellInLessThanTen(Item item) {
        return item.sellIn <= 10;
    }

    final boolean isSellInLessThanTenAndMoreThanFive(Item item) {
        return isSellInLessThanTen(item) && !isSellInLessThanFive(item);
    }
}
