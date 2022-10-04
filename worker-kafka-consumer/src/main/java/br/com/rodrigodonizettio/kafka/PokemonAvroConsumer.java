package br.com.rodrigodonizettio.kafka;

import br.com.rodrigodonizettio.avro.Pokemon;
import io.smallrye.common.annotation.Blocking;
import io.smallrye.mutiny.Multi;
import org.eclipse.microprofile.reactive.messaging.Channel;
import org.eclipse.microprofile.reactive.messaging.Incoming;
import org.jboss.resteasy.reactive.RestStreamElementType;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@ApplicationScoped
@Path("/pokemon/appear-avro")
public class PokemonAvroConsumer {
    @Channel("pokemon-appear-avro")
    Multi<Pokemon> pokemons;

    @GET
    @Produces(MediaType.SERVER_SENT_EVENTS)
    @RestStreamElementType(MediaType.TEXT_PLAIN)
    public Multi<String> stream() {
        return  pokemons.map(p -> String.format("An AVRO pokemon appeared in the Topic 'pokemon-appear-avro': " +
                        "{\"uuid\": %s, \"name\": %s, \"height\": %d, \"weight\": %d}",
                p.getUuid(), p.getName(), p.getHeight(), p.getWeight()));
    }



}
