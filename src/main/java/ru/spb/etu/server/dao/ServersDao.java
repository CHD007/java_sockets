package ru.spb.etu.server.dao;

import ru.spb.etu.entities.RackmountServer;
import ru.spb.etu.server.EMF;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.List;

public class ServersDao {

    public List<RackmountServer> getServers() {
        EntityManager entityManager = EMF.emfInstance.createEntityManager();
        List<RackmountServer> servers = new ArrayList<>();
        TypedQuery<RackmountServer> query = entityManager.createQuery("from servers ", RackmountServer.class);
        servers.addAll(query.getResultList());
        entityManager.close();
        return servers;
    }
}
