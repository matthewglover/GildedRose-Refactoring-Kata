package com.gildedrose;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class GildedRose {
    private final List<ItemUpdater> items;

    GildedRose(Item[] rawItems) {
        ItemUpdaterFactory factory = new ItemUpdaterFactory();

        this.items = Arrays.asList(rawItems).stream()
                .map(factory::createItemUpdater)
                .collect(Collectors.toList());
    }

    void updateQuality() {
        items.forEach(ItemUpdater::update);
    }
}