import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

import java.util.Optional;

public class PiwoRepositoryTest {

    BazaPiw bazaPiw;

    Piwo piwo1;
    Piwo piwo2;

    @BeforeEach
    private void init() {
        bazaPiw = new BazaPiw();

        piwo1 = Piwo.builder()
                .nazwa("Beer1")
                .procenty(25)
                .build();

        piwo2 = Piwo.builder()
                .nazwa("Beer2")
                .procenty(67)
                .build();

        bazaPiw.save(piwo1);
        bazaPiw.save(piwo2);
    }

    @Test
    public void find_nonExistingMageId_emptyOptional() {
        String mageId = "Beer3";
        assertThat(bazaPiw.find(mageId)).isEqualTo(Optional.empty());
    }

    @Test
    public void find_existingMageId_nonEmptyMageOptional() {

        String mageId1 = "Beer1";
        String mageId2 = "Beer2";

        assertThat(bazaPiw.find(mageId1)).isEqualTo(Optional.of(piwo1));
        assertThat(bazaPiw.find(mageId2)).isEqualTo(Optional.of(piwo2));
    }

    @Test
    public void delete_nonExistingMageId_IllegalArgumentException() {
        String mageId = "Beer3";
        assertThatIllegalArgumentException().isThrownBy(()-> bazaPiw.delete(mageId));
    }

    @Test
    public void save_existingMageId_IllegalArgumentException() {
        Piwo piwo = Piwo.builder()
                .nazwa("Beer1")
                .procenty(26)
                .build();
        assertThatIllegalArgumentException().isThrownBy(()-> bazaPiw.save(piwo));
    }
}