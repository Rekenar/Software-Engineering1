//Philipp Fößl 11845350

public class Einsteigerbeispiel {
    public static int getHammingDistance(boolean[] input1, boolean[] input2){
        if(input1.length == 0){
            throw new NullPointerException();
        }
        else if(input1.length != input2.length){
            throw new ArrayIndexOutOfBoundsException();
        }

        int hammingdistanz = 0;
        for(int i = 0; i < input1.length; i++){
            if(input1[i] != input2[i]){
                hammingdistanz++;
            }
        }
        return hammingdistanz;
    }
}