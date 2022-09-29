package dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Company {

    public String name;
    public String catchPhrase;

    @JsonProperty("bs")
    public String business;

}
