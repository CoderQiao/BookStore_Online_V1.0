package cn.qtlplay.bookstore.beans;/*
    @author 乔同良
    @date 2020/6/21 - 13:04
*/

import java.util.List;

public interface Entity<TEntity> {
    /**
     * @function get an entity by id
     * @param id
     * @return an entity
     * @author CoderQiao
     */

    TEntity get(int id);

    /**
     * @function save the entity given
     * @param entity
     * @return
     * @author CoderQiao
     */

    void save(TEntity entity);

    /**
     * @function  delete an entity by id
     * @param id
     * @return
     * @author CoderQiao
     */

    void delete(int id);
    /**
     * @function get all entities in database
     * @param
     * @return List
     * @author CoderQiao
     */

    List<TEntity> findAll();

    /**
     * @function get entities which included property value
     * @param  property,value
     * @return List
     * @author CoderQiao
     */

    List<TEntity> findBy(String property,Object value);
}
