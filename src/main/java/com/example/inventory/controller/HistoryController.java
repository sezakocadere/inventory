package com.example.inventory.controller;

import com.example.inventory.model.history.History;
import com.example.inventory.service.history.HistoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("history")
public class HistoryController {
    private final HistoryService historyService;

    @GetMapping
    public List<History> listHistory() {
        return historyService.getHistory();
    }
}
