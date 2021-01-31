package at.aau.ue5.bsp3;

public class Architekt extends PersonFactory{

    private Feld feld;

    @Override
    public String getJobBeschreibung() {
        return "Designed die Architektur des Projekts.";
    }

    public Feld getFeld() {
        return feld;
    }

    public void setFeld(Feld feld) {
        this.feld = feld;
    }
}
