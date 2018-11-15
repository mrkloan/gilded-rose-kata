package com.gildedrose;

import static java.lang.Integer.parseInt;

public class TextTestFixture {

    public static void main(final String[] args) {
        final Inventory inventory = Inventory.of(
                Item.of("+5 Dexterity Vest", 10, 20),
                Item.of("Aged Brie", 2, 0),
                Item.of("Elixir of the Mongoose", 5, 7),
                Item.of("Sulfuras, Hand of Ragnaros", 0, 80),
                Item.of("Sulfuras, Hand of Ragnaros", -1, 80),
                Item.of("Backstage passes to a TAFKAL80ETC concert", 15, 20),
                Item.of("Backstage passes to a TAFKAL80ETC concert", 10, 49),
                Item.of("Backstage passes to a TAFKAL80ETC concert", 5, 49),
                Item.of("Conjured Mana Cake", 3, 6)
        );

        final GildedRose gildedRose = new GildedRose(inventory);
        final InventoryPrinter inventoryPrinter = new ConsolePrinter();

        final int days = (args.length > 0)
                ? parseInt(args[0]) + 1
                : 2;

        for (int i = 0; i < days; i++) {
            inventoryPrinter.print("-------- Day " + i + " --------");
            inventoryPrinter.print("Name, Sell in, Quality");

            gildedRose.printInventory(inventoryPrinter);

            inventoryPrinter.print("");
            gildedRose.updateInventory();
        }
    }

    private static class ConsolePrinter implements InventoryPrinter {

        @Override
        public void print(final String message) {
            System.out.println(message);
        }
    }
}
