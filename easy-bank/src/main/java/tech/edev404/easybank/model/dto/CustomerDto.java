package tech.edev404.easybank.model.dto;


import com.fasterxml.jackson.annotation.JsonAlias;
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
    @JsonAlias("customerId")
    @Null
    private Integer id;

    @JsonProperty(value = "email", required = true)
    @JsonAlias("username")
    @NotEmpty @Email
    private String email;

    @JsonProperty(value = "password", required = true) 
    @JsonAlias("pwd")
    @NotBlank
    private String password;
	
    @JsonProperty(value = "mobileNumber", required = true)
    @JsonAlias("phone")
    @NotEmpty
    private String mobileNumber;

    @JsonProperty(value = "authority", required = true)
    @JsonAlias("role") 
    private String authority;

}
