package implementingDP2Test;

import static org.junit.Assert.*;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import implementingDP2.QuizSimulatorMain;
import implementingDP2.RunAllTests;

public class TestGetQuizTesterScoreOnQuizV2 {	
	private final static int QUIZ_TESTER_ID1 = 1;
	private final static int QUIZ_TESTER_ID2 = 2;
	private final static int QUIZ_TESTER_ID5 = 5;
	
	private final static String TESTER_1_TARGET_STRING = "1";
	private final static String TESTER_2_TARGET_STRING = "2";
	private final static String TESTER_5_TARGET_STRING = "3";
	
	private final static int QUIZ_ID1 = 1;
	private final static int QUIZ_ID2 = 2;
	private final static int QUIZ_ID3 = 3;
	private final static int QUIZ_ID4 = 4;
	private final static int QUIZ_MAX = 4;
	
	private final static int QUESTION_MAX = 8;

	private static int testsPassed;
	private static int numberOfTests;
	private static QuizSimulatorMain quizSimulator;
	
	// --------------------------------------------------------------------------
	
	@BeforeClass
	public static void oneTimeSetUp() {
		testsPassed = 0;
		numberOfTests = 0;
	} // oneTimeSetUp

	@AfterClass
	public static void oneTimeTearDown() {
		String className = TestGetQuizTesterScoreOnQuizV2.class.getSimpleName();
		RunAllTests.outputResults(testsPassed, numberOfTests, className);
	} // oneTimeTearDown

	private static void simulatorSetupForAllTests() {
		quizSimulator = new QuizSimulatorMain();

		// Create QUIZ_MAX quizzes
		// Numbered from 1 .. QUIZ_MAX
		for (int quizID = 1; quizID <= QUIZ_MAX; quizID++) {
			quizSimulator.handleCreateQuiz(quizID);
		} // end for

		// Create QUESTION_MAX questions
		// Numbered from 1 .. QUIZ_MAX
		for (int questionID = 1; questionID <= QUESTION_MAX; questionID++) {
			boolean answer = (questionID % 2 == 0);
			String prompt = "Is " + questionID + " even?";
			quizSimulator.handleCreateQuestion(questionID, answer, prompt);

			int quizID = (questionID % QUIZ_MAX) + 1;
			quizSimulator.handleAddQuestionToQuiz(questionID, quizID);
			
			// This 'for' creates the following Quiz to question mapping
			// quiz1 -> {1, 5}
			// quiz2 -> {2, 6}
			// quiz3 -> {3, 7}
			// quiz4 -> {0, 4}
		} /// end for
		
		// Create quiz testers
		quizSimulator.handleCreateQuizTester(QUIZ_TESTER_ID1, TESTER_1_TARGET_STRING);
		quizSimulator.handleCreateQuizTester(QUIZ_TESTER_ID2, TESTER_2_TARGET_STRING);
		quizSimulator.handleCreateQuizTester(QUIZ_TESTER_ID5, TESTER_5_TARGET_STRING);
	} // simulatorSetupForAllTests

	// --------------------------------------------
	// JUnit Tests
	// --------------------------------------------

	/**
	 * This test will only pass when you have successfully implemented
	 * handleCreateQuiz, handleCreateQuestion, handleAddQuestionToQuiz,
	 * handleCreateQuizTester, handleGetQuizTesterScoreOnQuiz
	 */

	@Test
	public void testGetQuizTesterScoreOnQuizN01() {
		final double expectedAnswer = 0.0;
		simulatorSetupForAllTests();

		double actualAnswer = quizSimulator.handleGetQuizTesterScoreOnQuiz(QUIZ_TESTER_ID1, QUIZ_ID1);
		numberOfTests++;
		assertEquals(expectedAnswer, actualAnswer, 0.0001);
		testsPassed++;
	} // testGetQuizTesterScoreOnQuizN01
	
	@Test
	public void testGetQuizTesterScoreOnQuizN02() {	
		final double expectedAnswer = 0.5;	
		simulatorSetupForAllTests();
		
		double actualAnswer = quizSimulator.handleGetQuizTesterScoreOnQuiz(QUIZ_TESTER_ID1, QUIZ_ID2);
		numberOfTests++;
		assertEquals(expectedAnswer, actualAnswer, 0.0001);
		testsPassed++;
	} // testGetQuizTesterScoreOnQuizN02
	
	@Test
	public void testGetQuizTesterScoreOnQuizN03() {	
		final double expectedAnswer = 0.0;		
		simulatorSetupForAllTests();

		double actualAnswer = quizSimulator.handleGetQuizTesterScoreOnQuiz(QUIZ_TESTER_ID1, QUIZ_ID3);
		numberOfTests++;
		assertEquals(expectedAnswer, actualAnswer, 0.0001);
		testsPassed++;
	} // testGetQuizTesterScoreOnQuizN03
	
	
	@Test
	public void testGetQuizTesterScoreOnQuizN04() {	
		final double expectedAnswer = 1.0;		
		simulatorSetupForAllTests();

		double actualAnswer = quizSimulator.handleGetQuizTesterScoreOnQuiz(QUIZ_TESTER_ID1, QUIZ_ID4);
		numberOfTests++;
		assertEquals(expectedAnswer, actualAnswer, 0.0001);
		testsPassed++;
	} // testGetQuizTesterScoreOnQuizN04
	
	@Test
	public void testGetQuizTesterScoreOnQuizN05() {		
		final double expectedAnswer = 0.0;			
		simulatorSetupForAllTests();

		double actualAnswer = quizSimulator.handleGetQuizTesterScoreOnQuiz(QUIZ_TESTER_ID2, QUIZ_ID1);
		numberOfTests++;
		assertEquals(expectedAnswer, actualAnswer, 0.0001);
		testsPassed++;
	} // testGetQuizTesterScoreOnQuizN05
	
	@Test
	public void testGetQuizTesterScoreOnQuizN06() {	
		final double expectedAnswer = 1.0;	
		simulatorSetupForAllTests();

		numberOfTests++;
		double actualAnswer = quizSimulator.handleGetQuizTesterScoreOnQuiz(QUIZ_TESTER_ID2, QUIZ_ID2);
		assertEquals(expectedAnswer, actualAnswer, 0.0001);
		testsPassed++;
	} // testGetQuizTesterScoreOnQuizN06
	
	@Test
	public void testGetQuizTesterScoreOnQuizN07() {			
		final double expectedAnswer = 0.5;		
		simulatorSetupForAllTests();

		numberOfTests++;
		double actualAnswer = quizSimulator.handleGetQuizTesterScoreOnQuiz(QUIZ_TESTER_ID2, QUIZ_ID3);
		assertEquals(expectedAnswer, actualAnswer, 0.0001);
		testsPassed++;
	} // testGetQuizTesterScoreOnQuizN07
	
	
	@Test
	public void testGetQuizTesterScoreOnQuizN08() {			
		final double expectedAnswer = 1.0;		
		simulatorSetupForAllTests();

		numberOfTests++;
		double actualAnswer = quizSimulator.handleGetQuizTesterScoreOnQuiz(QUIZ_TESTER_ID2, QUIZ_ID4);
		assertEquals(expectedAnswer, actualAnswer, 0.0001);
		testsPassed++;
	} // testGetQuizTesterScoreOnQuizN08
	
	@Test
	public void testGetQuizTesterScoreOnQuizN09() {			
		final double expectedAnswer = 0.0;			
		simulatorSetupForAllTests();

		numberOfTests++;
		double actualAnswer = quizSimulator.handleGetQuizTesterScoreOnQuiz(QUIZ_TESTER_ID5, QUIZ_ID1);
		assertEquals(expectedAnswer, actualAnswer, 0.0001);
		testsPassed++;
	} // testGetQuizTesterScoreOnQuizN09
	
	@Test
	public void testGetQuizTesterScoreOnQuizN10() {		
		final double expectedAnswer = 1.0;				
		simulatorSetupForAllTests();

		numberOfTests++;
		double actualAnswer = quizSimulator.handleGetQuizTesterScoreOnQuiz(QUIZ_TESTER_ID5, QUIZ_ID2);
		assertEquals(expectedAnswer, actualAnswer, 0.0001);
		testsPassed++;
	} // testGetQuizTesterScoreOnQuizN10
	
	@Test
	public void testGetQuizTesterScoreOnQuizN11() {
		final double expectedAnswer = 0.0;		
		simulatorSetupForAllTests();

		numberOfTests++;
		double actualAnswer = quizSimulator.handleGetQuizTesterScoreOnQuiz(QUIZ_TESTER_ID5, QUIZ_ID3);
		assertEquals(expectedAnswer, actualAnswer, 0.0001);
		testsPassed++;
	} // testGetQuizTesterScoreOnQuizN11

	@Test
	public void testGetQuizTesterScoreOnQuizN12() {
		final double expectedAnswer = 0.5;		
		simulatorSetupForAllTests();

		numberOfTests++;
		double actualAnswer = quizSimulator.handleGetQuizTesterScoreOnQuiz(QUIZ_TESTER_ID5, QUIZ_ID4);
		assertEquals(expectedAnswer, actualAnswer, 0.0001);
		testsPassed++;
	} // testGetQuizTesterScoreOnQuizN12

} // end class TestGetQuizTesterScoreOnQuizV2
