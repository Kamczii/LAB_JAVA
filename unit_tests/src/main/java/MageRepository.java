import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;

public class MageRepository {

    private Collection<Mage> collection;

    public MageRepository() {
        this.collection = new ArrayList<>();
    }

    public Optional<Mage> find(String name) throws IllegalArgumentException{
        return collection.stream().filter(m -> m.getName().equals(name)).findAny();
    }

    public void delete(String name) throws IllegalArgumentException{
        boolean deleted = collection.removeIf(m -> name.equals(m.getName()));
        if (!deleted) throw new IllegalArgumentException();
    }

    public void save(Mage mage) {
        Optional<Mage> existing = collection.stream()
                .filter(m -> m.getName().equals(mage.getName()))
                .findAny();
        if (existing.isEmpty())
            collection.add(mage);
        else
            throw new IllegalArgumentException();
    }
}
