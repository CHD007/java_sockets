package ru.spb.etu.server;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Entity Manager Factory
 * @author Чернышов Даниил chernyshov.daniil@nicetu.spb.ru
 */
public class EMF {
    public static final EntityManagerFactory emfInstance = Persistence.createEntityManagerFactory("supplier");
}
