package br.com.rodrigodonizettio.kafka;

import br.com.rodrigodonizettio.model.Pokemon;
import org.eclipse.microprofile.reactive.messaging.Channel;
import org.eclipse.microprofile.reactive.messaging.Emitter;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/pokemon")
public class PokemonProducer {
    /* Kafka Connector */
    @Channel("pokemon-appear")
    Emitter<String> pokemonEmitter;

    @Channel("pokemon-appear-avro")
    Emitter<br.com.rodrigodonizettio.avro.Pokemon> pokemonAvroEmitter;

    @POST
    @Path("/appear")
    @Produces(MediaType.TEXT_PLAIN)
    public String makePokemonAppear() {
        String pokemon = new Pokemon("Bulbasaur", 7, 69).toString();
        pokemonEmitter.send(pokemon);
        return pokemon;
    }

    @POST
    @Path("/appear-avro")
    public Response makePokemonAvroAppear(br.com.rodrigodonizettio.avro.Pokemon pokemonAvro) {
        pokemonAvroEmitter.send(pokemonAvro);
        return Response.accepted().build();
    }
}
