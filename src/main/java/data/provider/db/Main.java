package data.provider.db;

public class Main {

    public static void main(String[] args) {
        DBUtility db = new DBUtility("jdbc:mysql://localhost:3306/sakila","root", "");
        String sql1 = "SELECT first_name, last_name FROM actor LIMIT 10";

        System.out.println(db.getData(sql1));
        String sql2 = "SELECT country, gender, avgLength FROM (" +
                " SELECT country, gender, AVG(length) AS avgLength" +
                " FROM personel" +
                " GROUP BY gender, country" +
                " ORDER BY country, gender" +
                " ) AS personelTablosu" +
                " WHERE gender = 'Male' AND avgLength>1.7" +
                " LIMIT 10";
        System.out.println(db.getData(sql2));
        db.close();
    }

}
