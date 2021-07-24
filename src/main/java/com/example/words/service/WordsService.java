package com.example.words.service;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import com.example.words.model.Game;

public class WordsService {

    public Game validateWords(Map<String, List<String>> words) {
        Game game = new Game();

        List<String> inputLst = words.get("words");
        List<String> correctList = new ArrayList<>();
        if (inputLst.get(0) != null && !inputLst.get(0).trim().equals("")) {
            correctList.add(inputLst.get(0));
            for (int i = 1; i < inputLst.size(); i++) {
                String prevWord = inputLst.get(i - 1);
                String word = inputLst.get(i);

                if (word.charAt(0) == prevWord.charAt(prevWord.length() - 1)) {
                    correctList.add(word);
                } else {
                    game.setGameIsValid(false);
                    break;
                }
            }
            game.setGameIsValid(true);
        }
        Map<String, List<String>> gameWords = new LinkedHashMap<>();
        gameWords.put("words", correctList);
        game.setWords(gameWords);
        return game;
    }
}