package br.com.rodrigodonizettio.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PokemonTest {

    String pokemon = new Pokemon("Bulbasaur", 7, 69).toString();

    @Test
    void shouldGenerateValidPokemonMessageTest() {
        int validPokemonMessageLength = 89;
        Assertions.assertAll(
                () -> Assertions.assertTrue(pokemon.contains("uuid=")),
                () -> Assertions.assertEquals(validPokemonMessageLength, pokemon.length()),
                () -> Assertions.assertTrue(pokemon.contains("name='Bulbasaur'")),
                () -> Assertions.assertTrue(pokemon.contains("height=7")),
                () -> Assertions.assertTrue(pokemon.contains("weight=69"))
        );
    }
}
