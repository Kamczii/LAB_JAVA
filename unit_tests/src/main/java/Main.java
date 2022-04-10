public class Main {

    public static void main(String[] args) {
        BazaPiw bazaPiw = new BazaPiw();
        ZarzadzaniePiwami zarzadzaniePiwami = new ZarzadzaniePiwami(bazaPiw);
        System.out.println(zarzadzaniePiwami.find("piwo"));
        zarzadzaniePiwami.save("piwo","25");
        System.out.println(zarzadzaniePiwami.find("piwo"));
    }

}
