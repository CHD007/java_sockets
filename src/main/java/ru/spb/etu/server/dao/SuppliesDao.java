package ru.spb.etu.server.dao;

import ru.spb.etu.entities.Supply;
import ru.spb.etu.server.EMF;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.List;

public class SuppliesDao {
    public List<Supply> getSupplies() {
        EntityManager entityManager = EMF.emfInstance.createEntityManager();
        List<Supply> servers = new ArrayList<>();
        TypedQuery<Supply> query = entityManager.createQuery("from supplies ", Supply.class);
        servers.addAll(query.getResultList());
        entityManager.close();
        return servers;
    }
}
