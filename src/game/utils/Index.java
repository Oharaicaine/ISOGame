package game.utils;

import game.maths.FloatPolygon;
import game.maths.Vector3f;

public class Index {
	
	public static final float TILESIZE = 96f; 

	private Index(){}
	
	public static float[] vertcies(float size, float renderDepth){
		float[] vertices = new float[] {
				-size * 0.5f, (-size * 0.5f)+(size * 0.2f), renderDepth,
				-size * 0.5f,  (size * 0.5f)+(size * 0.2f), renderDepth,
				size * 0.5f,  (size * 0.5f)+(size * 0.2f), renderDepth,
				size * 0.5f, (-size * 0.5f)+(size * 0.2f), renderDepth
			};
	
		return vertices;
	}
	
	public static float[] verticesIsoTile(float size, float renderDepth){
		float[] vertices = new float[] {
				-size * 0.5f, 0f, renderDepth,
				0f,  size * 0.25f, renderDepth,
				size * 0.5f,  0f, renderDepth,
				0f, -size * 0.25f, renderDepth
			};
	
		return vertices;
	}
	
	public static float[] verticesIsoWall(float size, float renderDepth){
		float[] vertices = new float[] {
				-size * 0.5f, 0f, renderDepth,
				-size * 0.5f, (size * 1.25f), renderDepth,
				0f, (size * 1.25f) -(size * 0.25f), renderDepth,
				(size * 0.5f), (size * 1.25f), renderDepth,
				(size * 0.5f),  0f, renderDepth,
				0f, (-size * 0.25f), renderDepth,
				0f, (size * 1.25f) + (size * 0.25f), renderDepth
			};
	
		return vertices;
	}
	
	public static float[] vertciesWidthHeight(float width, float height, float renderDepth){
		float[] vertices = new float[] {
				-width / 2.0f, -height / 2.0f, renderDepth,
				-width / 2.0f,  height / 2.0f, renderDepth,
				width / 2.0f,  height / 2.0f, renderDepth,
				width / 2.0f, -height / 2.0f, renderDepth
			};
	
		return vertices;
	}
	
	public static byte[] indices(){
		byte[] indices = new byte[] {
				0, 1, 2,
				2, 3, 0
			};
		return indices;
	}
	public static byte[] wallIndices() {
		byte[] indices = new byte[] {
			1, 0, 2,
			0, 5, 2,
			5, 2, 3,
			5, 3, 4,
			1, 3, 6,
			1, 2, 3
		};
		return indices;
	}
			
	public static float[] tcs(){
		float[] tcs = new float[] {
				0, 1,
				0, 0,
				1, 0,
				1, 1
			};
		return tcs;
	}
	
	public static FloatPolygon polyRectangle(Vector3f pos, float size){
		float[] xPoints = new float[]{(float)(pos.x-(size*0.5)), (float)(pos.x+(size*0.5)), (float)(pos.x+(size*0.5)), (float)(pos.x-(size*0.5))};
		float[] yPoints = new float[]{(float)(pos.y+(size*0.5)), (float)(pos.y+(size*0.5)), (float)(pos.y-(size*0.5)), (float)(pos.y-(size*0.5))};
		FloatPolygon poly = new FloatPolygon(xPoints, yPoints, xPoints.length);
		return poly;
	}
	
	public static FloatPolygon polyIsoTile(Vector3f pos){
		float[] xPoints = new float[]{(float)(pos.x - (TILESIZE*0.5f)),pos.x,(float)(pos.x + (TILESIZE*0.5f)),pos.x};
		float[] yPoints = new float[]{pos.y,(float)(pos.y - (TILESIZE*0.3f)),pos.y,(float)(pos.y + (TILESIZE*0.3f))};
		FloatPolygon poly = new FloatPolygon(xPoints, yPoints, xPoints.length);
		return poly;
	}
	
	/*public static FloatPolygon polyWall(Vector3f pos){
		float[] xPoints = new float[]{};
		float[] yPoints = new float[]{};
		FloatPolygon poly = new FloatPolygon(xPoints, yPoints, xPoints.length);
		return poly;		
	}
*/
	
}
