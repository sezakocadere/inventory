package com.example.inventory.service.history;

import com.example.inventory.enums.Operation;
import com.example.inventory.model.history.History;
import com.example.inventory.repository.HistoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class HistoryServiceImpl implements HistoryService {
    private final HistoryRepository historyRepository;

    @Override
    public void save(Operation operationType, Object object) {
        History history = new History();
        history.setCreateTime(OffsetDateTime.now());
        history.setOperationType(operationType);
        history.setDetail(object.toString());
        historyRepository.save(history);
    }

    @Override
    public List<History> getHistory() {
        return historyRepository.findAll();
    }
}
