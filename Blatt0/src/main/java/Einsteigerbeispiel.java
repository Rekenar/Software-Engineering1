//Philipp Fößl 11845350
public class Einsteigerbeispiel {


    public int getHammingDistance(boolean[] input1, boolean[] input2){
        int hammingdistanz = 0;
        for(int i = 0; i < input1.length; i++){
            if(input1[i] != input2[i]){
                hammingdistanz++;
            }
        }
        return hammingdistanz;
    }
}
