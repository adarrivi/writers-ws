package org.adarrivi.writer.ws.mng;

import java.time.LocalDate;
import java.util.Set;

import org.adarrivi.writer.api.mng.Publisher;
import org.adarrivi.writer.ws.response.JsonDateDeserializer;
import org.adarrivi.writer.ws.response.JsonDateSerializer;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

public class WriterJson {

    private String name;
    private String pseudonym;
    private Set<String> allies;
    private Publisher publisher;
    private Set<String> skills;
    @JsonSerialize(using = JsonDateSerializer.class)
    @JsonDeserialize(using = JsonDateDeserializer.class)
    private LocalDate firstAppearance;

    WriterJson() {
        // Needed by Json parser
    }

    public WriterJson(String name, String pseudonym, Set<String> allies, Publisher publisher, Set<String> skills,
            LocalDate firstAppearance) {
        this.name = name;
        this.pseudonym = pseudonym;
        this.allies = allies;
        this.publisher = publisher;
        this.skills = skills;
        this.firstAppearance = firstAppearance;
    }

    public String getName() {
        return name;
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
