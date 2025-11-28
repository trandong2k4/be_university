package com.university.dto.reponse;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class WeeklyStatDTO {
    private List<String> labels; // ["Tuần 1", "Tuần 2", ...]
    private List<Long> values; // [12, 18, 25, ...]
}
