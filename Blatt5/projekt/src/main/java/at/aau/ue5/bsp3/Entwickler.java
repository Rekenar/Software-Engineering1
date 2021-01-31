package at.aau.ue5.bsp3;

public class Entwickler extends PersonFactory {
    private String bevorzugteProgrammierSprache;
    private Ide ide;
    private boolean datenbanken;

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

    public boolean isDatenbanken() {
        return datenbanken;
    }

    public void setDatenbanken(boolean datenbanken) {
        this.datenbanken = datenbanken;
    }
}
