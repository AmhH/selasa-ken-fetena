package com.example.leet.nadew;

import java.util.*;

/**
 * Given a dictionary dict, write a function flattenDictionary that returns a flattened version of it .
 *
 *
 * input:  dict = {
 *         	"Key1" : "1",
 *         	"Key2" : {
 *             	"a" : "2",
 *             	"b" : "3",
 *             	"c" : {
 *                 	"d" : "3",
 *                 	"e" : {
 *                     	"" : "1"
 *                                    }
 *             	}
 *            }
 *     	}
 *
 * output: {
 *         	"Key1" : "1",
 *         	"Key2.a" : "2",
 *           "Key2.b" : "3",
 *         	"Key2.c.d" : "3",
 *         	"Key2.c        "1"
 *     	}
 */
public class FlattenDictionary {

    public Map<String, String> flattenDictionary(Map<String, Object> dictionary){
        Map<String, String> result = new HashMap<>();
        flattenDictionary(dictionary.entrySet().iterator(), result, "");
        return result;
    }

    private void flattenDictionary(Iterator<Map.Entry<String, Object>> iterator, Map<String, String> result,
                                String prefix) {
        if(!iterator.hasNext())
            return;
        Map.Entry<String, Object> next = iterator.next();

        if(next.getValue() instanceof String){
            String key = getNewPrefix(prefix, next.getKey());
            result.put(key, (String) next.getValue());
        }else{
           prefix = getNewPrefix(prefix, next.getKey());
           Iterator<Map.Entry<String, Object>> it = ((HashMap<String, Object>) next.getValue()).entrySet().iterator();
           while (it.hasNext()){
               flattenDictionary(it, result, prefix);
           }
           prefix = "";
        }
        flattenDictionary(iterator, result, prefix);
    }

    private String getNewPrefix(String prefix, String key){
        if(prefix.length() ==0)
            return key;
        return new StringBuilder(prefix).append(".").append(key).toString();
    }

    public static void main(String[] args) {
        Map<String, Object> dictionary = new HashMap<>();
        dictionary.put("Key1", "1");

        Map<String, Object> key2 = new HashMap<>();
        key2.put("a", "2");
        key2.put("b", "3");

        Map<String, Object> c = new HashMap<>();
        c.put("d", "3");

        Map<String, Object> e = new HashMap<>();
        e.put("", "1");

        c.put("e", e);
        key2.put("c", c);
        dictionary.put("Key2", key2);

        System.out.println("---------------------------------------------------");
        System.out.println(new FlattenDictionary().flattenDictionary(dictionary));
        System.out.println("---------------------------------------------------");
        System.out.println(new FlattenDictionary().flattenDictionary1(dictionary));
    }

    public Map<String, String> flattenDictionary1(Map<String, Object> dictionary){
        Map<String, String> result = new HashMap<>();
        flattenDictionary1(dictionary, result, "");
        return result;
    }

    private void flattenDictionary1(Map<String, Object> dictionary, Map<String, String> result, String prefix) {
        dictionary.forEach((key, value) -> {
            if(value instanceof String){
                String newKey = getNewPrefix(prefix, key);
                result.put(newKey, (String) value);
            }else {
                Queue<Map<String, Object>> q = new LinkedList<>();
                q.add((Map<String, Object>) value);
                while (!q.isEmpty()){
                    flattenDictionary1(q.poll(), result, getNewPrefix(prefix, key));
                }
            }
        });
    }

}
