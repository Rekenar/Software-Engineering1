import org.junit.jupiter.api.Test;
import org.opentest4j.AssertionFailedError;

import static org.junit.jupiter.api.Assertions.*;

//Philipp Fößl 11845350
public class EinstiegsbeispielTest {

    @Test
    public void correct1(){
        boolean[] testarr1 = new boolean[]{true,false,true,false};
        boolean[] testarr2 = new boolean[]{true,true,true,true};

        int hamming =  Einsteigerbeispiel.getHammingDistance(testarr1,testarr2);

        assertEquals(2,hamming, "Result of correct1 was correct!");
    }

    @Test
    public void correct2(){
        boolean[] testarr1 = new boolean[]{true,false,true,true,false};
        boolean[] testarr2 = new boolean[]{true,true,false,true,true};

        int hamming =  Einsteigerbeispiel.getHammingDistance(testarr1,testarr2);

        assertEquals(3,hamming,"Result of correct2 was correct!");
    }
    @Test
    public void incorrect1() {
        boolean[] testarr1 = new boolean[]{true, false, true, false};
        boolean[] testarr2 = new boolean[]{true, false, true};
        try {
            int hamming = Einsteigerbeispiel.getHammingDistance(testarr1, testarr2);
            assertEquals(1, hamming);
        }catch (AssertionFailedError assertionFailedError) {
            System.out.println("Result of incorrect1 was not correct!");

        }catch(ArrayIndexOutOfBoundsException a){
            System.out.println("Second Array isn't as long as the first Array!");
        }
    }

    @Test
    public void incorrect2(){
        boolean[] testarr1 = new boolean[]{};
        boolean[] testarr2 = new boolean[]{true,true,true,true};
        try{
            int hamming =  Einsteigerbeispiel.getHammingDistance(testarr1,testarr2);
            assertEquals(4,hamming);

        }catch (AssertionFailedError assertionFailedError){
            System.out.println("Result of incorrect2 was incorrect!");

        }catch(NullPointerException np){
            System.out.println("First Array is empty!");
        }

    }

}
