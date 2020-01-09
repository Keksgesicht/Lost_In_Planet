package game.map;

public class Chunk {

	private Chunk leftChunk;
	private Chunk rightChunk;
	private Chunk topChunk;
	private Chunk bottomChunk;
	/**
	 * first array is the X-Axe <br>
	 * second array is the Y-Axe
	 */
	public final Block[][] blocks = new Block[16][16];
	
	/**
	 * @return the chunk on the left
	 */
	public Chunk getLeftChunk() {
		return leftChunk;
	}

	/**
	 * @param leftChunk chunk on the left
	 */
	public void setLeftChunk(Chunk leftChunk) {
		this.leftChunk = leftChunk;
	}

	/**
	 * @return the chunk on the right
	 */
	public Chunk getRightChunk() {
		return rightChunk;
	}

	/**
	 * @param rightChunk the chunk on the right
	 */
	public void setRightChunk(Chunk rightChunk) {
		this.rightChunk = rightChunk;
	}

	/**
	 * @return the chunk above
	 */
	public Chunk getTopChunk() {
		return topChunk;
	}

	/**
	 * @param topChunk the chunk above
	 */
	public void setTopChunk(Chunk topChunk) {
		this.topChunk = topChunk;
	}

	/**
	 * @return the chunk below
	 */
	public Chunk getBottomChunk() {
		return bottomChunk;
	}

	/**
	 * @param bottomChunk the chunk below
	 */
	public void setBottomChunk(Chunk bottomChunk) {
		this.bottomChunk = bottomChunk;
	}

	public Chunk topLeftChunk() {
		return this.topChunk.leftChunk;
	}

	public Chunk topRightChunk() {
		return this.topChunk.rightChunk;
	}

	public Chunk bottomLeftChunk() {
		return this.bottomChunk.leftChunk;
	}

	public Chunk bottomRighChunk() {
		return this.bottomChunk.rightChunk;
	}

}
