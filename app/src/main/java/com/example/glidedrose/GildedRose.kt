package com.example.glidedrose

class GildedRose(var items: List<Item>) {

    fun updateQuality() {
        for (item in items) {
            // Decrease sellIn for all items except Sulfuras
            if (item.name != "Sulfuras, Hand of Ragnaros") {
                item.sellIn -= 1
            }

            // Update quality for all items except Sulfuras
            when {
                item.name == "Aged Brie" -> updateAgedBrie(item)
                item.name == "Sulfuras, Hand of Ragnaros" -> continue
                item.name.startsWith("Backstage pass") -> updateBackstagePass(item)
                item.name.startsWith("Conjured") -> updateConjuredItem(item)
                else -> updateNormalItem(item)
            }

            // Ensure quality bounds
            item.quality = item.quality.coerceIn(0, 50)
        }
    }

    private fun updateNormalItem(item: Item) {
        val qualityChange = if (item.sellIn <= 0) -2 else -1
        item.quality += qualityChange
    }

    private fun updateAgedBrie(item: Item) {
        val qualityChange = if (item.sellIn <= 0) 2 else 1
        item.quality += qualityChange
    }

    private fun updateBackstagePass(item: Item) {
        when {
            item.sellIn <= 0 -> item.quality = 0
            item.sellIn <= 5 -> item.quality += 3
            item.sellIn <= 10 -> item.quality += 2
            else -> item.quality += 1
        }
    }

    private fun updateConjuredItem(item: Item) {
        val qualityChange = if (item.sellIn <= 0) -4 else -2
        item.quality += qualityChange
    }
}
