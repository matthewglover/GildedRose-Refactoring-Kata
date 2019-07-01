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


        if (wrapped.isNormalItem()) {
            if (isQualityMoreThanZero(currentItem)) {
                decreaseQualityByOne(currentItem);
            }
        } else if (wrapped.isSulfuras()) {
            // Do nothing if it's sulfuras
        } else {
            if (isQualityLessThanFifty(currentItem)) {
                increaseQualityByOne(currentItem);

                if (wrapped.isBackstagePass()) {
                    if (isSellInLessThanTen) {
                        if (isQualityLessThanFifty(currentItem)) {
                            increaseQualityByOne(currentItem);
                        }
                    }

                    if (isSellInLessThanFive) {
                        if (isQualityLessThanFifty(currentItem)) {
                            increaseQualityByOne(currentItem);
                        }
                    }
                }
            }
        }

        if (hasItemExpired(currentItem)) {
            if (wrapped.isNormalItem() && isQualityMoreThanZero(currentItem)) {
                decreaseQualityByOne(currentItem);
            } else if (wrapped.isAgedBrie() && isQualityLessThanFifty(currentItem)) {
                increaseQualityByOne(currentItem);
            } else {
                setQualityToZero(currentItem);
            }
        }

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

    private void decreaseSellInByOne(ItemWrapper wrapped, Item item) {
        if (!wrapped.isSulfuras()) {
            item.sellIn -= 1;
        }
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
}