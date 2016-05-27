package com.alibaba.collection;

import com.google.common.collect.HashBasedTable;

import java.util.Map;

/**
 * Created by xuliang.sxl on 2015/11/2.
 */
public class TableClass {
    public static void main(String[] args) {
        HashBasedTable<Integer, Integer, String> table = HashBasedTable.create();
        table.put(1, 1, "Rook");
        table.put(1, 2, "Knight");
        table.put(1, 3, "Bishop");
        boolean contains11 = table.contains(1, 1);
        boolean containColumn2 = table.containsColumn(2);
        boolean containsRow1 = table.containsRow(1);
        boolean containsRook = table.containsValue("Rook");
        table.remove(1, 3);
        table.get(3, 4);
        Map<Integer,String> columnMap = table.column(1);
        Map<Integer,String> rowMap = table.row(2);
        System.out.println();
    }
}
