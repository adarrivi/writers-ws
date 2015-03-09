package org.adarrivi.writer.api.mng;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

public class NewWriterApiRq {

    private String fullName;
    private String pseudonym;
    private Set<String> allies = new HashSet<>();
    private Publisher publisher;
    private Set<String> skills = new HashSet<>();
    private LocalDate firstAppearance;

    public NewWriterApiRq(String fullName, String pseudonym, Set<String> allies, Publisher publisher, Set<String> skills,
            LocalDate firstAppearance) {
        this.fullName = fullName;
        this.pseudonym = pseudonym;
        this.allies = allies;
        this.publisher = publisher;
        this.skills = skills;
        this.firstAppearance = firstAppearance;
    }

    public String getFullName() {
        return fullName;
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
