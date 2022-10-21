package API.POJOs.correctLogin;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import java.util.ArrayList;

// import com.fasterxml.jackson.databind.ObjectMapper; // version 2.11.1
// import com.fasterxml.jackson.annotation.JsonProperty; // version 2.11.1
/* ObjectMapper om = new ObjectMapper();
Root root = om.readValue(myJsonString, Root.class); */
@Data
public class ResponseSuccessLoginResult {
    public Integer exp;
    public String token;
    public Boolean altCurrency;
    public String countryCode;
    public Boolean forcedToChangePassword;
    public Integer id;
    public String message;
    public String nationalId;
    public String nickname;
    public ArrayList<Integer> parents;
    public Integer permission;
    @JsonIgnore
    public PersonalInfo personalInfo;
    public Integer typeId;
    public String username;
    @JsonIgnore
    public ArrayList<Wallet> wallets;
}
