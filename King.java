public class King extends ChessPiece
{
    /**
     * Constructor
     * 
     * @param rowNum     The row number where the piece is located
     * @param columnNum  The column number where the piece is located
     * @param pieceColor The color of this king
     */
    public King(int rowNum, int columnNum, int pieceColor)
    {
        super(rowNum, columnNum, pieceColor);
    }

    @Override
    public char getLabel()
    {
        return Board.WHITE_KING_LABEL;
    }

    @Override
    public boolean isLegalMove(int destRow, int destCol, Board theBoard)
    {
        int rowDiff = Math.abs(destRow - rowNum);
        int columnDiff = Math.abs(destCol - columnNum);
        int squareType = theBoard.getSquareInfo(destRow, destCol);

        boolean isLegal = (rowDiff == 1 && columnDiff < 2 || rowDiff < 2 && columnDiff == 1)
                && squareType != this.pieceColor && squareType != Board.OFF_THE_BOARD;
        return isLegal;
    }

    @Override
    public void generateLegalMoves(char[][] boardData, Board theBoard)
    {
        char label = Board.WHITE_KING_LABEL;
        boardData[rowNum][columnNum] = label;

        for (int i = 0; i < 8; i++)
        {
            for (int j = 0; j < 8; j++)
            {
                if (isLegalMove(i, j, theBoard)) {
                    boardData[i][j] = label;
                }
            }
        }
    }
}