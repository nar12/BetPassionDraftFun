package API.POJOs;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor @AllArgsConstructor
public class RequestLogin {
    private String username;
    private String password;
    private String skinId;
    private String parentId;
}
