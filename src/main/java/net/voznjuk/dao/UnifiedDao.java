/**
 * 
 */
package net.voznjuk.dao;

import java.util.List;

import net.voznjuk.models.UnifiedModel;

/**
 * @author Voznjuk K
 * 
 * https://www.youtube.com/watch?v=8IpdvRk2t8s&list=PLO8jHiYKnBf5JfPvjDkRPJiKEgjdHk65V&index=30&t=2097s
 *
 */
public interface UnifiedDao<T extends UnifiedModel> {
	
	public T getById(Long id);
	
	public List<T> getAll();
	
	public void add(T model);
	
	public void update(T model);
	
	public void delete(T model);

}
