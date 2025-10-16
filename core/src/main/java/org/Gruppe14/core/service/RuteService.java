package org.Gruppe14.core.service;

import org.Gruppe14.core.port.RuteRepositoryPort;

public class RuteService {
    private RuteRepositoryPort ruteRepositoryPort;

    public RuteService(RuteRepositoryPort ruteRepositoryPort){
        this.ruteRepositoryPort = ruteRepositoryPort;
    }
}
