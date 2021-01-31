package at.aau.ue5.bsp3;

public class test {
    public static void main(String[] args) {

        Architekt architekt = PersonFactory.getArchitekt();
        Entwickler entwickler = PersonFactory.getEntwickler();
        Tester tester = PersonFactory.getTester();

        System.out.println(architekt.getBeruf());
        System.out.println(entwickler.getBeruf());
        System.out.println(tester.getBeruf());

        System.out.println(architekt.getJobBeschreibung());
        System.out.println(entwickler.getJobBeschreibung());
        System.out.println(tester.getJobBeschreibung());

    }
}
