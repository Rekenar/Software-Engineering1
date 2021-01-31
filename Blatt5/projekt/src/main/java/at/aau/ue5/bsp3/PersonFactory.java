package at.aau.ue5.bsp3;

public abstract class PersonFactory implements Person {
    private String vorname,nachname;
    private Integer alter;



    public static Architekt getArchitekt(){
        return new Architekt();
    }
    public static Entwickler getEntwickler(){
        return new Entwickler();
    }
    public static Tester getTester(){
        return new Tester();
    }



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
