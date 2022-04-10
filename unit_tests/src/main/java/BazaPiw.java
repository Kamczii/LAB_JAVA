import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;

public class BazaPiw {

    private Collection<Piwo> piwa;

    public BazaPiw() {
        this.piwa = new ArrayList<>();
    }

    public Optional<Piwo> find(String name) throws IllegalArgumentException{
        return piwa.stream().filter(m -> m.getNazwa().equals(name)).findAny();
    }

    public void delete(String name) throws IllegalArgumentException{
        boolean deleted = piwa.removeIf(m -> name.equals(m.getNazwa()));
        if (!deleted) throw new IllegalArgumentException();
    }

    public void save(Piwo piwo) {
        Optional<Piwo> existing = piwa.stream()
                .filter(m -> m.getNazwa().equals(piwo.getNazwa()))
                .findAny();
        if (existing.isEmpty())
            piwa.add(piwo);
        else
            throw new IllegalArgumentException();
    }
}
