package tech.edev404.easybank.model.dto;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Null;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonPropertyOrder({"id", "email", "password", "mobileNumber"})
public class CustomerDto {

    @JsonProperty(value = "id", required = false) 
    @Null
    private Integer id;

    @JsonProperty(value = "name", required = true)
    @NotEmpty
    private String name;

    @JsonProperty(value = "email", required = true)
    @NotEmpty @Email
    private String email;

    @JsonProperty(value = "password", required = true)
    @NotBlank
    private String password;
	
    @JsonProperty(value = "mobileNumber", required = true)
    @NotEmpty
    private String mobileNumber;

    @JsonProperty(value = "role", required = true)
    private String role;

    @JsonProperty(value = "createDt", required = false)
    @Null
    private String createDt;

}
