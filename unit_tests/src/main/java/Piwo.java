import lombok.Builder;
import lombok.Value;

@Builder
@Value
public class Piwo {
    private String nazwa;
    private int procenty;
}