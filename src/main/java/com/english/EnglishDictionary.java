
package com.english;

import java.util.*;

public class EnglishDictionary {
    Map<String, LinkedList<DictionaryEntry>> aDictionary=new HashMap<>();
    private DictionaryEntryComparator dictionaryEntryComparator=new DictionaryEntryComparator();

    public EnglishDictionary() {
    }
    public void insert(String value,String description)
    {
        
        LinkedList insertLinkedList= this.aDictionary.get(String.valueOf(value.charAt(0)));
        if(insertLinkedList!=null)
        {
            Iterator iterator = insertLinkedList.listIterator();
            boolean valueNotPresent=true;
            while(iterator.hasNext())
            {
                DictionaryEntry dictionaryEntry= (DictionaryEntry) iterator.next();
                if(dictionaryEntry.getWord().equals(value)) {
                    valueNotPresent=false;
                    System.out.println("value is already there");
                }
            }
            if(valueNotPresent)
            {
                insertLinkedList.add(new DictionaryEntry(value,description));
                insertLinkedList.sort(dictionaryEntryComparator);
                aDictionary.put(String.valueOf(value.charAt(0)),insertLinkedList);
            }
        }
        else {
            insertLinkedList=new LinkedList();
            insertLinkedList.add(new DictionaryEntry(value,description));
            insertLinkedList.sort(dictionaryEntryComparator);
            aDictionary.put(String.valueOf(value.charAt(0)),insertLinkedList);
        }
    }
    public DictionaryEntry read(String value)
    {
        DictionaryEntry emptyDictionaryEntry=new DictionaryEntry();
        if(value==null)
            return emptyDictionaryEntry;
        LinkedList insertLinkedList= this.aDictionary.get(String.valueOf(value.charAt(0)));
        if(insertLinkedList!=null) {
            Iterator iterator = insertLinkedList.listIterator();
            while(iterator.hasNext()) {
                DictionaryEntry dictionaryEntry= (DictionaryEntry) iterator.next();
                if(dictionaryEntry.getWord().equals(value)) {
                    return dictionaryEntry;
                }
            }
            return emptyDictionaryEntry;
        }
        else {
            return emptyDictionaryEntry;
        }
    }

    public void Update(String value,String description)
    {
        LinkedList insertLinkedList= this.aDictionary.get(String.valueOf(value.charAt(0)));
        if(insertLinkedList!=null)
        {
            Iterator iterator = insertLinkedList.listIterator();
            boolean valueNotPresent=true;
            while(iterator.hasNext())
            {
                DictionaryEntry dictionaryEntry= (DictionaryEntry) iterator.next();
                if(dictionaryEntry.getWord().equals(value)) {
                    valueNotPresent=false;
                    insertLinkedList.remove(dictionaryEntry);
                    DictionaryEntry dictionaryEntry1=new DictionaryEntry(value,description);
                    insertLinkedList.add(dictionaryEntry1);
                    insertLinkedList.sort(dictionaryEntryComparator);
                    aDictionary.put(String.valueOf(value.charAt(0)),insertLinkedList);
                    break;
                }
            }
            if(valueNotPresent)
            {
                insertLinkedList.add(new DictionaryEntry(value,description));
                insertLinkedList.sort(dictionaryEntryComparator);
                aDictionary.put(String.valueOf(value.charAt(0)),insertLinkedList);
            }
        }
        else {
            insertLinkedList=new LinkedList();
            insertLinkedList.add(new DictionaryEntry(value,description));
            insertLinkedList.sort(dictionaryEntryComparator);
            aDictionary.put(String.valueOf(value.charAt(0)),insertLinkedList);
        }
    }

    public boolean delete(String value)
   {
        LinkedList deleteLinkedList=this.aDictionary.get(String.valueOf(value.charAt(0)));
        if(deleteLinkedList==null) {
            System.out.println("nothing to delete");
            return false;
        }
            else{
            Iterator iterator = deleteLinkedList.listIterator();
           while(iterator.hasNext())
           {
              DictionaryEntry dictionaryEntry= (DictionaryEntry) iterator.next();
              if(dictionaryEntry.getWord().equals(value)) {
                  deleteLinkedList.remove(dictionaryEntry);
                  deleteLinkedList.sort(dictionaryEntryComparator);
                  aDictionary.put(String.valueOf(value.charAt(0)),deleteLinkedList);
                  return true;
              }
            }
            return false;
        }
   }

     public class DictionaryEntry {
        String word;
        String definition;

         public DictionaryEntry() {
         }

         public DictionaryEntry(String word, String definition) {
            this.word = word;
            this.definition = definition;
        }

        public String getWord() {
            return word;
        }

        public void setWord(String word) {
            this.word = word;
        }

        public String getDefinition() {
            return definition;
        }

        public void setDefinition(String definition) {
            this.definition = definition;
        }
    }
}

