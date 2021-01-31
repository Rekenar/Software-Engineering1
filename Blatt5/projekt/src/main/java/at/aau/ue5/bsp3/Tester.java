package at.aau.ue5.bsp3;

public class Tester extends PersonFactory{

    private String bevorzugtesTestFramework;

    @Override
    public String getJobBeschreibung() {
        return "Testet Code.";
    }

    public String getBevorzugtesTestFramework() {
        return bevorzugtesTestFramework;
    }

    public void setBevorzugtesTestFramework(String bevorzugtesTestFramework) {
        this.bevorzugtesTestFramework = bevorzugtesTestFramework;
    }
}
