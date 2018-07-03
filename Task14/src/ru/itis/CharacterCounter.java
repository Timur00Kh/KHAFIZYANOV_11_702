package ru.itis;

import java.util.HashMap;
import java.util.Map;

public class CharacterCounter {
    Map<Character, Integer> map = new HashMap<>();

    CharacterCounter() {
        for (Character i = 'A'; i <= 'Z'; i++) {
            map.put(i,0);
        }
    }

    public void analyze(String s) {
        for (int i = 0; i < s.length(); i++) {
            this.ink(s.charAt(i));
        }
    }

    private void ink(Character c) {
        if (c > 'Z') c = (char)(c - 32) ;
        map.put(c,map.get(c) + 1);
    }

    public void print() {
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            System.out.println("Character: " + entry.getKey() + " Count : " + entry.getValue());
        }
    }

}
