package betrayal.api;

import java.sql.SQLException;
import java.util.List;

import betrayal.api.database.*;
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
            haunt = Database.database.getHauntByOmenAndRoom(room, omen);
            System.out.println("Sending DB response");
            return Response.status(200).entity(haunt).build();
        } catch (SQLException e) {
            e.printStackTrace();
            return Response.status(500).build();
        }

    }
}
