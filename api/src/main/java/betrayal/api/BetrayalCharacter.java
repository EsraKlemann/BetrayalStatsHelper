package betrayal.api;

import java.io.IOException;

import betrayal.api.models.*;
import betrayal.domain.Character;
import betrayal.domain.CharacterStore;
import jakarta.servlet.http.*;
import jakarta.servlet.ServletException;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.*;

// http://localhost:8090/betrayal/api/character?id=1
@Path("/character")
public class BetrayalCharacter {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response initialize(@Context HttpServletRequest request, @QueryParam("id") int id) {
        Character c = CharacterStore.characterStore.getCharacterById(id);

        CharacterStatusDTO cdto = CharacterStatusDTO.fromCharacter(c);
        System.out.println("Sending response");
        return Response.status(200).entity(cdto).build();
    }
}
