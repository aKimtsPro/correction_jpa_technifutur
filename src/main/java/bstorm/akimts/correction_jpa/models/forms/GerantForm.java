package bstorm.akimts.correction_jpa.models.forms;

import lombok.*;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.*;
import java.time.LocalDate;

@Data
@Validated
public class GerantForm {

    @NotBlank
    @Size(min = 2, max = 50)
    private String nom;
    @NotBlank
    @Size(min = 2, max = 50)
    private String prenom;
    @PastOrPresent
    private LocalDate debutCarriere;

}
