package betrayal.api;

import java.sql.SQLException;
import java.util.List;

import betrayal.api.database.*;
import betrayal.api.models.CharacterStatusDTO;
import betrayal.api.models.CharacterSaveDTO;
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
            @QueryParam("userName") String userName) {
        try {
            Character c = null;
            if (userName == null) {
                c = Database.database.getCharacterById(id);
            } else {
                c = Database.database.getCharacterByIdUsername(id, userName);
            }
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
    public Response saveCharacter(@Context HttpServletRequest request, CharacterSaveDTO csavedto) throws SQLException {
        Database.database.saveCharacterByPlayer(csavedto);
        System.out.println("Saving in DB");
        return Response.status(200).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getHaunt(@Context HttpServletRequest request, @QueryParam("room") String room,
            @QueryParam("omen") String omen) {
        List<String> haunt = null;
        try {
            haunt = Database.database.getHauntByOmenAndRoom(room, omen);
            System.out.println("Sending DB response");
            return Response.status(200).entity(haunt).build();
        } catch (SQLException e) {
            e.printStackTrace();
            return Response.status(500).build();
        }

    }
}
