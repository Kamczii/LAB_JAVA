import java.util.Optional;

public class MageController {
    private MageRepository repository;
    public MageController(MageRepository repository) {
        this.repository = repository;
    }

    public String find(String name) {
        Optional<Mage> mage = repository.find(name);
        if (mage.isEmpty())
            return "Not found";
        else
            return mage.get().toString();
    }

    public String delete(String name) {
        try {
            repository.delete(name);
            return "Done";
        } catch (IllegalArgumentException e) {
            return "Not found";
        }
    }

    public String save(String name, String level) {
        try {
            repository.save(new Mage(name,Integer.valueOf(level)));
            return "Done";
        } catch (IllegalArgumentException e) {
            return "Bad request";
        }
    }
}
