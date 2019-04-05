package aero.champ.cargospot.cargomax.dummy.beans;

import aero.champ.cargospot.cargomax.dummy.generated.BookingEvaluationRQ;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;


/**
 * Dummied representation of BookingEvaluationRQ; so that we don't need to change the real thing.
 *
 * @version  $Revision$, $Date$
 */
public class EvaluationRequest
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
	public final Date requestTime;

	/**  */
	public final long seqNo;
	//~ Constructors -----------------------------
	/**
	 * Creates a new EvaluationRequest object.
	 *
	 * @param  id
	 * @param  rq
	 */
	public EvaluationRequest(int id, BookingEvaluationRQ rq)
	{
		this.id = id;
		this.bookingId = rq.getBookingId();
		this.seqNo = rq.getSeqNo();
		this.awbNum = rq.getAwbNum();
		this.requestTime = new Date();
		this.details = makeDetails(rq);
	}

	/**
	 * Creates a new EvaluationRequest object.
	 *
	 * @param  id
	 * @param  seqNo
	 * @param  awbNum
	 * @param  bookingId
	 * @param  requestTime
	 * @param  details
	 */
	@JsonCreator
	public EvaluationRequest(@JsonProperty("id") int id,
		@JsonProperty("seqNo") long seqNo,
		@JsonProperty("awbNum") String awbNum,
		@JsonProperty("bookingId") long bookingId,
		@JsonProperty("requestTime") Date requestTime,
		@JsonProperty("details") String details)
	{
		this.id = id;
		this.seqNo = seqNo;
		this.awbNum = awbNum;
		this.bookingId = bookingId;
		this.requestTime = requestTime;
		this.details = details;
	}
	//~ Methods ----------------------------------
	/**
	 * Just some arbitrary details that looks important from the request. Add when necessary.
	 *
	 * @return
	 */
	private String makeDetails(BookingEvaluationRQ rq)
	{
		StringBuilder builder = new StringBuilder();

		builder.append("awbOrig=");
		builder.append(rq.getAwbOrig());
		builder.append(", awbDest=");
		builder.append(rq.getAwbDest());
		builder.append(", rqDate=");
		builder.append(rq.getRqDate());
		builder.append(", rqTime=");
		builder.append(rq.getRqTime());
		builder.append(", totalWgt=");
		builder.append(rq.getTotalWgt());
		builder.append(", totalVol=");
		builder.append(rq.getTotalVol());
		builder.append(", totalChrgWgt=");
		builder.append(rq.getTotalChrgWgt());
		builder.append(", totalPieces=");
		builder.append(rq.getTotalPieces());
		builder.append(", totalRate=");
		builder.append(rq.getTotalRate());

		return builder.toString();
	}
}
