package at.aau.ue5.bsp3;

public abstract class Person {
    private String vorname,nachname;
    private Integer alter;

    public String getJobBeschreibung() {
        return "";
    }
    public String getBeruf(){
        return this.getClass().getSimpleName();
    }

    /**
     * Getter & Setter
     */
    public String getVorname() {
        return vorname;
    }

    public void setVorname(String vorname) {
        this.vorname = vorname;
    }

    public String getNachname() {
        return nachname;
    }

    public void setNachname(String nachname) {
        this.nachname = nachname;
    }

    public Integer getAlter() {
        return alter;
    }

    public void setAlter(Integer alter) {
        this.alter = alter;
    }
}


/**
 * public class Person {
 *     public String vorname,nachname;
 *     public Integer alter;
 *     public String beruf;
 *     public String bevorzugteProgrammierSprache;
 *     public String ide;
 *     public boolean datenbanken;
 *     public String feld;
 *     public String bevorzugtesTestFramework;
 *
 *     public String getJobBeschreibung() {
 *         switch(beruf) {
 *             case "Entwickler": return "Entwickelt Code.";
 *             case "Architekt": return "Designed die Architektur des Projekts.";
 *             case "Tester": return "Testet Code.";
 *             default: return "";
 *         }
 *     }
 * }
 */
