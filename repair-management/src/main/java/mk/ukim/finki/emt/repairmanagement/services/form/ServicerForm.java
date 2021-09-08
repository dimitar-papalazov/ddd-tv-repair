package mk.ukim.finki.emt.repairmanagement.services.form;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class ServicerForm {
    @NotNull
    private String name;
    @NotNull
    private String surname;
}
