package models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class ListDataResponse {
    private String total;
    private ListResponseModel [] data;
}
