package API.POJOs.nonExistentUserLogin;

import lombok.Data;

@Data
public class ResponseNonExistentUserLogin {
    public Boolean success;
    public Message message;
    public Integer timeElapsed;
}
