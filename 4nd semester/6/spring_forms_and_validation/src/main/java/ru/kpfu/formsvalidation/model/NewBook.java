package ru.kpfu.formsvalidation.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class NewBook {

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @NotNull
    @Size(min = 5, max = 128)
    private String name;

    public void setDescription(String description) {
        this.description = description;
    }

    @NotNull

    private String description;


    public String getDescription() {
        return description;
    }

    public NewBook(@NotNull @Size(min = 5, max = 128) String name, @NotNull String description) {
        this.name = name;
        this.description = description;
    }
}
