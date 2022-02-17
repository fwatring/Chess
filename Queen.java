public class Queen extends ChessPiece {

    /**
     * Constructor
     * 
     * @param rowNum     The row number where the piece is located
     * @param columnNum  The column number where the piece is located
     * @param pieceColor The color of this king
     */
    public Queen(int rowNum, int columnNum, int pieceColor) {
        super(rowNum, columnNum, pieceColor);
    }

    @Override
    public char getLabel() {
        return Board.WHITE_QUEEN_LABEL;
    }

    @Override
    public boolean isLegalMove(int destRow, int destCol, Board theBoard) {
        Bishop bishop = new Bishop(rowNum, columnNum, Board.WHITE_SQUARE);
        boolean bishopCheck = bishop.isLegalMove(destRow, destCol, theBoard);

        Rook rook = new Rook(rowNum, columnNum, Board.WHITE_SQUARE);
        boolean rookCheck = rook.isLegalMove(destRow, destCol, theBoard);

        return bishopCheck || rookCheck;
    }

    @Override
    public void generateLegalMoves(char[][] boardData, Board theBoard) {
        char label = Board.WHITE_QUEEN_LABEL;
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
