package com.generactive.util.idgenerator;

public class GroupIdGenerator {

    private static int CURRENT = 1;

    public static int getNextId() {
        return CURRENT++;
    }


    private GroupIdGenerator() {

    }
    public static int getNext(Type group) {
        return CURRENT;
    }
}
