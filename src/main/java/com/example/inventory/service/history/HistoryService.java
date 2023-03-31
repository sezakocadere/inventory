package com.example.inventory.service.history;

import com.example.inventory.enums.Operation;
import com.example.inventory.model.history.History;

import java.util.List;

public interface HistoryService {
    void save(Operation operationType, Object object);

    List<History> getHistory();
}
