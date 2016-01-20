package org.groupout.users_and_groups.utils;

import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

public class JDBCQueryHelper<T> {
	
	/**
	 * Returns an insert query string for a given tableName and columnValueMap
	 * @param tableName Name of the table to insert values into
	 * @param columnValueMap Map with column name as keys and column values as values
	 * @return insert query
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

	/**
	 * Returns a delete query string for a given tableName and columnValueMap
	 * @param tableName Name of the table to delete values from
	 * @param columnValueMap Map with column name as keys and column values as values
	 * @return delete query
	 */	
	public static <T> String getDeleteQueryFromMap(String tableName, Map<String, T> columnValueMap) {
		
		StringBuilder fQueryBuilder = new StringBuilder();
		StringBuilder lQueryBuilder = new StringBuilder();
		String prefix = "";
		
		fQueryBuilder.append("DELETE FROM ");
		fQueryBuilder.append(tableName);
		fQueryBuilder.append(" WHERE (");
		
		lQueryBuilder.append(" IN  ((");
		
		Iterator<Entry<String, T>> mapIterator = columnValueMap.entrySet().iterator();
		while (mapIterator.hasNext()) {
			Map.Entry<String, T> mapEntry = (Map.Entry<String, T>)mapIterator.next();
			fQueryBuilder.append(prefix);
			fQueryBuilder.append(mapEntry.getKey());
			
			fQueryBuilder.append(prefix);
			lQueryBuilder.append(mapEntry.getValue());
			
			prefix = ",";
		}
		
		fQueryBuilder.append(")");
		lQueryBuilder.append("))");
		
		fQueryBuilder.append(lQueryBuilder.toString());
		
		return fQueryBuilder.toString();
	}
}
