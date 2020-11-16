package model;

import jgl.GL;
import jgl.GLAUX;
import jgl.GLU;
import jgl.glu.GLUquadricObj;

public class Lamp {

	public Lamp() {
		// TODO Auto-generated constructor stub
	}
	
	public void setMaterialColor(GL myGL,float ambien[], float diff_use[]) {
		myGL.glMaterialfv(GL.GL_FRONT_AND_BACK, GL.GL_AMBIENT, ambien);
		myGL.glMaterialfv(GL.GL_FRONT_AND_BACK, GL.GL_DIFFUSE, diff_use);

	};
	

	public void display(GL myGL,GLAUX myAUX,GLU myGLU,GLUquadricObj qobj) {
		
	    qobj = myGLU.gluNewQuadric();
		
		myGL.glTranslated(0.0, 3.0, 2);
		
		myGL.glPushMatrix();
		
		float ambienDe[] = { 1.0f, 1.0f, 1.0f, 1.0f };
		float diff_useDe[] = { 1.0f, 1.0f, 1.0f, 1.0f };
		 setMaterialColor(myGL, ambienDe, diff_useDe);
		
		myGL.glPushMatrix();
		myGL.glTranslated(0.0, -1.5, 0.0);
		myAUX.auxSolidBox(1.5, 0.5, 1.5);
		myGL.glPopMatrix();
		
		
		float ambienCay[] = { 0.8f, 0.8f, 0.5f, 1.0f };
		float diff_useCay[] = { 0.8f, 0.5f, 0.3f, 1.0f };
		 setMaterialColor(myGL, ambienCay, diff_useCay);
		myGL.glPushMatrix();
		myGL.glTranslated(0.0, 0.5, 0.0);
		myAUX.auxSolidBox(0.7, 0.5, 1.0);
		myGL.glPopMatrix();
		myGL.glTranslated(0.0, 0.0, 0.0);
		myAUX.auxSolidBox(0.3, 3, 0.4);
		myGL.glPopMatrix();
		myGL.glRotatef((float) -90, 1.0f, 0.0f, 0.0f);
		
		
		float ambienDen[] = { 1.0f, 1.0f, 0.0f, 1.0f };
		float diff_useDen[] = { 1.0f, 1.0f, 0.0f, 1.0f };
		 setMaterialColor(myGL, ambienDen, diff_useDen);
		myGL.glPushMatrix();
		myGL.glScaled(0.5, 0.5, 0.5);
		myGLU.gluCylinder(qobj, 2.0, 1, 3, 32, 32);
		myGL.glPopMatrix();

		
	}
}
