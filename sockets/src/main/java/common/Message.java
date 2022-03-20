package common;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serial;
import java.io.Serializable;

@AllArgsConstructor
@ToString
@Getter
@Setter
public class Message implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    private int number;
    private String content;
}
