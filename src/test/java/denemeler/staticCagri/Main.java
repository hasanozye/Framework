package denemeler.staticCagri;

public class Main {
    public static void main(String[] args) {
        Islem islem = new Islem(1);
        islem.topla(3);
        islem.cikar(1);
        System.out.println(islem.getResult());
    }
}
