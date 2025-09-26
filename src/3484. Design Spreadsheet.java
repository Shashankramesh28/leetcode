import java.util.ArrayList;
import java.util.List;

class Spreadsheet {
    int[][] sheet;
    public Spreadsheet(int rows) {
        sheet = new int[rows][26];
    }
    
    public void setCell(String cell, int value) {
        List<Integer> list = getRowAndColumn(cell);
        int col = list.get(0);
        int row = list.get(1);
        sheet[row][col] = value;
    }
    
    public void resetCell(String cell) {
        List<Integer> list = getRowAndColumn(cell);
        int col = list.get(0);
        int row = list.get(1);
        sheet[row][col] = 0;
    }
    
    public int getValue(String formula) {
        int val1=0,val2=0;
        String a = formula.substring(1, formula.indexOf("+"));
        String b = formula.substring(formula.indexOf("+")+1, formula.length());
        if(!isNumeric(a)){
            List<Integer> list = getRowAndColumn(a);
            int col = list.get(0);
            int row = list.get(1);
            val1 = sheet[row][col];
        }else {
            val1=Integer.parseInt(a);
        }
        if(!isNumeric(b)){
            List<Integer> list = getRowAndColumn(b);
            int col = list.get(0);
            int row = list.get(1);
            val2 = sheet[row][col];
        }else {
            val2=Integer.parseInt(b);
        }
        return val1+val2;
    }

    public static boolean isNumeric(String str) {
        if (str == null || str.isEmpty()) {
            return false;
        }
        try {
            Double.parseDouble(str);
            return true;
        } catch (NumberFormatException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static void main(String[] args) {
        Spreadsheet sh = new Spreadsheet(458);
        System.out.println(sh.getValue("=O126+10272"));
        //sh.setCell("A1",10);
    }

    private static List<Integer> getRowAndColumn(String cell){
        List<Integer> list = new ArrayList<Integer>();
        int col = Character.getNumericValue(cell.charAt(0))-10;
        int row = Integer.parseInt(cell.substring(1))-1;
        list.add(col);
        list.add(row);
        return list;
    }
}
