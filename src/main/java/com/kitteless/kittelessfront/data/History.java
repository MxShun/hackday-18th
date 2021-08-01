package com.kitteless.kittelessfront.data;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class History {
    LocalDateTime dateTime;
    Integer amount;
}