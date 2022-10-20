package API;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.ArrayList;

// import com.fasterxml.jackson.databind.ObjectMapper; // version 2.11.1
// import com.fasterxml.jackson.annotation.JsonProperty; // version 2.11.1
/* ObjectMapper om = new ObjectMapper();
Root root = om.readValue(myJsonString, Root.class); */
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

    public Integer getExp() {
        return exp;
    }

    public void setExp(Integer exp) {
        this.exp = exp;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Boolean getAltCurrency() {
        return altCurrency;
    }

    public void setAltCurrency(Boolean altCurrency) {
        this.altCurrency = altCurrency;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public Boolean getForcedToChangePassword() {
        return forcedToChangePassword;
    }

    public void setForcedToChangePassword(Boolean forcedToChangePassword) {
        this.forcedToChangePassword = forcedToChangePassword;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getNationalId() {
        return nationalId;
    }

    public void setNationalId(String nationalId) {
        this.nationalId = nationalId;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public ArrayList<Integer> getParents() {
        return parents;
    }

    public void setParents(ArrayList<Integer> parents) {
        this.parents = parents;
    }

    public Integer getPermission() {
        return permission;
    }

    public void setPermission(Integer permission) {
        this.permission = permission;
    }

    public PersonalInfo getPersonalInfo() {
        return personalInfo;
    }

    public void setPersonalInfo(PersonalInfo personalInfo) {
        this.personalInfo = personalInfo;
    }

    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public ArrayList<Wallet> getWallets() {
        return wallets;
    }

    public void setWallets(ArrayList<Wallet> wallets) {
        this.wallets = wallets;
    }

    public ResponseSuccessLoginResult(Integer exp, String token, Boolean altCurrency, String countryCode, Boolean forcedToChangePassword, Integer id, String message, String nationalId, String nickname, ArrayList<Integer> parents, Integer permission, PersonalInfo personalInfo, Integer typeId, String username, ArrayList<Wallet> wallets) {
        this.exp = exp;
        this.token = token;
        this.altCurrency = altCurrency;
        this.countryCode = countryCode;
        this.forcedToChangePassword = forcedToChangePassword;
        this.id = id;
        this.message = message;
        this.nationalId = nationalId;
        this.nickname = nickname;
        this.parents = parents;
        this.permission = permission;
        this.personalInfo = personalInfo;
        this.typeId = typeId;
        this.username = username;
        this.wallets = wallets;
    }

    public ResponseSuccessLoginResult() {
    }

    public class PersonalInfo{
        public PersonalInfo() {
        }
    }

    public class Wallet{
        public Wallet() {
        }

        public ArrayList<Integer> getProducts() {
            return products;
        }

        public void setProducts(ArrayList<Integer> products) {
            this.products = products;
        }

        public String get_id() {
            return _id;
        }

        public void set_id(String _id) {
            this._id = _id;
        }

        public Integer getBalance() {
            return balance;
        }

        public void setBalance(Integer balance) {
            this.balance = balance;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getCurrency() {
            return currency;
        }

        public void setCurrency(String currency) {
            this.currency = currency;
        }

        public Integer getPriority() {
            return priority;
        }

        public void setPriority(Integer priority) {
            this.priority = priority;
        }

        public Wallet(ArrayList<Integer> products, String _id, Integer balance, String name, String currency, Integer priority) {
            this.products = products;
            this._id = _id;
            this.balance = balance;
            this.name = name;
            this.currency = currency;
            this.priority = priority;
        }

        public ArrayList<Integer> products;
        public String _id;
        public Integer balance;
        public String name;
        public String currency;
        public Integer priority;
    }
}
