public class Rook extends ChessPiece {
    /**
     * Constructor
     * 
     * @param rowNum     The row number where the piece is located
     * @param columnNum  The column number where the piece is located
     * @param pieceColor The color of this king
     */
    public Rook(int rowNum, int columnNum, int pieceColor) {
        super(rowNum, columnNum, pieceColor);
    }

    @Override
    public char getLabel() {
        return Board.WHITE_ROOK_LABEL;
    }

    @Override
    public boolean isLegalMove(int destRow, int destCol, Board theBoard) {
        int destinationSquare = theBoard.getSquareInfo(destRow, destCol);
        boolean isLegalDestinationSquare = ((destinationSquare == Board.EMPTY_SQUARE
                || destinationSquare == Board.BLACK_SQUARE) && (destRow == rowNum || destCol == columnNum));

        if (!isLegalDestinationSquare) {
            return false;
        }

        if (destCol > columnNum) {
            for (int j = columnNum + 1; j < destCol; j++) {
                int currSquare = theBoard.getSquareInfo(rowNum, j);
                if (currSquare != Board.EMPTY_SQUARE) {
                    return false;
                }
            }
        }

        if (destCol < columnNum) {
            for (int j = columnNum - 1; j > destCol; j--) {
                int currSquare = theBoard.getSquareInfo(rowNum, j);
                if (currSquare != Board.EMPTY_SQUARE) {
                    return false;
                }
            }
        }

        if (destRow > rowNum) {
            for (int i = rowNum + 1; i < destRow; i++) {
                int currSquare = theBoard.getSquareInfo(i, columnNum);
                if (currSquare != Board.EMPTY_SQUARE) {
                    return false;
                }
            }
        }

        if (destRow < rowNum) {
            for (int i = rowNum - 1; i > destRow; i--) {
                int currSquare = theBoard.getSquareInfo(i, columnNum);
                if (currSquare != Board.EMPTY_SQUARE) {
                    return false;
                }
            }
        }

        return true;
    }

    @Override
    public void generateLegalMoves(char[][] boardData, Board theBoard) {
        char label = Board.WHITE_ROOK_LABEL;
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
