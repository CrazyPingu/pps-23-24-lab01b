package e1;

import java.util.*;

public class LogicsImpl implements Logics {
	
	private final Pair<Integer,Integer> pawn;
	private Pair<Integer,Integer> knight;
	private final Random random = new Random();
	private final int size;
	 
    public LogicsImpl(int size){
    	this.size = size;
        this.pawn = this.randomEmptyPosition();
        this.knight = this.randomEmptyPosition();	
    }

    public LogicsImpl(int size, Pair<Integer,Integer> pawn, Pair<Integer,Integer> knight){
    	this.size = size;
        this.pawn = pawn;
        this.knight = knight;
    }

    private Pair<Integer, Integer> randomEmptyPosition() {
        List<Pair<Integer, Integer>> occupiedPosition = new ArrayList<>();
        if (this.knight != null) {
            occupiedPosition.add(this.knight.getPosition());
        }
        if (this.pawn != null) {
            occupiedPosition.add(this.pawn.getPosition());
        }
        return this.pg.getRandomEmptyPosition(this.size, occupiedPosition);
    }
    
	@Override
	public boolean hit(int row, int col) {
		if (row<0 || col<0 || row >= this.size || col >= this.size) {
			throw new IndexOutOfBoundsException();
		}
		// Below a compact way to express allowed moves for the knight
		int x = row-this.knight.getX();
		int y = col-this.knight.getY();
		if (x!=0 && y!=0 && Math.abs(x)+Math.abs(y)==3) {
			this.knight = new Pair<>(row,col);
			return this.pawn.equals(this.knight);
		}
		return false;
	}

	@Override
	public boolean hasKnight(int row, int col) {
		return this.knight.equals(new Pair<>(row,col));
	}

	@Override
	public boolean hasPawn(int row, int col) {
		return this.pawn.equals(new Pair<>(row,col));
	}
}
