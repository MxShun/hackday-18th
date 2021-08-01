package com.kitteless.kittelessfront.data;

        import lombok.Data;

        import java.time.LocalDateTime;
        import java.util.Date;

@Data
public class History {
    LocalDateTime date;
    Integer fee;
}