public class Knight extends ChessPiece {

        /**
     * Constructor
     * 
     * @param rowNum     The row number where the piece is located
     * @param columnNum  The column number where the piece is located
     * @param pieceColor The color of this king
     */
    public Knight(int rowNum, int columnNum, int pieceColor)
    {
        super(rowNum, columnNum, pieceColor);
    }

    @Override
    public char getLabel()
    {
        return Board.WHITE_KNIGHT_LABEL;
    }

    @Override
    public boolean isLegalMove(int destRow, int destCol, Board theBoard)
    {
        int rowDiff = Math.abs(destRow - rowNum);
        int columnDiff = Math.abs(destCol - columnNum);
        int squareType = theBoard.getSquareInfo(destRow, destCol);

        boolean isLegal = (rowDiff <= 2 && columnDiff == 1 || rowDiff == 1 && columnDiff <= 2)
                && squareType != this.pieceColor && squareType != Board.OFF_THE_BOARD;
        return isLegal;
    }

    @Override
    public void generateLegalMoves(char[][] boardData, Board theBoard)
    {
        char label = Board.WHITE_KNIGHT_LABEL;
        boardData[rowNum][columnNum] = label;
        
        int[] rowMoves =    {-2, -1, -2, -1, 2, 1, 2, 1};
        int[] columnMoves = {-1, -2, 1, 2, -1, -2, 1, 2};
       
        for(int i = 0; i < 8; i++)
        {
                int squareType = theBoard.getSquareInfo(rowNum + rowMoves[i], columnNum + columnMoves[i]);
                if (squareType != this.pieceColor && squareType != Board.OFF_THE_BOARD)
                {
                    int counterX = rowNum + rowMoves[i];
                    int counterY = columnNum + columnMoves[i];
                    if(counterX < 8 && counterY < 8)
                    {
                    boardData[counterX][counterY] = label;
                    }
                }
            }
        }
    }
            
   
    



