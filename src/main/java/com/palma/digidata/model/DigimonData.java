package com.palma.digidata.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;
import java.util.stream.Collectors;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DigimonData(
        int id,
        String name,
        List<Level> levels,
        List<Type> types,
        List<Attribute> attributes,
        List<Image> images,
        List<Description> descriptions,
        List<Skill> skills
) {
    @Override
    public String toString() {
        String levelStr = levels != null && !levels.isEmpty() ? levels.get(0).level() : "Unknown";
        String typeStr = types != null && !types.isEmpty() ? types.get(0).type() : "Unknown";
        String imageUrl = images != null && !images.isEmpty() ? images.get(0).href() : "No image";

        String attributeStr = attributes != null
                ? attributes.stream().map(Attribute::attribute).collect(Collectors.joining(", "))
                : "None";

        String englishDescription = descriptions != null
                ? descriptions.stream()
                .filter(d -> d.language().equalsIgnoreCase("en_us"))
                .map(Description::description)
                .findFirst()
                .orElse("No description available.")
                : "No description available.";

        String skillList = skills != null
                ? skills.stream()
                .map(skill -> "- " + skill.skill() + ": " + skill.description())
                .collect(Collectors.joining("\n"))
                : "No skills listed.";

        return String.format("""
                🔹 Digimon Info 🔹
                ID: %d
                Name: %s
                Level: %s
                Type: %s
                Attributes: %s
                Image: %s

                📖 Description:
                %s

                🥋 Skills:
                %s
                """, id, name, levelStr, typeStr, attributeStr, imageUrl, englishDescription, skillList);
    }
}
