/*import org.junit.jupiter.api.Test;

import java.util.InputMismatchException;

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
       assertEquals(new InputMismatchException(),cprTestFalse);
       assertEquals(new InputMismatchException(),cprTestFalse2);
       assertEquals(new InputMismatchException(),cprTestFalse3);

    }
}

*/