package org.groupout.users_and_groups.classes;

public interface DataManager<T> {
	public void setValue(String column, T value);
	public T getValue(String column);
	public boolean insert();
	public boolean update();
}
