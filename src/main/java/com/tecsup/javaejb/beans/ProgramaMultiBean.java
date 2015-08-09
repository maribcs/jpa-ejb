/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tecsup.javaejb.beans;

import com.tecsup.javaejb.dao.ProgramaDAO;
import com.tecsup.javaejb.model.Programa;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.inject.Inject;

/**
 *
 * @author alumno
 */
@ManagedBean
@RequestScoped
public class ProgramaMultiBean {

    @Inject
    ProgramaDAO programaDAO;
    private List<Programa> programas = new ArrayList();
    private Programa programa = new Programa();

    public String update(Programa pro) {
        this.programa = pro;
        return "programaForm.xhtml";
    }

    public String save() {
        if (programa.getId() == null) {
            programaDAO.save(programa);
        } else {
            programaDAO.update(programa);
        }
        this.programa = new Programa();
        return "programaindex.xhtml";
    }

    public void delete(Programa programa) {
        programaDAO.delete(programa);
    }

    public List<Programa> getProgramas() {
        programas = programaDAO.all();
        return programas;
    }

    public Programa getPrograma() {
        return programa;
    }
    
}
