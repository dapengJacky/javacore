package com.gupao.collections.demo2;

import java.util.ArrayList;
import java.util.List;



public class FailFastTest {

    private static final List<String> list = new ArrayList<String>();

    public static void main(String[] args) {
        new ThreadAdd(list).start();
        new ThreadIterate(list).start();
    }
}
