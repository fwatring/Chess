public class Bishop extends ChessPiece {
    /**
     * Constructor
     * 
     * @param rowNum     The row number where the piece is located
     * @param columnNum  The column number where the piece is located
     * @param pieceColor The color of the piece that is located
     */
    public Bishop(int rowNum, int columnNum, int pieceColor) {
        super(rowNum, columnNum, pieceColor);
    }

    @Override
    public char getLabel() {
        return Board.WHITE_BISHOP_LABEL;
    }

    @Override
    public boolean isLegalMove(int destRow, int destCol, Board theBoard) {
        int destinationSquare = theBoard.getSquareInfo(destRow, destCol);

        int differenceRow = destRow - rowNum;
        int differenceColumn = destCol - columnNum;

        boolean isLegalDestinationSquare = (destinationSquare == Board.EMPTY_SQUARE
                || destinationSquare == Board.BLACK_SQUARE) && (Math.abs(differenceRow) == Math.abs(differenceColumn));

        if (!isLegalDestinationSquare) {
            return false;
        }

        if (differenceRow > 0 && differenceColumn > 0) {
            for (int diff = 1; diff < Math.abs(differenceColumn); diff++) {
                int currSquare = theBoard.getSquareInfo(rowNum + diff, columnNum + diff);
                if (currSquare != Board.EMPTY_SQUARE) {
                    return false;
                }
            }
        }

        if (differenceRow < 0 && differenceColumn > 0) {
            for (int diff = 1; diff < Math.abs(differenceColumn); diff++) {
                int currSquare = theBoard.getSquareInfo(rowNum - diff, columnNum + diff);
                if (currSquare != Board.EMPTY_SQUARE) {
                    return false;
                }
            }
        }

        if (differenceRow > 0 && differenceColumn < 0) {
            for (int diff = 1; diff < Math.abs(differenceRow); diff++) {
                int currSquare = theBoard.getSquareInfo(rowNum + diff, columnNum - diff);
                if (currSquare != Board.EMPTY_SQUARE) {
                    return false;
                }
            }
        }

        if (differenceRow < 0 && differenceColumn < 0) {
            for (int diff = 1; diff < Math.abs(differenceRow); diff++) {
                int currSquare = theBoard.getSquareInfo(rowNum - diff, columnNum - diff);
                if (currSquare != Board.EMPTY_SQUARE) {
                    return false;
                }
            }
        }

        return true;
    }

    @Override
    public void generateLegalMoves(char[][] boardData, Board theBoard) {
        char label = Board.WHITE_BISHOP_LABEL;
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
