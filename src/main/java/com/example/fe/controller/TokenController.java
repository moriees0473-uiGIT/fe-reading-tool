package com.example.fe.controller;

import com.example.fe.service.TokenService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class TokenController {

    private final TokenService tokenService;

    public TokenController(TokenService tokenService) {
        this.tokenService = tokenService;
    }

    @PostMapping("/tokenize")
    public List<String> tokenize(@RequestBody String text) {

        if (text == null || text.length() > 1000) {
            throw new IllegalArgumentException("入力エラー");
        }

        return tokenService.tokenize(text);
    }
}
