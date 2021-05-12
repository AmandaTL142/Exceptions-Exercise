import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NemIdAuthorizerTest {

   @Test
    void NemIdAuthorizer(){
       // Arrange
       NemIdAuthorizer validator = new NemIdAuthorizer();

       // Act
       boolean cprTestTrue = validator.isValidInput("1234567890","password");

       boolean cprTestFalse = validator.isValidInput("TiTegnHeri","password");

       boolean cprTestFalse2 = validator.isValidInput("123456789","password");

       boolean cprTestFalse3 = validator.isValidInput("12345678910","password");

       // Assert
       assertEquals(true,cprTestTrue);
       assertEquals(false,cprTestFalse);
       assertEquals(false,cprTestFalse2);
       assertEquals(false,cprTestFalse3);

    }
}

/*
package unit_tests;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AgeValidatorTest {

    @Test
    void isLegalAge() {
        //Arrange
        AgeValidator validator = new AgeValidator();
        //Act
        String legalAge = validator.isLegalAge(18);

        String illegalAge = validator.isLegalAge(17);
        String illegalAge2 = validator.isLegalAge(1);

        String illegalInput = validator.isLegalAge(-5);

        //Assert
        assertEquals("Legal age",legalAge);

        assertEquals("not legal",illegalAge);
        assertEquals("not legal",illegalAge2);

        assertEquals("Illegal",illegalInput);
    }
}
 */