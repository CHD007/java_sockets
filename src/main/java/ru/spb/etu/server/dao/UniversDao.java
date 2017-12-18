package ru.spb.etu.server.dao;

import ru.spb.etu.entities.Univer;
import ru.spb.etu.server.EMF;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.List;

public class UniversDao {
    public List<Univer> getUnivers() {
        EntityManager entityManager = EMF.emfInstance.createEntityManager();
        List<Univer> servers = new ArrayList<>();
        TypedQuery<Univer> query = entityManager.createQuery("from universities ", Univer.class);
        servers.addAll(query.getResultList());
        entityManager.close();
        return servers;
    }
}
