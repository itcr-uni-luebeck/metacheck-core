package core.metric.dataelementmetrics;

import core.metric.exceptions.DivisionByZeroException;
import core.metric.exceptions.MaxScoreSmallerElementScoreException;
import core.metric.reflections.MethodWithClass;
import core.model.MyDataElement;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

/**
 * class to calculate the total score of a dataelement
 * 
 * @author Alexandra Banach
 *
 */
public class CalculateDataElementScore {
	/**
	 * compute a total score of type float for a dataelement to evaluate its
	 * quality. Total score is all added scores divided by the maximum of possible
	 * score (value between 0 and 1)
	 * 
	 * @param myDataelement
	 * @return computed total score of a dataelement, type float
	 * @throws InstantiationException    might appear while creating an instance to
	 *                                   call a method to compute a datalementscore
	 * @throws InvocationTargetException might appear while getting all methods to
	 *                                   calculate dataelementscore for metrics
	 * @throws IllegalArgumentException  might appear while getting all methods to
	 *                                   calculate dataelementscore for metrics
	 * @throws IllegalAccessException    might appear while getting all methods to
	 *                                   calculate dataelementscore for metrics
	 */
	public float[] calculateDataElementScore(List<MyDataElement> dataelements, List<MethodWithClass> methods)
			throws DivisionByZeroException, MaxScoreSmallerElementScoreException, IllegalAccessException,
			IllegalArgumentException, InvocationTargetException, InstantiationException {
		// initialize score of dataElement and maximum of possible score with 0
		int elementScore = 0;
		int maxScore = 0;
		// empty object for result
		float[] scores = new float[dataelements.size()];
		Score sc;

		// for all dataelements
		for (int i = 0; i < dataelements.size(); i++) {
			// calculate all scores with all calculate methods
			for (MethodWithClass m : methods) {
				// call calculate method

				sc = (Score) m.getMyMethod().invoke(m.getMyClass().newInstance(), dataelements.get(i));
				elementScore += sc.getScore();
				maxScore += sc.getMaxScore();
			}
			// compute total score for dataelement
			// if maxScore is 0 throw exception
			// because of division by 0 while returning value of method
			if (maxScore == 0) {
				scores[i] = 0;
				elementScore = 0;
				throw new DivisionByZeroException(
						"Division by 0 when computing metrics! Please check your maximum score value!");
				// if maxScore is smaller than the score computed for the dataelement
				// throw exception
			} else if (maxScore < elementScore) {
				scores[i] = 0;
				maxScore = 0;
				elementScore = 0;
				throw new MaxScoreSmallerElementScoreException(
						"Your maximum score is smaller than the computed score for a dataelement. Please check it!");
			} else {
				// compute total score as ratio of
				// all added scores divided by the
				// number of maximum possible score
				// (value is between 0 and 1)
				scores[i] = (float) elementScore / maxScore;
				dataelements.get(i).setScore(scores[i]);
				elementScore = 0;
				maxScore = 0;

			}

		}

		return scores;
	}
}
