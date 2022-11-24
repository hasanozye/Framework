package denemeler.staticCagri;

public class Islem2 {

    private int result;

    public static Islem2 islem2(int num){
        return new Islem2(num);
    }

    private Islem2(int num){
        result = num;
    }

    public Islem2 topla(int num){
        result += num;
        return this;
    }

    public Islem2 cikar(int num){
        result -= num;
        return this;
    }

    public void getResult(){
        System.out.println(result);
    }


}
