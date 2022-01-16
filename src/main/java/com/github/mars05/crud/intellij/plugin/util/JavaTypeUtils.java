package com.github.mars05.crud.intellij.plugin.util;

import java.math.BigDecimal;
import java.sql.JDBCType;
import java.sql.Types;
import java.util.Date;
import java.util.LinkedHashMap;

/**
 * @author xiaoyu
 */
public class JavaTypeUtils {
    private static LinkedHashMap<JDBCType, Class> map = new LinkedHashMap();

    static {
        //String type
        map.put(JDBCType.VARCHAR, String.class);
        map.put(JDBCType.LONGVARCHAR, String.class);
        map.put(JDBCType.CHAR, String.class);
        //Integer type
        map.put(JDBCType.INTEGER, Integer.class);
        map.put(JDBCType.BIGINT, Long.class);
        map.put(JDBCType.SMALLINT, Integer.class);
        map.put(JDBCType.TINYINT, Integer.class);
        //floating point type
        map.put(JDBCType.FLOAT, Float.class);
        map.put(JDBCType.DOUBLE, Double.class);
        map.put(JDBCType.DECIMAL, BigDecimal.class);
        //other types
        map.put(JDBCType.BOOLEAN, Boolean.class);
        map.put(JDBCType.DATE, Date.class);
        map.put(JDBCType.TIME, Date.class);
        map.put(JDBCType.TIMESTAMP, Date.class);
        map.put(JDBCType.BIT, boolean.class);
    }

    /**
     * Database field type to Java type
     *
     * @param sqlType
     * @see Types
     * @see JDBCType
     */
    public static Class convertType(int sqlType) {
        return map.getOrDefault(JDBCType.valueOf(sqlType), Object.class);
    }

}


