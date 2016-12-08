/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facades;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import modulos.Antecedentes;

/**
 *
 * @author carlos
 */
@Stateless
public class AntecedentesFacade extends AbstractFacade<Antecedentes> {

    @PersistenceContext(unitName = "SaniwebPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public AntecedentesFacade() {
        super(Antecedentes.class);
    }
    
}
