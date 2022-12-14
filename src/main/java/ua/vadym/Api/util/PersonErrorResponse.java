package ua.vadym.Api.util;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PersonErrorResponse {
    private  String message;

    private LocalDate data = LocalDate.now();
}
