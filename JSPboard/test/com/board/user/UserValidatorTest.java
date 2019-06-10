package com.board.user;

import static org.junit.Assert.assertEquals;
import java.util.*;
import javax.validation.*;
import org.junit.BeforeClass;
import org.junit.Test;

public class UserValidatorTest {
private static Validator validator;
   @BeforeClass
   public static void setUp() {
      ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
      validator = factory.getValidator();
   }
   @Test
   public void userIdIsNull() {
      User user=new User(null,"password","name","");
      Set<ConstraintViolation<User>> constraintViolations =validator.validate( user );
      assertEquals( 1, constraintViolations.size() );
      System.out.println(constraintViolations.iterator().next().getMessage());
   }
   @Test
   public void userIdLength() {
      User user=new User("id","password","name","");
      Set<ConstraintViolation<User>> constraintViolations =validator.validate( user );
      assertEquals( 1, constraintViolations.size() );
      System.out.println(constraintViolations.iterator().next().getMessage());
   
      user=new User("id123456789012345","password","name","");
      constraintViolations =validator.validate( user );
      assertEquals( 1, constraintViolations.size() );
      System.out.println(constraintViolations.iterator().next().getMessage());
   }
   @Test
   public void email() {
      User user=new User("userid","password","name","email");
      Set<ConstraintViolation<User>> constraintViolations =validator.validate( user );
      assertEquals( 1, constraintViolations.size() );
      System.out.println(constraintViolations.iterator().next().getMessage());
   }
   @Test
   public void invalidUser() {
      User user=new User("id","password","name","email");
      Set<ConstraintViolation<User>> constraintViolations =validator.validate( user );
      assertEquals( 2, constraintViolations.size() );

      Iterator<ConstraintViolation<User>>violations=constraintViolations.iterator();
      while(violations.hasNext()) {
    	  ConstraintViolation<User> each=violations.next();
    	  System.out.println(each.getPropertyPath()+":"+each.getMessage());
      }
   }
}
