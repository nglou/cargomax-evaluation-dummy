package aero.champ.cargospot.cargomax.dummy.beans;

import aero.champ.cargospot.cargomax.dummy.generated.BookingReviewRS;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;


/**
 * Dummied representation of BookingReviewRS; so that we don't need to change the real thing.
 *
 * @version  $Revision$, $Date$
 */
public class ReviewResponse
{
	//~ Instance fields --------------------------
	/**  */
	public final String details;

	/**  */
	public final int id;

	/**  */
	@JsonFormat(
		shape = JsonFormat.Shape.STRING,
		pattern = "dd-MM-yyyy hh:mm:ss"
	)
	public final Date responseTime;
	//~ Constructors -----------------------------
	/**
	 * Creates a new ReviewResponse object.
	 *
	 * @param  id
	 * @param  rs
	 */
	public ReviewResponse(int id, BookingReviewRS rs)
	{
		this.id = id;
		this.responseTime = new Date();
		this.details = makeDetails(rs);
	}

	/**
	 * Creates a new ReviewResponse object.
	 *
	 * @param  id
	 * @param  responseTime
	 * @param  details
	 */
	@JsonCreator
	public ReviewResponse(@JsonProperty("id") int id,
		@JsonProperty("responseTime") Date responseTime,
		@JsonProperty("details") String details)
	{
		this.id = id;
		this.responseTime = responseTime;
		this.details = details;
	}
	//~ Methods ----------------------------------
	/**
	 * DOCUMENT ME!
	 *
	 * @param   rs
	 * @return
	 */
	private String makeDetails(BookingReviewRS rs)
	{
		StringBuilder builder = new StringBuilder();
		builder.append("success=");
		builder.append(rs.getSuccess());
		builder.append(", errorCode=");
		builder.append(rs.getErrorCode());
		builder.append(", errorMsg=");
		builder.append(rs.getErrorMsg());

		return builder.toString();
	}
}
