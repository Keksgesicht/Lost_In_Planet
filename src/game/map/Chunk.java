package game.map;

public class Chunk {

	public Chunk leftChunk;
	public Chunk rightChunk;
	public Chunk topChunk;
	public Chunk bottomChunk;
	public final Block[][] blocks = new Block[16][16];
	
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
