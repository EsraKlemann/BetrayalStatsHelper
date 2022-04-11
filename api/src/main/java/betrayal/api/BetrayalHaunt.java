package betrayal.api;

import java.sql.SQLException;
import java.util.List;

import betrayal.api.database.*;
import betrayal.api.models.HauntRetrieveDTO;
import jakarta.servlet.http.*;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.*;

@Path("/haunt")
public class BetrayalHaunt {
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getHaunt(@Context HttpServletRequest request, @QueryParam("room") String room,
            @QueryParam("omen") String omen) {

        List<String> haunt = null;

        try {
            haunt = Database.database.getHauntByOmenAndRoom(room, omen.toLowerCase());

            HauntRetrieveDTO hauntRetrieveDTO = new HauntRetrieveDTO(haunt.get(0), haunt.get(1), haunt.get(2));
            System.out.println("Sending Haunt DB response");
            return Response.status(200).entity(hauntRetrieveDTO).build();
        } catch (SQLException e) {
            e.printStackTrace();
            return Response.status(500).build();
        }

    }
}
