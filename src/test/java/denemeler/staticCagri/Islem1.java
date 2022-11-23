package denemeler.staticCagri;

public class Islem1 {

    private int result;

    public Islem1(int num){
        result = num;
    }

    public Islem1 topla(int num){
        result += num;
        return this;
    }

    public Islem1 cikar(int num){
        result -= num;
        return this;
    }

    public int getResult(){
        return result;
    }


}
