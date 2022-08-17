package br.com.rodrigodonizettio.model;

import java.util.UUID;

public class Pokemon {
    private UUID uuid;
    private String name;
    private Integer height;
    private Integer weight;

    /* For Jackson Serializer */
    public Pokemon() { }

    public Pokemon(String name, Integer height, Integer weight) {
        this.uuid = UUID.randomUUID();
        this.name = name;
        this.height = height;
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Pokemon{" +
                "uuid=" + uuid +
                ", name='" + name + '\'' +
                ", height=" + height +
                ", weight=" + weight +
                '}';
    }

    public UUID getUuid() { return uuid; }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }
}
