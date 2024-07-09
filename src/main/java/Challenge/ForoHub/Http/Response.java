package Challenge.ForoHub.Http;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Response {
    Date timestamp = new Date();
    Integer status;
    String message;
}
