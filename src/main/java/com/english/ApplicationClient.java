package com.english;

import java.util.*;

public class ApplicationClient {
   public static void main(String[] args) {


       EnglishDictionary englishDictionary=new EnglishDictionary();
       EnglishDictionary.DictionaryEntry dictionaryEntry=englishDictionary.new DictionaryEntry();
       System.out.println("Deleting Hello - " + englishDictionary.delete("Hello"));
       englishDictionary.insert("Beast","A Beast Animal");
       englishDictionary.insert("Hello","A greeting");
       englishDictionary.insert("Apple","A Fruit");
       englishDictionary.insert("Ball","A Sport");
       englishDictionary.insert("Cat","An Animal");
       System.out.println("Deleting Hello - " + englishDictionary.delete("Hello"));
       Map<String,LinkedList<EnglishDictionary.DictionaryEntry>> aMap= englishDictionary.aDictionary;
       for(Map.Entry<String,LinkedList<EnglishDictionary.DictionaryEntry>> entry:aMap.entrySet())
       {
           System.out.println(entry.getKey());
           Iterator anIterator = entry.getValue().listIterator();
           while (anIterator.hasNext()) {
               EnglishDictionary.DictionaryEntry dictionaryEntry1= (EnglishDictionary.DictionaryEntry) anIterator.next();
               System.out.println(dictionaryEntry1.getWord()+":"+dictionaryEntry1.getDefinition());
           }
       }
       englishDictionary.Update("Hello","A warning sign");
       System.out.println("Reading Hello  - " + englishDictionary.read("Hello").definition);
       englishDictionary.insert("Halo","A video game");
       aMap= englishDictionary.aDictionary;
       for(Map.Entry<String,LinkedList<EnglishDictionary.DictionaryEntry>> entry:aMap.entrySet())
       {
           System.out.println(entry.getKey());
           Iterator anIterator = entry.getValue().listIterator();
           while (anIterator.hasNext()) {
               EnglishDictionary.DictionaryEntry dictionaryEntry1= (EnglishDictionary.DictionaryEntry) anIterator.next();
               System.out.println(dictionaryEntry1.getWord()+":"+dictionaryEntry1.getDefinition());
           }
       }
    }




}
