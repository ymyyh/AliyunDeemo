package com.zhn.personalproject.baseproject.leetcode;

public class Leetcode2296 {
    int pointer = 1;
    StringBuilder sb = new StringBuilder();
    public Leetcode2296() {
        pointer = 1;
        sb = new StringBuilder();
    }

    public void addText(String text) {
        sb.insert(pointer, text);
        pointer += text.length();
    }

    public int deleteText(int k) {
        sb.delete(Math.max(0, pointer - k), pointer);
        return Math.max(k, pointer);
    }

    public String cursorLeft(int k) {
        pointer = Math.max(pointer - k, 0);
        return sb.substring(Math.max(0, pointer - 10), pointer);
    }

    public String cursorRight(int k) {
        pointer += k;
        return sb.substring(Math.max(0, pointer - 10), pointer);
    }
}
