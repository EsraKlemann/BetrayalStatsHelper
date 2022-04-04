package betrayal.api;

import java.sql.SQLException;

import betrayal.api.database.*;
import betrayal.api.models.CharacterStatusDTO;
import betrayal.domain.Character;
import jakarta.servlet.http.*;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.*;

// http://localhost:8090/betrayal/api/character?id=1
@Path("/character")
public class BetrayalCharacter {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getCharacter(@Context HttpServletRequest request, @QueryParam("id") int id,
            @QueryParam("namePlayer") String namePlayer) {
        try {
            Character c = Database.database.getCharacterById(id);
            CharacterStatusDTO cdto = CharacterStatusDTO.fromCharacter(c);
            System.out.println("Sending DB response");
            return Response.status(200).entity(cdto).build();
        } catch (SQLException e) {
            e.printStackTrace();
            return Response.status(500).build();
        }

        // Character c = CharacterStore.characterStore.getCharacterById(id);
        // CharacterStatusDTO cdto = CharacterStatusDTO.fromCharacter(c);

    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response saveCharacter(@Context HttpServletRequest request, CharacterStatusDTO cdto) {
        Database.database.saveCharacterByPlayer();
        System.out.println("Saving in DB");
        return Response.status(200).build();
    }
}
