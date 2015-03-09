package org.adarrivi.writer.api.mng;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

public class TestWriterFactory {

    public static Writer createAsimov() {
        Set<String> allies = new HashSet<>();
        allies.add("Herbert");
        allies.add("Tolkien");
        allies.add("Hickman");
        Set<String> skills = new HashSet<>();
        skills.add("Genius");
        skills.add("Amazing creativity");
        skills.add("Versatility");
        return new Writer("Isaac Asimov", "The Mule", allies, Publisher.MARVEL, skills, LocalDate.of(1962, 8, 1));
    }

    public static Writer createHerbert() {
        Set<String> allies = new HashSet<>();
        allies.add("Tolkien");
        Set<String> skills = new HashSet<>();
        skills.add("Invulnerability");
        skills.add("Clarividence");
        return new Writer("Frank Herbert", "Paul", allies, Publisher.DC, skills, LocalDate.of(1938, 4, 18));
    }

    public static NewWriterApiRq createNewWriterApiRq(Writer writer) {
        return new NewWriterApiRq(writer.getAlterEgo(), writer.getPseudonym(), writer.getAllies(), writer.getPublisher(),
                writer.getSkills(), writer.getFirstAppearance());
    }
}