package API.POJOs.incorrectPasswordLogin;

import API.POJOs.incorrectPasswordLogin.Message;
import lombok.Data;

@Data
public class ResponseIncorrectPasswordLogin {
    private Boolean success;
    private Message message;
    private Integer timeElapsed;
}
