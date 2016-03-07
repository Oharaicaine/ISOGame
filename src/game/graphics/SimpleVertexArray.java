package game.graphics;

import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.opengl.GL15.*;
import static org.lwjgl.opengl.GL20.*;
import static org.lwjgl.opengl.GL30.*;

import game.utils.BufferUtils;

public class SimpleVertexArray {

	private int vao, vbo, ibo;
	private int counts;

	
	public SimpleVertexArray(float[] vertices, byte[] indices) {
		counts = indices.length;
		
		vao = glGenVertexArrays();
		glBindVertexArray(vao);
		
		// Vertex buffer objects
		vbo = glGenBuffers();
		glBindBuffer(GL_ARRAY_BUFFER, vbo);
		glBufferData(GL_ARRAY_BUFFER, BufferUtils.createFloatBuffer(vertices), GL_STATIC_DRAW);
		glVertexAttribPointer(0, 2, GL_FLOAT, false, 0, 0);
		glEnableVertexAttribArray(Shader.VERTEX_ATTRIB);
		
		// Indices buffer objects
		ibo = glGenBuffers();
		glBindBuffer(GL_ELEMENT_ARRAY_BUFFER, ibo);
		glBufferData(GL_ELEMENT_ARRAY_BUFFER, BufferUtils.createByteBuffer(indices), GL_STATIC_DRAW);
		
		// unbind buffers after using them
		glBindBuffer(GL_ELEMENT_ARRAY_BUFFER, 0);
		glBindBuffer(GL_ARRAY_BUFFER, 0);
	}
	
	private void bind(){
		glBindVertexArray(vao);
		glBindBuffer(GL_ELEMENT_ARRAY_BUFFER, ibo);
	}
	private void unbind(){
		glBindVertexArray(0);
		glBindBuffer(GL_ELEMENT_ARRAY_BUFFER, 0);
	}
	
	private void draw(){
		//glDrawArrays();
	//	glPolygonMode(GL_FRONT_AND_BACK, GL_LINE);
		//glDrawArrays(GL_LINE_LOOP, 0, 6);
		//glDrawElements(GL_TRIANGLES, counts, GL_UNSIGNED_BYTE, 0);
		glDrawArrays(GL_LINE_LOOP, 0, 4);
	}
	
	public void render(){
		bind();
		draw();
		unbind();
	}

}
