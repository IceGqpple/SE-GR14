package model.core.service;


import model.core.port.RuteRepositoryPort;

public class RuteService {
    private RuteRepositoryPort ruteRepositoryPort;

    public RuteService(RuteRepositoryPort ruteRepositoryPort){
        this.ruteRepositoryPort = ruteRepositoryPort;
    }
}
