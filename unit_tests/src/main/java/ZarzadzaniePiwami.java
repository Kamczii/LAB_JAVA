import java.util.Optional;

public class ZarzadzaniePiwami {
    private BazaPiw bazaPiw;
    public ZarzadzaniePiwami(BazaPiw bazaPiw) {
        this.bazaPiw = bazaPiw;
    }

    public String find(String name) {
        Optional<Piwo> mage = bazaPiw.find(name);
        if (mage.isEmpty())
            return "Not found";
        else
            return mage.get().toString();
    }

    public String delete(String name) {
        try {
            bazaPiw.delete(name);
            return "Done";
        } catch (IllegalArgumentException e) {
            return "Not found";
        }
    }

    public String save(String name, String level) {
        try {
            bazaPiw.save(new Piwo(name,Integer.valueOf(level)));
            return "Done";
        } catch (IllegalArgumentException e) {
            return "Bad request";
        }
    }
}
