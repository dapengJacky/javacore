package com.gupao.collections.list;

import java.util.ArrayList;
import java.util.List;

/**
 * @author peng.chen12@hand-china.com
 * @description
 * @date 2020/3/22
 */
public class FastFailTest {

    private static final List list = new ArrayList();

    public static void main(String[] args) {
        new Thread(new ThreadAdd(list)).start();
        new Thread(new ThreadIterator(list)).start();
    }
}
