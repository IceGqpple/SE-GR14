package org.Gruppe14.core.service;

import org.Gruppe14.core.port.ReiseRepositoryPort;

public class ReiseService {
    private ReiseRepositoryPort reiseRepositoryPort;

    public ReiseService(ReiseRepositoryPort reiseRepositoryPort){
        this.reiseRepositoryPort = reiseRepositoryPort;

    }
}
