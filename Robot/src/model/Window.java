package model;

import jgl.GL;
import jgl.GLAUX;
import jgl.GLU;
import jgl.glu.GLUquadricObj;

public class Window {
	
	public void setMaterialColor(GL myGL, float ambien[], float diff_use[]) {
		myGL.glMaterialfv(GL.GL_FRONT_AND_BACK, GL.GL_AMBIENT, ambien);
		myGL.glMaterialfv(GL.GL_FRONT_AND_BACK, GL.GL_DIFFUSE, diff_use);

	};
	
	public void display(GL myGL,GLAUX myAUX,GLU myGLU,GLUquadricObj qobj) {
		
	    myGL.glTranslatef(0.0f, 0.0f, -0.1f);
	    myAUX.auxSolidBox(0.05, 10, 0.1);
		
		myGL.glPushMatrix();
		myGL.glTranslatef(0.0f, -5.0f, -1.4f);
		
		float ambienCua[] = { 0.5f, 0.5f, 0.0f, 1.0f };
		float diff_useCua[] = { 0.5f, 0.5f, 0.0f, 1.0f };
		setMaterialColor(myGL, ambienCua, diff_useCua);
		myGL.glPushMatrix();//door
		
		myGL.glPushMatrix();
		myGL.glTranslatef(0f, 3.5f, -0.2f);
		myGL.glScaled(1, 1, 0.6);
		myAUX.auxSolidBox(0.2, 7, 4.9);		
		myGL.glPopMatrix();
		
		
		float ambien[] = { 1.0f, 1.0f, 1.0f, 1.0f };
		float diff_use[] = { 1.0f, 1.0f, 1.0f, 1.0f };
		setMaterialColor(myGL, ambien, diff_use);
		myGL.glPushMatrix();
		myGL.glTranslatef(0f, 3.5f, -1f);
		myGL.glScaled(1, 1, 0.6);
		myAUX.auxSolidBox(0.5, 0.5, 0.8);		
		myGL.glPopMatrix();
		
		float ambien1[] = { 1.0f, 0.0f, 1.0f, 1.0f };
		float diff_use1[] = { 1.0f, 1.0f, 0.0f, 1.0f };
		setMaterialColor(myGL, ambien1, diff_use1);
		myGL.glPushMatrix();
		myGL.glTranslatef(0f, 3.5f, -1f);
		myGL.glScaled(1, 1, 0.6);
		myAUX.auxSolidBox(1.0, 0.3, 0.2);		
		myGL.glPopMatrix();
		
		float ambien2[] = { 1.0f, 1.0f, 0.0f, 1.0f };
		float diff_use2[] = { 1.0f, 1.0f, 0.0f, 1.0f };
		setMaterialColor(myGL, ambien2, diff_use2);
		myGL.glPushMatrix();
		myGL.glTranslatef(-0.4f, 3.5f, -0.8f);
		myGL.glScaled(1, 1, 0.6);
		myAUX.auxSolidBox(0.1, 0.2, 2.0);		
		myGL.glPopMatrix();
		
		
		myGL.glPushMatrix();
		myGL.glTranslatef(0.0f, 5.0f, 1.2f);
		myGL.glScaled(1, 1, 0.6);
		myAUX.auxSolidBox(0.3, 0.4, 1.0);		
		myGL.glPopMatrix();
		
		myGL.glPushMatrix();
		myGL.glTranslatef(0.0f, 2.0f, 1.2f);
		myGL.glScaled(1, 1, 0.6);
		myAUX.auxSolidBox(0.3, 0.4, 1.0);		
		myGL.glPopMatrix();
		
		myGL.glPopMatrix();
		myGL.glPopMatrix();
    
	
}


}
