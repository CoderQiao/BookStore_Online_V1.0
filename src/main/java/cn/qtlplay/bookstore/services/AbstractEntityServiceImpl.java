package cn.qtlplay.bookstore.services;/*
    @author 乔同良
    @date 2020/6/21 - 12:44
*/

import cn.qtlplay.bookstore.daos.EntityDao;

import java.util.List;

public abstract class AbstractEntityServiceImpl<TEntity> implements Service<TEntity>{
    private EntityDao<TEntity> entityDao;

    public EntityDao<TEntity> getEntityDao() {
        return entityDao;
    }

    public void setEntityDao(EntityDao<TEntity> entityDao) {
        this.entityDao = entityDao;
    }

    @Override
    public TEntity get(int id) {
        return (TEntity)entityDao.get(id);
    }

    @Override
    public void save(TEntity entity) {
        entityDao.save(entity);
    }

    @Override
    public void delete(int id) {
        entityDao.delete(id);
    }

    @Override
    public List<TEntity> findAll() {
        return entityDao.findAll();
    }

    @Override
    public List<TEntity> findBy(String property, Object value) {
        return entityDao.findBy(property,value);
    }
}
