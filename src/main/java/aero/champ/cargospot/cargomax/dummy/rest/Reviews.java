package aero.champ.cargospot.cargomax.dummy.rest;

import aero.champ.cargospot.cargomax.dummy.beans.ReviewRequest;
import aero.champ.cargospot.cargomax.dummy.beans.ReviewResponse;
import aero.champ.cargospot.cargomax.dummy.db.InMemoryDB;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;


/**
 * Rest webservice for Review Requests.
 *
 * @version  $Revision$, $Date$
 */
@Path("/reviews")
public class Reviews
{
	//~ Methods ----------------------------------
	/**
	 * All Review Requests.
	 *
	 * @return
	 */
	@GET
	@Path("/requests")
	@Produces(MediaType.APPLICATION_JSON)
	public List<ReviewRequest> allReviews()
	{
		InMemoryDB inMemoryDB = InMemoryDB.fromContext();

		return inMemoryDB.getAllReviewRequests();
	}
	
	/**
	 * All Review Responses.
	 *
	 * @return
	 */
	@GET
	@Path("/responses")
	@Produces(MediaType.APPLICATION_JSON)
	public List<ReviewResponse> allResponses()
	{
		InMemoryDB inMemoryDB = InMemoryDB.fromContext();

		return inMemoryDB.getAllReviewResponses();
	}
	
	/**
	 * Delete all Review Requests stored in the webservice.
	 */
	@POST
	@Path("/requests/clear")
	public void clearAllReviewRequests()
	{
		InMemoryDB inMemoryDB = InMemoryDB.fromContext();

		inMemoryDB.deleteAllReviewRequests();
	}
	
	/**
	 * Delete all Review Responses stored in the webservice.
	 */
	@POST
	@Path("/responses/clear")
	public void clearAllReviewResponses()
	{
		InMemoryDB inMemoryDB = InMemoryDB.fromContext();

		inMemoryDB.deleteAllReviewResponses();
	}
}
