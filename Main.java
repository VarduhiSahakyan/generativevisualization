package com.generactive;



import com.generactive.mock.ConfigurationMock;
import com.generactive.mock.GroupMock;
import com.generactive.mock.ItemMock;
import com.generactive.model.*;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        List<Group> groups = GroupMock.getGroupsHierarchy();
        List<Item> items = ItemMock.getItems(4);

        groups.get(groups.size() - 1).addItems(items);

        GroupRepository groupRepository = GroupRepository.getInstance();
        groupRepository.addGroupAll(groups);

        for (Group group : groupRepository.getGroupsHierarchy()) {
            group.print(0);
        }

        Basket basket = new Basket();
        for (Item item : items) {
            basket.add(new BasketItem(item, ConfigurationMock.getConfiguration()));
        }

        basket.print();
    }
}