package com.example.leet.april.week4;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * LRU Cache
 * Design and implement a data structure for Least Recently Used (LRU) cache. It should support the following operations: get and put.
 *
 * get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
 * put(key, value) - Set or insert the value if the key is not already present. When the cache reached its capacity, it should invalidate the least recently used item before inserting a new item.
 *
 * The cache is initialized with a positive capacity.
 *
 * Follow up:
 * Could you do both operations in O(1) time complexity?
 *
 * Example:
 *
 * LRUCache cache = new LRUCache( 2 );//capacity
        *
        *cache.put(1,1);
        *cache.put(2,2);
        *cache.get(1);       // returns 1
        *cache.put(3,3);    // evicts key 2
        *cache.get(2);       // returns -1 (not found)
        *cache.put(4,4);    // evicts key 1
        *cache.get(1);       // returns -1 (not found)
        *cache.get(3);       // returns 3
        *cache.get(4);       // returns 4
 */
public class Day24 {
    public static void main(String[] args) {
        LRUCache cache = new LRUCache(2);
        cache.put(1,1);
        cache.put(2,2);
        System.out.println(cache.get(1));       // returns 1
        cache.put(3,3);    // evicts key 2
        System.out.println(cache.get(2));       // returns -1 (not found)
        cache.put(4,4);    // evicts key 1
        System.out.println(cache.get(1));       // returns -1 (not found)
        System.out.println(cache.get(3));       // returns 3
        System.out.println(cache.get(4));       // returns 4
    }
}
class LRUCache {
    Map<Integer,Integer> map;
    int cap;
    public LRUCache(int capacity) {
        map=new LinkedHashMap();
        cap=capacity;
    }

    public int get(int key) {
        int result=-1;
        if(map.containsKey(key)){
            result=map.get(key);
            map.remove(key);
            map.put(key,result);
        }
        return result;
    }

    public void put(int key, int value) {
        if(map.containsKey(key))
            map.remove(key);
        else if(map.size()==cap){
            Map.Entry<Integer,Integer> entry=map.entrySet().iterator().next();
            int first=entry.getKey();
            map.remove(first);
        }
        map.put(key,value);
    }

}


class LRUCache1 {

    Map<Integer, Node> map;
    final int size;
    Node head;
    Node tail;

    public LRUCache1(int capacity) {
        size = capacity;
        map = new HashMap();

    }

    public int get(int key) {
        if(map.containsKey(key)) {
            Node node = map.get(key);

            bringToFront(node);

            return node.value;
        }
        return -1;
    }

    public void put(int key, int value) {
        if(map.containsKey(key)) {
            Node node = map.get(key);
            bringToFront(node);
            node.value = value;
        } else {
            if(map.size() == size) {
                Node node = tail;
                tail = node.prev;
                if(tail != null)
                    tail.next = null;
                map.remove(node.key);
            }
            Node node = new Node(key, value);
            node.next = head;
            if(head != null)
                head.prev = node;
            head = node;
            if(tail == null) {
                tail = head;
            }
            map.put(key, node);

        }
    }

    private void bringToFront(Node node) {

        if(node == head) {
            return;
        }

        Node prev = node.prev;
        if(prev != null){
            prev.next = node.next;

        }

        if(node.next != null) {
            node.next.prev = prev;
        }

        if(tail == node && prev != null) {
            tail = prev;
        }

        node.prev = null;
        node.next = head;
        head.prev = node;
        head = node;

    }

    class Node {
        Node next;
        Node prev;
        int key;
        int value;
        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    public static void main(String[] args) {
            LRUCache1 lruCache1 = new LRUCache1(2);
            lruCache1.put(2,2);
            lruCache1.put(3,3);
            System.out.println(lruCache1.get(2));       // returns 2
            lruCache1.put(4,4);    // evicts key 2
            System.out.println(lruCache1.get(3));       // returns -1 (not found)
            lruCache1.put(5,5);    // evicts key 1
            System.out.println(lruCache1.get(2));       // returns -1 (not found)
            System.out.println(lruCache1.get(4));       // returns 4
            System.out.println(lruCache1.get(5));       // returns 5
        }
}


/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */