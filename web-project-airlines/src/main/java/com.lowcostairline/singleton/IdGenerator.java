package com.lowcostairline.singleton;

public class IdGenerator {
    private static int id;

    private IdGenerator() {

    }

    public static int getNewId() {
        return ++id;
    }

    public static void init(int i){
        if (id == 0){
            id = i;
        }
    }

}
