package com.zhn.personalproject.baseproject.genericsTest.impl;

public interface GenericsTest {

    interface GenericsInner<v>{
        void onLoad(v input);
    }
}
