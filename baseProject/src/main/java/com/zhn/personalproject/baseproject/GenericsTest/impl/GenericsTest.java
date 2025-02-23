package com.zhn.personalproject.baseproject.GenericsTest.impl;

public interface GenericsTest {

    interface GenericsInner<v>{
        void onLoad(v input);
    }
}
