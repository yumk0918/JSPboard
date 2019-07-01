package com.board.board;

import static org.junit.Assert.*;
import java.util.Set;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import org.junit.BeforeClass;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BoardTest {
	private static Validator validator; 
	 private static final Logger logger = LoggerFactory.getLogger(BoardTest.class);
	@BeforeClass
	   public static void setUp() {
	      ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
	      validator = factory.getValidator();
	   }
	@Test
	public void titleIsBlank() {
		Board board=new Board(0, "", "userId", "bDate", "bContent", 1);
		Set<ConstraintViolation<Board>> constraintViolations =validator.validate( board );
	      assertEquals( 1, constraintViolations.size() );
	      logger.debug(constraintViolations.iterator().next().getMessage());
	}
	@Test
	public void ContentIsNull() {
		Board board=new Board(0, "bTitle", "userId", "bDate", null, 1);
		Set<ConstraintViolation<Board>> constraintViolations =validator.validate( board );
	      assertEquals( 1, constraintViolations.size() );
	      logger.debug(constraintViolations.iterator().next().getMessage());
	}

}
