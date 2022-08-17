package br.com.rodrigodonizettio.kafka;

import br.com.rodrigodonizettio.model.Pokemon;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

public class PokemonProducerTest {
    @Mock
    PokemonProducer pokemonProducer;

    String pokemon = new Pokemon("Bulbasaur", 7, 69).toString();

    @BeforeEach
    void beforeEach() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void shouldProduceMessageTest() {
        Mockito.when(pokemonProducer.makePokemonAppear()).thenReturn(pokemon);
        Assertions.assertEquals(pokemon, pokemonProducer.makePokemonAppear());
    }
}
