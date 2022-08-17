package br.com.rodrigodonizettio.kafka;

import br.com.rodrigodonizettio.model.Pokemon;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class PokemonConsumerTest {
    final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    final PrintStream originalOut = System.out;

    @InjectMocks
    PokemonConsumer pokemonConsumer;

    String pokemon = new Pokemon("Bulbasaur", 7, 69).toString();

    @BeforeEach
    void beforeEach() {
        System.setOut(new PrintStream(outContent));
        MockitoAnnotations.openMocks(this);
    }

    @AfterEach
    void afterEach() {
        System.setOut(originalOut);
    }

    @Test
    void shouldConsumeMessageTest() {
        pokemonConsumer.process(pokemon);
        Assertions.assertTrue(outContent.toString().contains("A pokemon appeared in the Topic 'pokemon-appear':"));
    }
}
