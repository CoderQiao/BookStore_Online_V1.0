package cn.qtlplay.bookstore.actions;/*
    @author 乔同良
    @date 2020/6/22 - 16:02
*/

import cn.qtlplay.bookstore.services.Service;
import com.opensymphony.xwork2.ActionSupport;

import java.util.List;

public abstract class AbstractEntityActionImpl<TEntity> extends ActionSupport implements Action<TEntity>{

    private Service<TEntity> service;

    public Service<TEntity> getService() {
        return service;
    }

    public void setService(Service<TEntity> service) {
        this.service = service;
    }

    @Override
    public TEntity get(int id) {
        return this.getService().get(id);
    }

    @Override
    public void save(TEntity entity) {
        this.getService().save(entity);
    }

    @Override
    public void delete(int id) {
        this.getService().delete(id);
    }

    @Override
    public List<TEntity> findAll() {
        return this.getService().findAll();
    }

    @Override
    public List<TEntity> findBy(String property, Object value) {
        return this.getService().findBy(property,value);
    }
}
