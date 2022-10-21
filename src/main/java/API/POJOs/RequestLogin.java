package API.POJOs;

import lombok.Data;

@Data
public class RequestLogin {
    private String username;
    private String password;
    private String skinId;
    private String parentId;
    public RequestLogin() {}
    public RequestLogin(String username, String password, String skinId, String parentId) {
        this.username = username;
        this.password = password;
        this.skinId = skinId;
        this.parentId = parentId;
    }
}
