package API.POJOs.correctLogin;

import lombok.Data;

import java.util.ArrayList;
@Data
public class Wallet {
    public ArrayList<Integer> products;
    public String _id;
    public Integer balance;
    public String name;
    public String currency;
    public Integer priority;
}
