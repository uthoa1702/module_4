package com.dictionary.reposiitory.impl;

import com.dictionary.reposiitory.IDictionaryRepository;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;


@Repository
public class DictionaryRepository implements IDictionaryRepository {
    private static Map<String, String> dictionary = new HashMap<>();

    static {
        dictionary.put("hello", "xin chao");
        dictionary.put("honey", "mat ong");
        dictionary.put("darling", "cuc cung");
        dictionary.put("bae", "be iu");
    }

    @Override
    public String translate(String english) {
        String result = "unknown vocabulary";


        for (Map.Entry<String, String> s : dictionary.entrySet()) {
            if (s.getKey().equals(english)) {
                result = s.getValue();
            }
        }

        return result;
    }
}
