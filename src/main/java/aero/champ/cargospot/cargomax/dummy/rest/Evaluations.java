package aero.champ.cargospot.cargomax.dummy.rest;

import aero.champ.cargospot.cargomax.dummy.beans.EvaluationRequest;
import aero.champ.cargospot.cargomax.dummy.beans.EvaluationResponse;
import aero.champ.cargospot.cargomax.dummy.db.InMemoryDB;
import aero.champ.cargospot.cargomax.dummy.generated.BookingRequestStatus;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;


/**
 * Rest webservice for Evaluation Requests.
 *
 * @version  $Revision$, $Date$
 */
@Path("/evaluations")
public class Evaluations
{
	//~ Methods ----------------------------------
	/**
	 * All Evaluation Requests.
	 *
	 * @return
	 */
	@GET
	@Path("/requests")
	@Produces(MediaType.APPLICATION_JSON)
	public List<EvaluationRequest> allEvaluations()
	{
		InMemoryDB inMemoryDB = InMemoryDB.fromContext();

		return inMemoryDB.getAllEvaluationRequests();
	}
	
	/**
	 * All Evaluation Responses.
	 *
	 * @return
	 */
	@GET
	@Path("/responses")
	@Produces(MediaType.APPLICATION_JSON)
	public List<EvaluationResponse> allResponses()
	{
		InMemoryDB inMemoryDB = InMemoryDB.fromContext();

		return inMemoryDB.getAllEvaluationResponses();
	}
	
	/**
	 * The current status returned for the responses.
	 *
	 * @return
	 */
	@GET
	@Path("/defaultstatus")
	@Produces(MediaType.TEXT_PLAIN)
	public String currentDefaultStatus()
	{
		InMemoryDB inMemoryDB = InMemoryDB.fromContext();

		return inMemoryDB.currentEvaluationDefaultStatus().toString();
	}
	
	/**
	 * Change the current status returned for the responses.
	 *
	 * @param   newDefaultStatus
	 * @return
	 */
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@POST
	@Path("/defaultstatus")
	@Produces(MediaType.TEXT_PLAIN)
	public String changeDefaultStatus(@FormParam("newDefaultStatus") String newDefaultStatus)
	{
		InMemoryDB inMemoryDB = InMemoryDB.fromContext();
		inMemoryDB.changeEvaluationDefaultStatus(BookingRequestStatus.fromValue(newDefaultStatus));

		return currentDefaultStatus();
	}
	
	/**
	 * Delete all Evaluation Requests stored in the webservice.
	 */
	@POST
	@Path("/requests/clear")
	public void clearAllEvaluationRequests()
	{
		InMemoryDB inMemoryDB = InMemoryDB.fromContext();

		inMemoryDB.deleteAllEvaluationRequests();
	}
	
	/**
	 * Delete all Evaluation Responses stored in the webservice.
	 */
	@POST
	@Path("/responses/clear")
	public void clearAllEvaluationResponses()
	{
		InMemoryDB inMemoryDB = InMemoryDB.fromContext();

		inMemoryDB.deleteAllEvaluationResponses();
	}
}
