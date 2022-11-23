package denemeler.staticCagri;

public class Main1 {
    public static void main(String[] args) {
        Islem1 islem1 = new Islem1(0);
        System.out.println(
                islem1
                        .topla(3)
                        .cikar(1)
                        .topla(3)
                        .topla(4)
                        .cikar(5)
                        .getResult()
        );
    }
}
