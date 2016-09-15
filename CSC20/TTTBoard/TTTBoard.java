/**
 * A class representing a Tic Tac Toe Board. Upon creation, the user must pass to the
 * constructor the size of the board, otherwise default is a board of DEFAULT_SIZE by 
 * DEFAULT_SIZE. Each position of the TTT board will be referred as an ordered pair 
 * (x,y) where the upper-left position of the board is at (0,0) and x increases 
 * to the right and y increases downward. 
 * @author Hector Lopez
 * @version Febuary 11 , 2016
 */

public class TTTBoard {

   private static final int DEFAULT_SIZE = 3;
   
   private int size;
   private char chArray[][];
   
  /**
  * Initializes a new TTTBoard of size DEFAULT_SIZE by DEFAULT_SIZE. 
  */
  public TTTBoard(){
   this(DEFAULT_SIZE);   
  }//TTTBoard()
   
   
   /**
   * Initializes a new TTTBoard of size sz(sz x sz).
   *
   * @throws IllegalArgumentException if sz is not greater than 1.
   * @param sz is the size of the board (sz x sz)
   */
   public TTTBoard(int sz){
      
      if(sz < 1){
         throw new IllegalArgumentException("Size of TTTBoard must be greater than zero");
      }
      
      //Initialize chArray for TTTBoard of size sz > 0
      chArray = new char[sz][sz];
      if (sz == 1){
         chArray[0][0] = ' ';
      }else{
         for(int i = 0; i<sz; i++){
            for(int j =0; j < sz; j++){
               chArray[i][j] = ' ';
            }
         }
      }
      size = sz;
      
   }//TTTBaord(int sz)
   
   
   /**
   *Returns character at point (x, y) of TTTBoard object
   *
   *@throws IndexOutOfBoundsException if provided point is out of range of TTTBoard object
   *@param x Indicates the column of wanted character
   *@param y Indicates the row of wanted character
   *@return Character at point (x, y) of TTTBoard object
   */
   public char get(int x, int y){
   
      
      if((x>size-1) || (y > size-1)){
   
      throw new IndexOutOfBoundsException("Position of character is not in bounds of TTTBoard");
   
      }
      
      return chArray[x][y];
   
   }//get(int x, int y)
   
   /**
   * Sets the character ch at position (x, y) of TTTBoard
   *
   *@throws IndexOutOfBoundsException if point (x, y) is not in bounds of TTTBoard object
   *@param x Indicates the column to set character ch
   *@param y Indicates the row to set character ch
   *@param ch Character to set at point (x, y)
   */
   public void set(int x, int y, char ch){
   
      if((x>size-1) || (size < 0)){
   
      throw new IndexOutOfBoundsException("Point (x, y) not in TTTBoard bounds");
   
      }
      
      chArray[x][y] = ch;
   
   }//void set(int x, int y, char ch)
   
   /**
   * Returns the value of size of TTTBoard object
   *
   *@return Value of size of TTTBoard object
   */
   public int size(){
   
      return size;
   
   }//public int size()
   
   /**
   * Returns the character if there is a winner in TTTBoard object
   *
   *@return Character of winner in TTTBoard object
   */
   public char winner(){

      char winner = ' ';
      char vertWinner = checkVertical();
      char horzWinner = checkHorizontal();
      char diagWinner = checkDiagnals();
      
      if(vertWinner != winner){
         return vertWinner;
      }
      if(horzWinner != winner){
         return horzWinner;
      }
      if(diagWinner != winner){
         return diagWinner;
      }
      
      
      return winner;
      
   }//char winner()
   
   /**
   * Returns the TTTBoard object as a String
   *
   *@return TTTBoard object as a String
   */
   public String toString(){
   
      String s = "";
       
        if(size == 1) {
            s += "+-+\n";
            s += "|" + chArray[0][0] + "|\n";
            s += "+-+";
            return s;
        }
       
        // Fence Post
        s += spaceBar(size, 0);
       
        for(int i = 1; i <= size-1; i++) {
            s += "\n";
            s += plusMinus(size);
            s += "\n";
            s += spaceBar(size, i);
        }
       
        return s;
        
   }//toString()
   
   
   /*
   HELPER METHODS**********************************************************************************/
   
    private String plusMinus(int size) {
        //Create string for fences of TTTBoard of Size
        String s = "";
        //-
        s += "-";
        // +-+-
        for(int i = 1; i <= size-1; i++) {
            s += "+-";
        }
        return s;
    }//String plusMinus
       
    private String spaceBar(int size, int column) {
    //Creates String for row that includes Character at each point on TTTBoard
        String s = "";
        for(int i = 0; i < size-1; i++) {
            s += chArray[column][i] + "|";
        }
        s += chArray[column][size-1];
        return s;   
   }//String spaceBar
      
   public char checkVertical(){
   //Checks for winner across all Columns
   //Returns Character if winner found along any column 
   //or ' ' if no winner along any column
      char winChar;
      
      for(int i = 0; i < size; i++){
         int winner = 0;
         winChar = chArray[i][0]; 
         
            for(int j=0; j< size; j++){
               if(chArray[i][j]==' '|| chArray[i][j] != winChar){
                  continue;
               }
               
               winner++;
            }
         if(winner == size){
            return winChar;
         }
      } 
      
      return ' ';
   }//checkVertical   
   
   public char checkHorizontal(){
   //Checks for winner across all Rows
   //Returns Character if winner found along any row 
   //or ' ' if no winner along any row
      char winChar;
      
      for(int i = 0; i < size; i++){
         int winner = 0;
         winChar = chArray[0][i]; 
         
            for(int j=0; j< size; j++){
               if(chArray[j][i]==' '|| chArray[j][i] != winChar){
                  continue;
               }
               
               winner++;
            }
         if(winner == size){
            return winChar;
         }
      } 
      
      return ' ';
   }//checkHorizontal
   
   public char checkDiagnals(){
   //Checks for winner across both Diagnals
   //Returns Character if winner found along a diagnal 
   //or ' ' if no winner found
      int winnerLR = 0;
      int winnerRL = 0;
      char winCharLR = chArray[0][0];
      char winCharRL = chArray[size-1][0]; 
         
      for(int i=0; i< size; i++){
         if(chArray[i][i]==' '|| chArray[i][i] != winCharLR){
            continue;
         }
         winnerLR++;

      }
      
      if(winnerLR == size){
            return winCharLR;
      }
      
      for(int i=0; i< size; i++){
         if(chArray[(size-1)-i][i]==' '|| chArray[(size-1)-i][i] != winCharRL){
            continue;

         }
         winnerRL++;
      }
      
      if(winnerRL == size){
            return winCharRL;
      }
      
      return ' ';   
      
   }//cheackDiagnals() 
      
    
}//public class TTTBoard