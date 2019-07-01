package com.gildedrose;

public class BackstagePassItemUpdater extends ItemUpdater {
    @Override
    void setQualityForValidItem(Item item) {
        if (isSellInLessThanTen(item) && !isSellInLessThanFive(item)
                && isQualityLessThanFifty(item)) {
            increaseQualityByTwo(item);
        } else if (isSellInLessThanFive(item) && isQualityLessThanFifty(item)) {
            increaseQualityByThree(item);
        } else {
            increaseQualityByOne(item);
        }
    }

    @Override
    void setQualityForExpiredItem(Item item) {
        if (hasItemExpired(item)) {
            setQualityToZero(item);
        }
    }

    private boolean hasItemExpired(Item item) {
        return item.sellIn <= 0;
    }

    private void setQualityToZero(Item item) {
        item.quality = 0;
    }

    private void increaseQualityByOne(Item item) {
        item.quality += 1;
    }

    private void increaseQualityByTwo(Item item) {
        item.quality += 2;
    }

    private void increaseQualityByThree(Item item) {
        item.quality += 3;
    }

    private boolean isQualityLessThanFifty(Item item) {
        return item.quality < 50;
    }

    private boolean isSellInLessThanFive(Item item) {
        return item.sellIn <= 5;
    }

    private boolean isSellInLessThanTen(Item item) {
        return item.sellIn <= 10;
    }
}
