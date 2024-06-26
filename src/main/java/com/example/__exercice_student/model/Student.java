package com.example.__exercice_student.model;

import com.example.__exercice_student.validation.MyValid;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Student {
    private Long id;
    @NotNull(message = "Ce champ doit être rempli !")
    @Size(min = 3, message = "3 minimum svp !")
    @NotBlank()
    @MyValid()
    private String firstname;
    @NotNull(message = "Ce champ doit être rempli !")
    @NotBlank()
    @MyValid(value = "tu", message = "Le message doit contenir tu !")
    private String lastname;
    @NotNull(message = "Ce champ doit être rempli !")
    @Min(18)
    @Max(120)
    private int age;
    @NotNull(message = "Ce champ doit être rempli !")
    @Pattern(
            regexp = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Z]{2,6}$",
            flags = Pattern.Flag.CASE_INSENSITIVE,
            message = "Veuillez rentrer un mail valide!!!"
    )
    private String email;
}
