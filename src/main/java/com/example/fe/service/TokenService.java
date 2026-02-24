package com.example.fe.service;

import com.atilika.kuromoji.ipadic.Token;
import com.atilika.kuromoji.ipadic.Tokenizer;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TokenService {

    private final Tokenizer tokenizer = new Tokenizer();

    public List<String> tokenize(String text) {
        return tokenizer.tokenize(text)
                .stream()
                .map(Token::getSurface)
                .collect(Collectors.toList());
    }
}
