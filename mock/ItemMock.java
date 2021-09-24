package com.generactive.mock;

import com.generactive.model.GenerativeItem;
import com.generactive.model.Item;
import com.generactive.model.StockItem;
import com.generactive.util.namegenerator.Casing;
import com.generactive.util.idgenerator.GroupIdGenerator;
import com.generactive.util.idgenerator.Type;
import com.generactive.util.namegenerator.NameGen;
import com.generactive.util.namegenerator.NameGenerator;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public final class ItemMock {
    private static final NameGen NAME_GEN = NameGen.start()
            .withSeparator(" ")
            .withCasing(Casing.CAPITALIZE)
            .adjective()
            .noun();


    public static Item getItem(Class<? extends Item> clazz) {
        Item item;
        if (clazz == GenerativeItem.class) {
            item = new GenerativeItem(GroupIdGenerator.getNext(Type.GROUP),
                    generateRandomPrice(), NameGenerator.getRandomName());
            //TODO ???
           // generateRandomPrice(), NAME_GEN.get());
        } else {
            item =  new StockItem(GroupIdGenerator.getNext(Type.GROUP),
                    generateRandomPrice(), NameGenerator.getRandomName());
           //TODO ??
            // generateRandomPrice(), NAME_GEN.get());
        }

        return item;
    }
    public static List<Item> getItems(int count) {
        List<Item> rv = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            rv.add(getItem(i % 2 == 0 ? GenerativeItem.class : StockItem.class));
        }
        return rv;
    }
    private static int generateRandomPrice() {
        return new Random().nextInt(8) * 100;
    }
    private ItemMock() {
    }
}
 /*
public static Item getItem(Class<? extends Item> clazz) {
        Item item;
        if (clazz == GenerativeItem.class) {
            item = new GenerativeItem(IdGenerator.getNext(Type.GROUP),
                    generateRandomPrice(), NameGenerator.getRandomName());
        } else {
            item =  new StockItem(IdGenerator.getNext(Type.GROUP),
                    generateRandomPrice(), NameGenerator.getRandomName());
        }

        return item;
    }
 */