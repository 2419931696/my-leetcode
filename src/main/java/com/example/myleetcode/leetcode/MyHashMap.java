package com.example.myleetcode.leetcode;

import java.util.LinkedList;

/**
 * 题号：leetcode706
 * 不使用任何内建的哈希表库设计一个哈希映射（HashMap）。
 *
 * 实现 MyHashMap 类：
 *
 * MyHashMap() 用空映射初始化对象
 * void put(int key, int value) 向 HashMap 插入一个键值对 (key, value) 。如果 key 已经存在于映射中，则更新其对应的值 value 。
 * int get(int key) 返回特定的 key 所映射的 value ；如果映射中不包含 key 的映射，返回 -1 。
 * void remove(key) 如果映射中存在 key 的映射，则移除 key 和它所对应的 value 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/design-hashmap
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MyHashMap {

    int length = 1024;

    LinkedList<Node>[] map = new LinkedList[length];

    /** Initialize your data structure here. */
    public MyHashMap() {

    }

    /** value will always be non-negative. */
    public void put(int key, int value) {
        int index = getIndex(key);
        if(map[index] == null) {
            map[index] = new LinkedList<>();
        }
        remove(key);
        map[index].add(new Node(key, value));
    }

    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        int index = getIndex(key);
        LinkedList<Node> linkedLists = map[getIndex(index)];
        if(linkedLists == null) {
            return -1;
        }
        for (Node node : linkedLists) {
            if(node.key == key) {
                return node.value;
            }
        }
        return -1;
    }

    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        int index = getIndex(key);
        if(map[index] == null) {
            return;
        }
        for(Node node : map[index]) {
            if(node.key == key) {
                map[index].remove(node);
                break;
            }
        }
    }

    private int getIndex(int key) {
        return key & (length-1);
    }

    class Node {
        int key;
        int value;
        // 省略了，直接用key
        int hash;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
}
