package boost.brain.youtube.http.bean;

import lombok.Data;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

@Data
@SessionScope // сессионый бин - данные бина хранятся в сессии
@Component
public class HttpSessionBean {
    private String name;
}
