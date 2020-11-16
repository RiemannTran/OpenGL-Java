package model;

import jgl.GL;
import jgl.GLAUX;
import jgl.GLU;
import jgl.glu.GLUquadricObj;

public class Bed {

	
	
	public void setMaterialColor(GL myGL,float ambien[], float diff_use[]) {
		myGL.glMaterialfv(GL.GL_FRONT_AND_BACK, GL.GL_AMBIENT, ambien);
		myGL.glMaterialfv(GL.GL_FRONT_AND_BACK, GL.GL_DIFFUSE, diff_use);

	};
	

	public void display(GL myGL,GLAUX myAUX,GLU myGLU,GLUquadricObj qobj) {
		
		float ambienTua[] = { 0.8f, 0.5f, 0.2f, 1.0f };
		float diff_useTua[] = { 0.2f, 0.4f, 0.3f, 1.0f };
		setMaterialColor(myGL, ambienTua, diff_useTua);
		myGL.glPushMatrix();// ngoisofa
		myAUX.auxSolidBox(7.5, 0.8, 6);
		myGL.glPopMatrix();
		
		float ambienNem[] = { 0.2f, 0.5f, 0.2f, 1.0f };
		float diff_useNem[] = { 0.2f, 0.4f, 0.3f, 1.0f };
		setMaterialColor(myGL, ambienNem, diff_useNem);
		myGL.glPushMatrix();// ngoisofa
		myGL.glTranslated(-0.5, 0.5, 0);
		myAUX.auxSolidBox(6.5, 0.2, 5);
		myGL.glPopMatrix();
		
		
		setMaterialColor(myGL, ambienTua, diff_useTua);
		myGL.glPushMatrix();// tuasofa
		myGL.glTranslated(3.5, 0.8, 0);
		myAUX.auxSolidBox(1.0, 2.5, 6);
		myGL.glPopMatrix();

		
	}

}
