package forms;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class LoginForm {
    private String name;
    private String password;
}
