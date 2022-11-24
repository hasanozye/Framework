package data.provider.excel;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        ExcelUtility excel = ExcelUtility.create("src/main/resources/excel.xlsx", "sayfa");

        List<String> header = new ArrayList<>(List.of("A", "B", "C", "D"));

        excel.setHeader(header);
        List<List<String>> data = new ArrayList<>();
        data.add(new ArrayList<>(List.of("11", "12", "13", "14")));
        data.add(new ArrayList<>(List.of("21", "22", "23", "24")));
        data.add(new ArrayList<>(List.of("31", "32", "33", "34")));

        excel.writeData(data);
        excel.writeExcel();

        System.out.println("Data : " + excel.getData());
        System.out.println("Header : " + excel.getHeader());
        System.out.println("Row 1 : " + excel.getRow(1));
        System.out.println("Col 1 : " + excel.getColumn(1));
    }
}
