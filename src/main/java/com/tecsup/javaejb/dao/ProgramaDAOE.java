/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tecsup.javaejb.dao;

import com.tecsup.javaejb.model.Programa;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 *
 * @author alumno
 */
@Stateless
public class ProgramaDAOE implements ProgramaDAO {

    @PersistenceContext
    private EntityManager em;

    @Override
    public List<Programa> all() {
        TypedQuery<Programa> query = em.createQuery("Select a from Programa a", Programa.class);
        return query.getResultList();
    }

    @Override
    public Programa find(Long id) {
        return em.find(Programa.class, id);
    }

    @Override
    public void save(Programa programa) {
        em.persist(programa);
    }

    @Override
    public void update(Programa programa) {
        em.merge(programa);
    }

    @Override
    public void delete(Programa programa) {
        Programa delete = em.merge(programa);
        em.remove(delete);
    }
}
