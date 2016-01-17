package org.groupout.users_and_groups.utils;

import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

public class JDBCQueryHelper<T> {
	
	/**
	 * Returns a query string for a given tableName and columnValueMap
	 * @param tableName Name of the table to insert values into
	 * @param columnValueMap Map with column name as keys and volumn values as values
	 * @return
	 */
	public static <T> String getInsertQueryFromMap(String tableName, Map<String, T> columnValueMap) {
		
		StringBuilder fQueryBuilder = new StringBuilder();
		StringBuilder lQueryBuilder = new StringBuilder();
		
		fQueryBuilder.append("INSERT INTO ");
		fQueryBuilder.append(tableName);
		fQueryBuilder.append("(");
		
		lQueryBuilder.append(" VALUES");
		lQueryBuilder.append("(");
		
		Iterator<Entry<String, T>> mapIterator = columnValueMap.entrySet().iterator();
		while (mapIterator.hasNext()) {
			Map.Entry<String, T> mapEntry = (Map.Entry<String, T>)mapIterator.next();
			fQueryBuilder.append(mapEntry.getKey());
			
			// If the data type is String, we need to enclose it in double quotes
			T value = mapEntry.getValue();
			if (value.getClass().getSimpleName().equals("String"))
				lQueryBuilder.append("'");
			
			lQueryBuilder.append(mapEntry.getValue());

			if (value.getClass().getSimpleName().equals("String"))
				lQueryBuilder.append("'");

			if (mapIterator.hasNext()) {
				fQueryBuilder.append(", ");
				lQueryBuilder.append(", ");
			}
		}
		
		fQueryBuilder.append(")");
		lQueryBuilder.append(")");
		
		fQueryBuilder.append(lQueryBuilder.toString());
		return fQueryBuilder.toString();
	}
}
