package denemeler.staticCagri;

public class Islem {

    private int result;

    public Islem(int num){
        result = num;
    }

    public void topla(int num){
        result += num;
    }

    public void cikar(int num){
        result -= num;
    }

    public int getResult(){
        return result;
    }


}
