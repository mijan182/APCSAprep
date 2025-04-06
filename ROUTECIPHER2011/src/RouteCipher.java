public class RouteCipher
{
  /** A two-dimensional array of single-character strings, instantiated in the constructor */
  private String[][] letterBlock;
  /** The number of rows of letterBlock, set by the constructor */
  private int numRows;
  /** The number of columns of letterBlock, set by the constructor */
  private int numCols;
  
  public RouteCipher(int theNumRows, int theNumCols)
  {
    numRows = theNumRows;
    numCols = theNumCols;
    letterBlock = new String[numRows][numCols];
  }
  
  /** Places a string into letterBlock in row-major order.
    * @param str the string to be processed
    * Postcondition:
    * if str.length() < numRows * numCols, "A" is placed in each unfilled cell
    * if str.length() > numRows * numCols, trailing characters are ignored
    */
  private void fillBlock(String str)
  {
    /* to be implemented in part (a) */ 

    int strIndex = 0;

    for(int r = 0; r < numRows; r++){
        for(int c = 0; c<numCols; c++){
            if (strIndex >= str.length())
            letterBlock[r][c] = "A";
            else
                letterBlock[r][c] = str.substring(strIndex, strIndex + 1);

            strIndex++;
        }
    }
  }
  
  /** Extracts encrypted string from letterBlock in column-major order.
    * Precondition: letterBlock has been filled
    * @return the encrypted string from letterBlock
    */
  private String encryptBlock()
  { 
    String message = "";
    for (int col = 0; col < numCols; col++)
    {
      for (int row = 0; row < numRows; row++)
      {
        message = message + letterBlock[row][col];
      }
    }
    return message;
  }
  
  /** Encrypts a message.
    * @param message the string to be encrypted
    * @return the encrypted message;
    * if message is the empty string, returns the empty string
    */
  public String encryptMessage(String message)
  { 
    /* to be implemented in part (b) */

    String cipherText = "";

    for(int i = 0; i < message.length(); i += numRows * numCols)
    {
        fillBlock(message.substring(i));
        cipherText += encryptBlock();
    }

    return cipherText;
}
  
  
  public static void main(String[] args)
  {
    RouteCipher cipher = new RouteCipher(3,5);
    String output = cipher.encryptMessage("Meet at noon");
    System.out.println("The encrypted message is " + output);
    System.out.println("It should be Maoetne AtnA oA ");
  }

}