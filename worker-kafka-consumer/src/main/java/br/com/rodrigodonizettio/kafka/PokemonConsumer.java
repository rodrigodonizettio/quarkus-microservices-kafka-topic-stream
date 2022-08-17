package br.com.rodrigodonizettio.kafka;

import io.smallrye.common.annotation.Blocking;
import org.eclipse.microprofile.reactive.messaging.Incoming;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class PokemonConsumer {
    @Incoming("pokemon-appear")
    @Blocking
    public void process(String appearedPokemon) {
        System.out.println(String.format("A pokemon appeared in the Topic 'pokemon-appear': %s", appearedPokemon));
    }
}
