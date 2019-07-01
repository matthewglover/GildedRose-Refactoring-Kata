package com.gildedrose;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (int i = 0; i < items.length; i++) {
            updateItem(items[i]);
        }
    }

    private void updateItem(Item currentItem) {
        ItemWrapper wrapped = new ItemWrapper(currentItem);
        boolean isSellInLessThanFive = currentItem.sellIn <= 5;
        boolean isSellInLessThanTen = currentItem.sellIn <= 10;


        if (wrapped.isNormalItem() && isQualityMoreThanZero(currentItem)) {
            decreaseQualityByOne(currentItem);
        } else if (wrapped.isSulfuras()) {
            // Do nothing if it's sulfuras
        } else {
            if (isQualityLessThanFifty(currentItem)) {
                increaseQualityByOne(currentItem);

                if (wrapped.isBackstagePass()) {
                    if (isSellInLessThanTen && isQualityLessThanFifty(currentItem)) {
                            increaseQualityByOne(currentItem);
                    }

                    if (isSellInLessThanFive && isQualityLessThanFifty(currentItem)) {
                        increaseQualityByOne(currentItem);
                    }
                }
            }
        }

        setQualityForExpiredItem(wrapped, currentItem);

        decreaseSellInByOne(wrapped, currentItem);
    }

    private void increaseQualityByOne(Item item) {
        item.quality += 1;
    }

    private void decreaseQualityByOne(Item item) {
        item.quality -= 1;
    }

    private void setQualityToZero(Item item) {
        item.quality = 0;
    }

    private boolean hasItemExpired(Item item) {
        return item.sellIn <= 0;
    }

    private boolean isQualityMoreThanZero(Item item) {
        return item.quality > 0;
    }

    private boolean isQualityLessThanFifty(Item item) {
        return item.quality < 50;
    }

    private void setQualityForExpiredItem(ItemWrapper wrapped, Item item) {
        if (hasItemExpired(item)) {
            if (wrapped.isNormalItem() && isQualityMoreThanZero(item)) {
                decreaseQualityByOne(item);
            } else if (wrapped.isAgedBrie() && isQualityLessThanFifty(item)) {
                increaseQualityByOne(item);
            } else {
                setQualityToZero(item);
            }
        }
    }

    private void decreaseSellInByOne(ItemWrapper wrapped, Item item) {
        if (!wrapped.isSulfuras()) {
            item.sellIn -= 1;
        }
    }
}