package com.example.glidedrose

import org.junit.Assert.assertEquals
import org.junit.Test

internal class GildedRoseTest {

    @Test
    fun testUpdateQuality_NormalItem() {
        val items = listOf(
            Item("Normal Item", 5, 10),
            Item("Normal Item Outdated", 0, 10),
            Item("Normal Item Outdated", -5, 10)
        )
        val app = GildedRose(items)
        app.updateQuality()

        // Assert the updated sellIn for each item
        assertEquals(4, items[0].sellIn)
        assertEquals(-1, items[1].sellIn)
        assertEquals(-6, items[2].sellIn)

        // Assert the updated quality for each item
        assertEquals(9, items[0].quality)
        assertEquals(8, items[1].quality)
        assertEquals(8, items[2].quality)
    }

    @Test
    fun testUpdateQuality_AgedBrie() {
        val items = listOf(
            Item("Aged Brie", 2, 10),
            Item("Aged Brie", 0, 10),
            Item("Aged Brie", -2, 10)
        )
        val app = GildedRose(items)
        app.updateQuality()

        // Assert the updated sellIn for each item
        assertEquals(1, items[0].sellIn)
        assertEquals(-1, items[1].sellIn)
        assertEquals(-3, items[2].sellIn)

        // Assert the updated quality for each item
        assertEquals(11, items[0].quality)
        assertEquals(12, items[1].quality)
        assertEquals(12, items[2].quality)
    }

    @Test
    fun testUpdateQuality_Sulfuras() {
        val items = listOf(
            Item("Sulfuras, Hand of Ragnaros", 0, 80),
            Item("Sulfuras, Hand of Ragnaros", -2, 80),
        )
        val app = GildedRose(items)
        app.updateQuality()

        // Assert the updated sellIn for each item
        assertEquals(0, items[0].sellIn)
        assertEquals(-2, items[1].sellIn)

        // Assert the updated quality for each item
        assertEquals(80, items[0].quality)
        assertEquals(80, items[1].quality)
    }

    @Test
    fun testUpdateQuality_BackstagePass() {
        val items = listOf(
            Item("Backstage pass", 15, 10),
            Item("Backstage pass", 10, 10),
            Item("Backstage pass", 8, 10),
            Item("Backstage pass", 5, 10),
            Item("Backstage pass", 3, 10),
            Item("Backstage pass", 0, 10),
            Item("Backstage pass", -5, 10)
        )
        val app = GildedRose(items)
        app.updateQuality()

        // Assert the updated sellIn for each item
        assertEquals(14, items[0].sellIn)
        assertEquals(9, items[1].sellIn)
        assertEquals(7, items[2].sellIn)
        assertEquals(4, items[3].sellIn)
        assertEquals(2, items[4].sellIn)
        assertEquals(-1, items[5].sellIn)
        assertEquals(-6, items[6].sellIn)

        // Assert the updated quality for each item
        assertEquals(11, items[0].quality)
        assertEquals(12, items[1].quality)
        assertEquals(12, items[2].quality)
        assertEquals(13, items[3].quality)
        assertEquals(13, items[4].quality)
        assertEquals(0, items[5].quality)
        assertEquals(0, items[6].quality)
    }

    @Test
    fun testUpdateQuality_ConjuredItem() {
        val items = listOf(
            Item("Conjured Item", 3, 10),
            Item("Conjured Item", 0, 10),
            Item("Conjured Item", -2, 10)
        )
        val app = GildedRose(items)
        app.updateQuality()

        // Assert the updated sellIn for each item
        assertEquals(2, items[0].sellIn)
        assertEquals(-1, items[1].sellIn)
        assertEquals(-3, items[2].sellIn)

        // Assert the updated quality for each item
        assertEquals(8, items[0].quality)
        assertEquals(6, items[1].quality)
        assertEquals(6, items[2].quality)
    }
}


