package controlador;

import controlador.exceptions.NonexistentEntityException;
import controlador.exceptions.PreexistingEntityException;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaQuery;
import modelo.Pacientes;

public class PacientesJpaController implements Serializable {

    private EntityManagerFactory emf = null;

    public PacientesJpaController() {
        this.emf = Persistence.createEntityManagerFactory("com.mycompany_Citas_proyecto_jar_1.0-SNAPSHOTPU");
    }

    public PacientesJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Pacientes pacientes) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(pacientes);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findPacientes(pacientes.getPacIdentificacion()) != null) {
                throw new PreexistingEntityException("El paciente " + pacientes + " ya existe.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Pacientes pacientes) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            pacientes = em.merge(pacientes);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = pacientes.getPacIdentificacion();
                if (findPacientes(id) == null) {
                    throw new NonexistentEntityException("El paciente con id " + id + " no existe.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Integer id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Pacientes pacientes;
            try {
                pacientes = em.getReference(Pacientes.class, id);
                pacientes.getPacIdentificacion();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("El paciente con id " + id + " no existe.", enfe);
            }
            em.remove(pacientes);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Pacientes> findPacientesEntities() {
        return findPacientesEntities(true, -1, -1);
    }

    public List<Pacientes> findPacientesEntities(int maxResults, int firstResult) {
        return findPacientesEntities(false, maxResults, firstResult);
    }

    private List<Pacientes> findPacientesEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Pacientes.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public Pacientes findPacientes(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Pacientes.class, id);
        } finally {
            em.close();
        }
    }

    public int getPacientesCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            javax.persistence.criteria.Root<Pacientes> rt = cq.from(Pacientes.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }

    public List<Pacientes> findPacientesPorFiltro(int parametro, String valor) {
    EntityManager em = getEntityManager();
    try {
        String jpql = "SELECT p FROM Pacientes p ";
        
        switch (parametro) {
            case 1:
                jpql += "WHERE p.pacIdentificacion LIKE :valor";
                break;
            case 2:
                jpql += "WHERE p.pacNombre LIKE :valor";
                break;
            case 3:
                jpql += "WHERE p.pacApellidos LIKE :valor";
                break;
            case 4:
                jpql += "WHERE p.pacSexo LIKE :valor";
                break;
            default:
                jpql += "ORDER BY p.pacApellidos ASC";
                break;
        }
        
        javax.persistence.TypedQuery<Pacientes> query = em.createQuery(jpql, Pacientes.class);
        
        if (parametro >= 1 && parametro <= 4) {
            query.setParameter("valor", "%" + valor + "%");
        }
        
        return query.getResultList();
        
    } finally {
        em.close();
    }
}
}
        

