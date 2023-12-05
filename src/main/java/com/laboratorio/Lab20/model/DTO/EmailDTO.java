package com.laboratorio.Lab20.model.DTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EmailDTO {
    @NotBlank(message = "el campo nombre es obligatorio")
    @NotNull(message = "el nombre no puede ser nulo")
    private String name;

    @NotBlank(message = "el campo email es obligatorio")
    @NotNull(message = "el email no puede ser nulo")
    private String email;

    @NotBlank(message = "el email debe tener un mensaje")
    @NotNull(message = "el mensaje no puede ser nulo")
    private String message;
}
