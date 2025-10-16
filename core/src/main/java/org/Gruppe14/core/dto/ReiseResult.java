package org.Gruppe14.core.dto;
import java.util.List;

public class ReiseResult {
    private final String startSted;
    private final String sluttSted;
    private final List<RuteResult> ruter;

    public ReiseResult(String startSted, String sluttSted, List<RuteResult> ruter) {
        this.startSted = startSted;
        this.sluttSted = sluttSted;
        this.ruter = ruter;
    }

    public String getStartSted() {
        return startSted;
    }

    public List<RuteResult> getRuter() {
        return ruter;
    }

    public String getSluttSted() {
        return sluttSted;
    }
}
