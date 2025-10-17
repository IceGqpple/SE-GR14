package model.core.service;


import model.core.port.ReiseRepositoryPort;

public class ReiseService {
    private ReiseRepositoryPort reiseRepositoryPort;

    public ReiseService(ReiseRepositoryPort reiseRepositoryPort){
        this.reiseRepositoryPort = reiseRepositoryPort;

    }
}
