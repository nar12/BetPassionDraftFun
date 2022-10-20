package API;

public class RequestLogin {
    private String username;
    private String password;
    private String skinId;
    private String parentId;

    public RequestLogin() {
    }

    public RequestLogin(String username, String password, String skinId, String parentId) {
        this.username = username;
        this.password = password;
        this.skinId = skinId;
        this.parentId = parentId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSkinId() {
        return skinId;
    }

    public void setSkinId(String skinId) {
        this.skinId = skinId;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

}
