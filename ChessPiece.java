public abstract class ChessPiece {
    protected int rowNum;
    protected int columnNum;
    protected int pieceColor;

    /**
     * Constructor
     * 
     * @param rowNum     The row number where the piece is located
     * @param columnNum  The column number where the piece is located
     * @param pieceColor The color of the piece that is located
     */
    protected ChessPiece(int rowNum, int columnNum, int pieceColor) {
        this.rowNum = rowNum;
        this.columnNum = columnNum;
        this.pieceColor = pieceColor;
    }

    /**
     * Constructor
     * 
     * @param rowNum    The row number where the piece is located
     * @param columnNum The column number where the piece is located
     */
    protected ChessPiece(int rowNum, int columnNum) {
        this.rowNum = rowNum;
        this.columnNum = columnNum;
    }

    /**
     * Creates a new move for a chesspiece
     * 
     * @param newRow    The new row that is being selected
     * @param newColumn The new column that is being selected
     */

    public void move(int newRow, int newColumn) {
        this.rowNum = newRow;
        this.columnNum = newColumn;
    }

    /**
     * Gets the color of the piece that is selected
     * 
     * @return integer of the piece color
     */
    public int getColor() {
        return pieceColor;
    }

    /**
     * Gets the current label for the chess piece
     * 
     * 
     * @return character at the label
     */
    abstract char getLabel();

    /**
     * Checks if the destination the piece is moving towards is legal
     * 
     * 
     * @return boolean insuring isLegal move is true or false
     * @param destRow  the destination row of the chess piece
     * @param destCol  the destination column of the chess piece
     * @param theBoard the current board that is created
     */
    abstract boolean isLegalMove(int destRow, int destCol, Board theBoard);

    /**
     * Generates moves that are legal
     * 
     * 
     * @param boardData displays the current 2d array Board
     * @param theBoard  the current board that is created
     */
    abstract void generateLegalMoves(char[][] boardData, Board theBoard);

}