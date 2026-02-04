package com.zhn.personalproject.baseproject.leetcode;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Leetcode284 implements Iterator<Integer> {
    int pointer = 0;
    List<Integer> recordList = new ArrayList<>();
    public Leetcode284(Iterator<Integer> iterator) {
        // initialize any member here.
        while(iterator.hasNext()){
            recordList.add(iterator.next());
        }
        pointer = 0;
    }

    // Returns the next element in the iteration without advancing the iterator.
    public Integer peek() {
        return recordList.get(pointer);
    }

    // hasNext() and next() should behave the same as in the Iterator interface.
    // Override them if needed.
    @Override
    public Integer next() {
        pointer += 1;
        return recordList.get(pointer - 1);
    }

    @Override
    public boolean hasNext() {
        return pointer < recordList.size();
    }
}
