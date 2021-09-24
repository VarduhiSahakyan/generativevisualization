package com.generactive.mock;

import com.generactive.model.Group;
import com.generactive.util.namegenerator.Casing;
import com.generactive.util.idgenerator.GroupIdGenerator;
import com.generactive.util.idgenerator.Type;
import com.generactive.util.namegenerator.NameGen;
import com.generactive.util.namegenerator.NameGenerator;

import java.util.Arrays;
import java.util.List;

public class GroupMock {
    private static final NameGen NAME_GEN = NameGen.start()
            .withSeparator(" ")
            .withCasing(Casing.CAPITALIZE)
            .adjective()
           .noun();

    public static Group getGroup() {
        return new Group(GroupIdGenerator.getNext(Type.GROUP), NameGenerator.getRandomName());
       // return new Group(IdGenerator.getNext(Type.GROUP), NAME_GEN.get());
        // TODO
     //   return new Group(GroupIdGenerator.getNext(Type.GROUP), NAME_GEN.get());
    }

    public static List<Group> getGroupsHierarchy() {
        Group group1 = getGroup();
        Group group2 = getGroup();
        Group group3 = getGroup();
        Group group4 = getGroup();
        Group group5 = getGroup();
        Group group6 = getGroup();
        group1.addSubGroup(group2);
        group2.addSubGroup(group3);
        group4.addSubGroup(group5);
        group5.addSubGroup(group6);
        return Arrays.asList(group1,
                group2,
                group3,
                group4,
                group5,
                group6);
    }
}