package com.board.user;

import static org.junit.Assert.assertEquals;
import java.util.*;
import javax.validation.*;
import org.junit.BeforeClass;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UserValidatorTest {
private static Validator validator;
 private static final Logger logger = LoggerFactory.getLogger(UserValidatorTest.class);
   @BeforeClass
   public static void setUp() {
      ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
      validator = factory.getValidator();
   }
   @Test
   public void checkUserId() {
      User user=new User("","password","name","n@n");
      Set<ConstraintViolation<User>> constraintViolations =validator.validate( user );
      assertEquals( 1, constraintViolations.size() );
      logger.debug(constraintViolations.iterator().next().getMessage());
      
      user=new User("*adfsf","password","name","n@n");
      constraintViolations =validator.validate( user );
      assertEquals( 1, constraintViolations.size() );
      logger.debug(constraintViolations.iterator().next().getMessage());
   }
   @Test
   public void userIdLength() {
      User user=new User("id","password","name","");
      Set<ConstraintViolation<User>> constraintViolations =validator.validate( user );
      assertEquals( 1, constraintViolations.size() );
      logger.debug(constraintViolations.iterator().next().getMessage());
   }
   @Test
   public void email() {
      User user=new User("userid","password","name","email");
      Set<ConstraintViolation<User>> constraintViolations =validator.validate( user );
      assertEquals( 1, constraintViolations.size() );
      logger.debug(constraintViolations.iterator().next().getMessage());
   }
   @Test
   public void invalidUser() {
      User user=new User("1@@@@@","1","","1");
      Set<ConstraintViolation<User>> constraintViolations =validator.validate( user );
      assertEquals( 4, constraintViolations.size() );

      Iterator<ConstraintViolation<User>>violations=constraintViolations.iterator();
      while(violations.hasNext()) {
    	  ConstraintViolation<User> each=violations.next();
    	  logger.debug(each.toString());
      }
   }
}
