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
        boolean hasItemExpired = currentItem.sellIn <= 0;
        boolean isSellInLessThanFive = currentItem.sellIn <= 5;
        boolean isSellInLessThanTen = currentItem.sellIn <= 10;
        boolean isQualityMoreThanZero = currentItem.quality > 0;
        boolean isQualityLessThanFifty = currentItem.quality < 50;

        if (wrapped.isNormalItem()) {
            if (isQualityMoreThanZero) {
                decreaseQualityByOne(currentItem);
                }
        } else if (wrapped.isSulfuras()) {
            // Do nothing if it's sulfuras
        } else{
            if (isQualityLessThanFifty) {
                increaseQualityByOne(currentItem);

                if (wrapped.isBackstagePass()) {
                    if (isSellInLessThanTen) {
                        if (isQualityLessThanFifty) {
                            increaseQualityByOne(currentItem);
                        }
                    }

                    if (isSellInLessThanFive) {
                        if (isQualityLessThanFifty) {
                            increaseQualityByOne(currentItem);
                        }
                    }
                }
            }
        }

        if (hasItemExpired) {
            if (!wrapped.isAgedBrie()) {
                if (!wrapped.isBackstagePass()) {
                    if (isQualityMoreThanZero) {
                        if (!wrapped.isSulfuras()) {
                            decreaseQualityByOne(currentItem);
                        }
                    }
                } else {
                    currentItem.quality = 0;
                }
            } else {
                if (isQualityLessThanFifty) {
                    increaseQualityByOne(currentItem);
                }
            }
        }

        if (!wrapped.isSulfuras()) {
            currentItem.sellIn = currentItem.sellIn - 1;
        }
    }

    private void increaseQualityByOne(Item item) {
        item.quality += 1;
    }

    private void decreaseQualityByOne(Item item) {
        item.quality -= 1;
    }

}