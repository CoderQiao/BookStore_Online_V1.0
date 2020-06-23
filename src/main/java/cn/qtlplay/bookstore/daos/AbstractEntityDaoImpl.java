package cn.qtlplay.bookstore.daos;/*
    @author 乔同良
    @date 2020/6/21 - 11:56
*/


import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

public abstract class AbstractEntityDaoImpl<TEntity> extends BaseDao implements EntityDao<TEntity> {

    private Class<TEntity> entityClass;

    public AbstractEntityDaoImpl() {
        Class<?> c = this.getClass();
        Type t = c.getGenericSuperclass();
        if (t instanceof ParameterizedType) {
            Type[] types = ((ParameterizedType)t).getActualTypeArguments();
            entityClass = (Class<TEntity>)types[0];
        }
    }

    @Override
    public TEntity get(int id) {
        TEntity entity = (TEntity)getSession().get(entityClass, id);
        return entity;
    }

    @Override
    public void save(TEntity entity) {
        getSession().saveOrUpdate(entity);
    }

    @Override
    public void delete(int id) {
        TEntity entity = get(id);
        getSession().delete(entity);
    }

    @Override
    public List<TEntity> findAll() {
        List<TEntity> entities = this.getSession().createQuery("from " + entityClass.getSimpleName()).list();
        return entities;
    }

    @Override
    public List<TEntity> findBy(String property,Object value) {
        String queryString = "from " + entityClass.getSimpleName() + " e ";
        queryString += "where e." + property + "=:value";
        List<TEntity> entities = this.getSession().createQuery(queryString).setParameter("value", value).list();
        return entities;
    }
}
