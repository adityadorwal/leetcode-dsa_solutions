class Spreadsheet {
    HashMap<Integer,int[]> map;

    public Spreadsheet(int rows) {
        map = new HashMap<>();
        // for(int i=1;i<=rows;i++) map.put(i,new int[26]);
    }
    
    public void setCell(String cell, int value) {
        int col = cell.charAt(0)-'A';
        int row = Integer.parseInt(cell.substring(1));
        if(!map.containsKey(row))map.put(row,new int[26]);

        int arr[] = map.get(row);
        arr[col] = value;
    }
    
    public void resetCell(String cell) {
        int col = cell.charAt(0)-'A';
        int row = Integer.parseInt(cell.substring(1));
        if(map.containsKey(row))map.get(row)[col]=0;
    }
    
    public int getValue(String formula) {
        String [] data = (formula.substring(1)).split("\\+");

        char a=data[0].charAt(0) , b = data[1].charAt(0);
        boolean b1 = Character.isDigit(a) , b2 = Character.isDigit(b);

        if(b1 && b2)
        return Integer.parseInt(data[0])+Integer.parseInt(data[1]);
        else if(b1)
        {
            int row = Integer.parseInt(data[1].substring(1));
            int num=0;
            if(map.containsKey(row))num = map.get(row)[b-'A'];

            return Integer.parseInt(data[0])+ num;
        }
        else if(b2)
        {
            int row = Integer.parseInt(data[0].substring(1));
            int num=0;
            if(map.containsKey(row))num = map.get(row)[a-'A'];

            return Integer.parseInt(data[1])+ num;
        }
        else
        {
            int row1 = Integer.parseInt(data[0].substring(1));
            int row2 = Integer.parseInt(data[1].substring(1));
            int num1 = 0;
            if(map.containsKey(row1)) num1 = map.get(row1)[a-'A'];
            int num2 = 0;
            if(map.containsKey(row2)) num2 = map.get(row2)[b-'A'];

            return (num1+num2);
        }
    }
}

/**
 * Your Spreadsheet object will be instantiated and called as such:
 * Spreadsheet obj = new Spreadsheet(rows);
 * obj.setCell(cell,value);
 * obj.resetCell(cell);
 * int param_3 = obj.getValue(formula);
 */