package aero.champ.cargospot.cargomax.dummy.db;

import aero.champ.cargospot.cargomax.dummy.beans.EvaluationRequest;
import aero.champ.cargospot.cargomax.dummy.beans.EvaluationResponse;
import aero.champ.cargospot.cargomax.dummy.beans.ReviewRequest;
import aero.champ.cargospot.cargomax.dummy.beans.ReviewResponse;
import aero.champ.cargospot.cargomax.dummy.generated.BookingEvaluationRQ;
import aero.champ.cargospot.cargomax.dummy.generated.BookingEvaluationRS;
import aero.champ.cargospot.cargomax.dummy.generated.BookingRequestStatus;
import aero.champ.cargospot.cargomax.dummy.generated.BookingReviewRQ;
import aero.champ.cargospot.cargomax.dummy.generated.BookingReviewRS;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.naming.InitialContext;
import javax.naming.NamingException;


/**
 * In memory repository of this dummy webservice to hold requests and responses. Singleton instance is created
 * from the web container context. See META-INF\context.xml and WEB-INF\web.xml.
 *
 * @version  $Revision$, $Date$
 */
public class InMemoryDB
{
	//~ Static fields/initializers ---------------
	/**  */
	private static InMemoryDB instance;
	//~ Instance fields --------------------------
	/**  */
	private BookingRequestStatus evaluationDefaultStatus;

	/**  */
	private List<EvaluationRequest> evaluationRequests;

	/**  */
	private List<EvaluationResponse> evaluationResponses;

	/**  */
	private List<ReviewRequest> reviewRequests;

	/**  */
	private List<ReviewResponse> reviewResponses;
	
	private int evaluationRequestsId;
	private int evaluationResponsesId;
	private int reviewRequestsId;
	private int reviewResponsesId;
	//~ Constructors -----------------------------
	/** Creates a new InMemoryDB object. */
	public InMemoryDB( )
	{
		evaluationRequests = Collections.synchronizedList(new ArrayList<EvaluationRequest>());
		evaluationResponses = Collections.synchronizedList(new ArrayList<EvaluationResponse>());
		reviewRequests = Collections.synchronizedList(new ArrayList<ReviewRequest>());
		reviewResponses = Collections.synchronizedList(new ArrayList<ReviewResponse>());
		evaluationDefaultStatus = BookingRequestStatus.APP;
	}
	//~ Methods ----------------------------------
	/**
	 * DOCUMENT ME!
	 *
	 * @return
	 */
	public static InMemoryDB fromContext()
	{
		if (instance == null)
		{
			try
			{
				instance = (InMemoryDB) new InitialContext().lookup("java:comp/env/bean/InMemoryDB");
			}
			catch (NamingException e)
			{
				throw new RuntimeException(e);
			}
		}

		return instance;
	}
	
	/**
	 * DOCUMENT ME!
	 *
	 * @param   rq
	 * @return
	 */
	public EvaluationRequest addEvaluationRequest(BookingEvaluationRQ rq)
	{
		EvaluationRequest request = new EvaluationRequest(++evaluationRequestsId, rq);
		evaluationRequests.add(request);

		return request;
	}
	
	/**
	 * DOCUMENT ME!
	 *
	 * @param   rs
	 * @return
	 */
	public EvaluationResponse addEvaluationResponse(BookingEvaluationRS rs)
	{
		EvaluationResponse response = new EvaluationResponse(++evaluationResponsesId, rs);
		evaluationResponses.add(response);

		return response;
	}
	
	/**
	 * DOCUMENT ME!
	 *
	 * @return
	 */
	public List<EvaluationRequest> getAllEvaluationRequests()
	{
		return evaluationRequests;
	}
	
	/**
	 * DOCUMENT ME!
	 *
	 * @return
	 */
	public List<EvaluationResponse> getAllEvaluationResponses()
	{
		return evaluationResponses;
	}
	

	/** DOCUMENT ME! */
	public void deleteAllEvaluationRequests()
	{
		evaluationRequestsId = 0;
		evaluationRequests.clear();
	}
	

	/** DOCUMENT ME! */
	public void deleteAllEvaluationResponses()
	{
		evaluationResponsesId = 0;
		evaluationResponses.clear();
	}
	
	/** DOCUMENT ME! */
	public void deleteAllReviewRequests()
	{
		reviewRequestsId = 0;
		reviewRequests.clear();
	}
	

	/** DOCUMENT ME! */
	public void deleteAllReviewResponses()
	{
		reviewResponsesId = 0;
		reviewResponses.clear();
	}
	
	/**
	 * DOCUMENT ME!
	 *
	 * @param   rq
	 * @return
	 */
	public ReviewRequest addReviewRequest(BookingReviewRQ rq)
	{
		ReviewRequest request = new ReviewRequest(++reviewRequestsId, rq);
		reviewRequests.add(request);

		return request;
	}
	
	/**
	 * DOCUMENT ME!
	 *
	 * @param   rs
	 * @return
	 */
	public ReviewResponse addReviewResponse(BookingReviewRS rs)
	{
		ReviewResponse response = new ReviewResponse(++reviewResponsesId, rs);
		reviewResponses.add(response);

		return response;
	}
	
	/**
	 * DOCUMENT ME!
	 *
	 * @return
	 */
	public List<ReviewRequest> getAllReviewRequests()
	{
		return reviewRequests;
	}
	
	/**
	 * DOCUMENT ME!
	 *
	 * @return
	 */
	public List<ReviewResponse> getAllReviewResponses()
	{
		return reviewResponses;
	}
	
	/**
	 * DOCUMENT ME!
	 *
	 * @return
	 */
	public BookingRequestStatus currentEvaluationDefaultStatus()
	{
		return evaluationDefaultStatus;
	}
	
	/**
	 * DOCUMENT ME!
	 *
	 * @param  status
	 */
	public void changeEvaluationDefaultStatus(BookingRequestStatus status)
	{
		this.evaluationDefaultStatus = status;
	}
}
