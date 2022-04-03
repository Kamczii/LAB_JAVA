import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class MageControllerTest {

    @Mock
    MageRepository mageRepository;

    @InjectMocks
    MageController mageController;

    @Test
    public void delete_existingObject_stringDone() {
        //given
        doNothing().when(mageRepository).delete(anyString());
        //then
        assertThat(mageController.delete(anyString()));
    }

    @Test
    public void delete_nonExistingObject_stringNotFound() {
        //given
        doThrow(IllegalArgumentException.class).when(mageRepository).delete(anyString());
        //then
        assertThat(mageController.delete(anyString())).isEqualTo("Not found");
    }

    @Test
    public void find_nonExistingObject_stringNotFound() {
        //given
        when(mageRepository.find(anyString())).thenReturn(Optional.empty());
        //then
        assertThat(mageController.find(anyString())).isEqualTo("Not found");
    }

    @Test
    public void find_existingObject_stringMage() {
        //given
        Mage mage = Mage.builder().name("Mag").level(250).build();
        when(mageRepository.find(anyString())).thenReturn(Optional.of(mage));
        //then
        assertThat(mageController.find(anyString())).isEqualTo(mage.toString());
    }

    @Test
    public void save_nonExisting_stringDone() {
        //given
        doNothing().when(mageRepository).save(any());
        //then
        assertThat(mageController.save("mag1","250")).isEqualTo("Done");
    }

    @Test
    public void save_existingId_stringBadRequest() {
        //given
        doThrow(IllegalArgumentException.class).when(mageRepository).save(any());
        //then
        assertThat(mageController.save("mag1","250")).isEqualTo("Bad request");
    }
}