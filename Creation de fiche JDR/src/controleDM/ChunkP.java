package controleDM;

import com.lowagie.text.Chunk;
import com.lowagie.text.Font;

public class ChunkP extends Chunk{
	
	String text;
	Font font;
	
	public ChunkP(String text, Font font) {
		super.setAnchor(text);
		
		this.font = font;
		super.setFont(font);
		
		
	}
}
