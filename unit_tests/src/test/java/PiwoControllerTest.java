import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class PiwoControllerTest {

    @Mock
    BazaPiw bazaPiw;

    @InjectMocks
    ZarzadzaniePiwami zarzadzaniePiwami;

    @Test
    public void delete_existingObject_stringDone() {
        //given
        doNothing().when(bazaPiw).delete(anyString());
        //then
        assertThat(zarzadzaniePiwami.delete(anyString()));
    }

    @Test
    public void delete_nonExistingObject_stringNotFound() {
        //given
        doThrow(IllegalArgumentException.class).when(bazaPiw).delete(anyString());
        //then
        assertThat(zarzadzaniePiwami.delete(anyString())).isEqualTo("Not found");
    }

    @Test
    public void find_nonExistingObject_stringNotFound() {
        //given
        when(bazaPiw.find(anyString())).thenReturn(Optional.empty());
        //then
        assertThat(zarzadzaniePiwami.find(anyString())).isEqualTo("Not found");
    }

    @Test
    public void find_existingObject_stringMage() {
        //given
        Piwo piwo = Piwo.builder().nazwa("Beer").procenty(250).build();
        when(bazaPiw.find(anyString())).thenReturn(Optional.of(piwo));
        //then
        assertThat(zarzadzaniePiwami.find(anyString())).isEqualTo(piwo.toString());
    }

    @Test
    public void save_nonExisting_stringDone() {
        //given
        doNothing().when(bazaPiw).save(any());
        //then
        assertThat(zarzadzaniePiwami.save("Beer1","250")).isEqualTo("Done");
    }

    @Test
    public void save_existingId_stringBadRequest() {
        //given
        doThrow(IllegalArgumentException.class).when(bazaPiw).save(any());
        //then
        assertThat(zarzadzaniePiwami.save("Beer1","250")).isEqualTo("Bad request");
    }
}