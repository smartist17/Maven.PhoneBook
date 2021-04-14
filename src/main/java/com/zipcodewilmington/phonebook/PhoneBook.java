package com.zipcodewilmington.phonebook;

import java.util.*;

/**
 * Created by leon on 1/23/18.
 * Made WAY better by kristofer 6/16/20
 */
public class PhoneBook {

    private Map<String, List<String>> map;
        List<String> numbers;

    public PhoneBook(Map<String, List<String>> map) {

        this.map = new LinkedHashMap<>(map.size());
    }

    public PhoneBook() {

        this.map = new LinkedHashMap<>();
        this.numbers = new ArrayList<>();
    }

    public void add(String name, String phoneNumber) {
        numbers.add(phoneNumber);
        map.put(name, numbers);
    }

    public void addAll(String name, String... phoneNumbers) {
        numbers.addAll(Arrays.asList(phoneNumbers));
        map.put(name, numbers);
    }

    public void remove(String name) {
        map.remove(name);
    }

    public Boolean hasEntry(String name) {

        return map.containsKey(name) || this.numbers.contains(name);
    }

    public List<String> lookup(String name) {

        return map.get(name);
    }

    public String reverseLookup(String phoneNumber)  {
        String result = "";
        for (Map.Entry < String, List<String>> entry: map.entrySet())
            if (entry.getValue().contains(phoneNumber)){
                result = entry.getKey();
            }
        return result;
    }

    public List<String> getAllContactNames() {
        List<String> names = new ArrayList<>();
        for (Map.Entry < String, List<String>> entry: map.entrySet())
            names.add(entry.getKey());
        return names;
    }

    public Map<String, List<String>> getMap() {
        return this.map;
    }
}
