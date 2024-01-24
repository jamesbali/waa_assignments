package edu.miu.WebAppArchLab.auth;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.antlr.v4.runtime.misc.NotNull;



@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Valid
public class RegisterRequest {

    @NotNull
    private String firstname;
    private String lastname;

    @NotEmpty
    @NotNull
    @Email
    private String email;
    @NotNull
    @NotEmpty
    private String password;
    @NotNull
    @NotEmpty
    private Role role;

}
