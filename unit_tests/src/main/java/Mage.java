import lombok.Builder;
import lombok.Value;

@Builder
@Value
public class Mage {
    private String name;
    private int level;
}