package com.generactive.util.namegenerator;

public class Main {

    public static void main(String[] args) {
        String name = NameGen.start()
                .withSeparator(" ")
                .withCasing(Casing.CAPITALIZE)
                .adjective()
                .noun()
                .get();

        System.out.println(name);
    }


}
