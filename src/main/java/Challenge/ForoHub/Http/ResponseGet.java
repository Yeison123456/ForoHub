package Challenge.ForoHub.Http;

import lombok.*;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseGet {
    Date timestamp = new Date();
    Integer status;
    String message;
    List<?> data;
}