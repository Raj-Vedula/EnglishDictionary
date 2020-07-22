package com.english;

import java.util.Comparator;

public class DictionaryEntryComparator implements Comparator<EnglishDictionary.DictionaryEntry> {
    @Override
    public int compare(EnglishDictionary.DictionaryEntry o1, EnglishDictionary.DictionaryEntry o2) {
        return o1.getWord().compareTo(o2.getWord());
    }
}
