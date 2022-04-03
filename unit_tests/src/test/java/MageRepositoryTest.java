import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

import java.util.Optional;

public class MageRepositoryTest {

    MageRepository mageRepository;

    Mage mage1;
    Mage mage2;

    @BeforeEach
    private void init() {
        mageRepository = new MageRepository();

        mage1 = Mage.builder()
                .name("Mag1")
                .level(25)
                .build();

        mage2 = Mage.builder()
                .name("Mag2")
                .level(67)
                .build();

        mageRepository.save(mage1);
        mageRepository.save(mage2);
    }

    @Test
    public void find_nonExistingMageId_emptyOptional() {
        String mageId = "Mag3";
        assertThat(mageRepository.find(mageId)).isEqualTo(Optional.empty());
    }

    @Test
    public void find_existingMageId_nonEmptyMageOptional() {

        String mageId1 = "Mag1";
        String mageId2 = "Mag2";

        assertThat(mageRepository.find(mageId1)).isEqualTo(Optional.of(mage1));
        assertThat(mageRepository.find(mageId2)).isEqualTo(Optional.of(mage2));
    }

    @Test
    public void delete_nonExistingMageId_IllegalArgumentException() {
        String mageId = "Mag3";
        assertThatIllegalArgumentException().isThrownBy(()->mageRepository.delete(mageId));
    }

    @Test
    public void save_existingMageId_IllegalArgumentException() {
        Mage mage = Mage.builder()
                .name("Mag1")
                .level(26)
                .build();
        assertThatIllegalArgumentException().isThrownBy(()->mageRepository.save(mage));
    }
}