package com.example.inventory.model.history;

import com.example.inventory.enums.Operation;
import lombok.Data;

import javax.persistence.*;
import java.time.OffsetDateTime;

@Entity
@Data
public class History {
    @Id
    @GeneratedValue
    private Long id;

    private OffsetDateTime createTime;
    private String detail;
    @Enumerated(EnumType.STRING)
    private Operation operationType;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
