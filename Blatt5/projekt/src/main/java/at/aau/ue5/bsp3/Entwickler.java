package at.aau.ue5.bsp3;

public class Entwickler extends Person {
    private String bevorzugteProgrammierSprache;
    private Ide ide;
    private boolean datenbanken;

    public Entwickler(String bevorzugteProgrammierSprache, Ide ide, boolean datenbanken) {
        this.bevorzugteProgrammierSprache = bevorzugteProgrammierSprache;
        this.ide = ide;
        this.datenbanken = datenbanken;
    }

    @Override
    public String getJobBeschreibung() {
        return "Entwickelt Code.";
    }

    public String getBevorzugteProgrammierSprache() {
        return bevorzugteProgrammierSprache;
    }

    public void setBevorzugteProgrammierSprache(String bevorzugteProgrammierSprache) {
        this.bevorzugteProgrammierSprache = bevorzugteProgrammierSprache;
    }

    public Ide getIde() {
        return ide;
    }

    public void setIde(Ide ide) {
        this.ide = ide;
    }

    public boolean getDatenbanken() {
        return datenbanken;
    }

    public void setDatenbanken(boolean datenbanken) {
        this.datenbanken = datenbanken;
    }
}
