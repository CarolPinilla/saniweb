/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facades;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import modulos.Estadocitas;

/**
 *
 * @author carlos
 */
@Stateless
public class EstadocitasFacade extends AbstractFacade<Estadocitas> {

    @PersistenceContext(unitName = "SaniwebPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public EstadocitasFacade() {
        super(Estadocitas.class);
    }
    
}
