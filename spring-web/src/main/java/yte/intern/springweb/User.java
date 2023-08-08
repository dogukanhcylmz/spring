package yte.intern.springweb;

import jakarta.validation.constraints.*;

import java.time.LocalDate;


public record User(@NotBlank(message = "name boş olamaz") String name,
                   @NotBlank(message = "surname boş olamaz") String surname,
                   @Min(12) @Max(100)Integer age,
                   @NotBlank(message = "email boş olamaz") @Email String email,
                   String tcno,
                   @PastOrPresent LocalDate birthdate,
                   @Size(max=250) String adress,
                   @NotBlank(message = "username boş olamaz") String username
) {

    @AssertTrue
    public boolean isUserNameValid(){
        return !username.equals("admin");
    }
}
