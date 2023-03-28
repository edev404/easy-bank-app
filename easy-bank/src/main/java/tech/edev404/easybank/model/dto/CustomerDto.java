package tech.edev404.easybank.model.dto;

import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import jakarta.validation.constraints.Email;
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
@JsonPropertyOrder()
public class CustomerDto {

    @JsonProperty(required = false) 
    @JsonAlias("customerId")
    @Null
    private UUID id;

    @JsonProperty(value = "email")
    @JsonAlias("username")
    @NotEmpty @Email
    private String email;

    private String password;
	
    @JsonAlias("role") 
    private String authority;

}
