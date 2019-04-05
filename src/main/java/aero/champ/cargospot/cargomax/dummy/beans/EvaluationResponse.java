package aero.champ.cargospot.cargomax.dummy.beans;

import aero.champ.cargospot.cargomax.dummy.generated.BookingEvaluationRS;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;


/**
 * Dummied representation of BookingEvaluationRS; so that we don't need to change the real thing.
 *
 * @version  $Revision$, $Date$
 */
public class EvaluationResponse
{
	//~ Instance fields --------------------------
	/**  */
	public final String awbNum;

	/**  */
	public final long bookingId;

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

	/**  */
	public final long seqNo;
	//~ Constructors -----------------------------
	/**
	 * Creates a new EvaluationResponse object.
	 *
	 * @param  id
	 * @param  rs
	 */
	public EvaluationResponse(int id, BookingEvaluationRS rs)
	{
		this.id = id;
		this.bookingId = rs.getBookingId();
		this.awbNum = rs.getAwbNum();
		this.seqNo = rs.getSeqNo();
		this.responseTime = new Date();
		this.details = makeDetails(rs);
	}

	/**
	 * Creates a new EvaluationResponse object.
	 *
	 * @param  id
	 * @param  seqNo
	 * @param  awbNum
	 * @param  bookingId
	 * @param  responseTime
	 * @param  details
	 */
	@JsonCreator
	public EvaluationResponse(@JsonProperty("id") int id,
		@JsonProperty("seqNo") long seqNo,
		@JsonProperty("awbNum") String awbNum,
		@JsonProperty("bookingId") long bookingId,
		@JsonProperty("responseTime") Date responseTime,
		@JsonProperty("details") String details)
	{
		this.id = id;
		this.seqNo = seqNo;
		this.awbNum = awbNum;
		this.bookingId = bookingId;
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
	private String makeDetails(BookingEvaluationRS rs)
	{
		StringBuilder builder = new StringBuilder();
		builder.append("status=");
		builder.append(rs.getStatus());
		builder.append(", awbCurrency=");
		builder.append(rs.getAwbCurrency());
		builder.append(", minRate=");
		builder.append(rs.getMinRate());
		builder.append(", errorCode=");
		builder.append(rs.getErrorCode());
		builder.append(", errorMsg=");
		builder.append(rs.getErrorMsg());
		builder.append(", userId=");
		builder.append(rs.getUserId());

		return builder.toString();
	}
}
