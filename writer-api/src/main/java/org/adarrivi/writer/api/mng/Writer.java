package org.adarrivi.writer.api.mng;

import java.time.LocalDate;
import java.util.Set;

public class Writer {

    private String alterEgo;
    private String pseudonym;
    private Set<String> allies;
    private Publisher publisher;
    private Set<String> skills;
    private LocalDate firstAppearance;

    Writer(String alterEgo, String pseudonym, Set<String> allies, Publisher publisher, Set<String> skills, LocalDate firstAppearance) {
        this.alterEgo = alterEgo;
        this.pseudonym = pseudonym;
        this.allies = allies;
        this.publisher = publisher;
        this.skills = skills;
        this.firstAppearance = firstAppearance;
    }

    public String getAlterEgo() {
        return alterEgo;
    }

    public String getPseudonym() {
        return pseudonym;
    }

    public Set<String> getAllies() {
        return allies;
    }

    public Publisher getPublisher() {
        return publisher;
    }

    public Set<String> getSkills() {
        return skills;
    }

    public LocalDate getFirstAppearance() {
        return firstAppearance;
    }

}
