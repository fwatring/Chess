public class WhitePawn extends ChessPiece {
    /**
     * Constructor
     * 
     * @param rowNum    The row number where the piece is located
     * @param columnNum The column number where the piece is located
     */
    public WhitePawn(int rowNum, int columnNum) {
        super(rowNum, columnNum, Board.WHITE_SQUARE);
    }

    @Override
    public char getLabel() {
        return Board.WHITE_PAWN_LABEL;
    }

    @Override
    public boolean isLegalMove(int destRow, int destCol, Board theBoard) {
        int destX = destCol;
        int destY = destRow;
        int currX = columnNum;
        int currY = rowNum;
        int destinationSquare = theBoard.getSquareInfo(destY, destX);

        boolean isLegalDestinationSquare = ((destinationSquare == Board.EMPTY_SQUARE
                || destinationSquare == Board.BLACK_SQUARE)
                && (((destY == currY + 2 && currY == 1 || destY == currY + 1 && destX == currX)
                        && destinationSquare == Board.EMPTY_SQUARE)
                        || (destX == currX + 1 && destY == currY + 1) && (destinationSquare == Board.BLACK_SQUARE)
                        || (destX == currX - 1 && destY == currY + 1) && (destinationSquare == Board.BLACK_SQUARE)));

        if (!isLegalDestinationSquare) {
            return false;
        }

        for (int j = currY + 1; j < destY; j++) {
            int currSquare = theBoard.getSquareInfo(currX, j);
            if (currSquare != Board.EMPTY_SQUARE) {
                return false;
            }
        }

        return true;
    }

    @Override
    public void generateLegalMoves(char[][] boardData, Board theBoard) {
        char label = Board.WHITE_PAWN_LABEL;
        boardData[rowNum][columnNum] = label;

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (isLegalMove(i, j, theBoard)) {
                    boardData[i][j] = label;
                }
            }
        }
    }
}
